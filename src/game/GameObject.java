package game;

import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public static <E extends GameObject> E findDeactivatingGameObject(Class<E> clazz) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (!object.active && clazz.isAssignableFrom(object.getClass())) {
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersectedBoxes(Class<E> clazz, BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active
                    && clazz.isAssignableFrom(object.getClass())
                    && object instanceof Physics
                    && ((Physics)object).getBoxCollider().intersects(boxCollider)) // cast object sang Physics, kiem tra object.getBoxCollider giao voi boxColljder truyen vao
                 {
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E controlGameObject(Class<E> clazz) {
        E finding = findDeactivatingGameObject(clazz);
        if (finding != null) {
            finding.reactivate();
            return finding;
        }
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return newInstance;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void runAll() {
        System.out.println(gameObjects.size());
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void renderAll(Graphics pen) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.render(pen);
            }
        }
    }

    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;
    public boolean active;

    public GameObject() {
        this.position = new Vector2D(0, 0);
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity = new Vector2D();
        this.active = true;
    }

    public void run() {
        this.position.addThis(velocity);
    }

    public void render(Graphics pen) {
        if (this.renderer != null) {
            this.renderer.render(pen, this);
        }
    }

    public void deactivate() {
        this.active = false;
    }

    public void reactivate() {
        this.active = true;
    }
}
