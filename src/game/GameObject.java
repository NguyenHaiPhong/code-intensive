package game;

import game.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public static <E extends GameObject> E createGameObject(Class<E> clazz) {
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return newInstance;
        } catch (Exception ex) {
            return null;
        }

    }

    public static void runAll() {
        for (int i = 0;i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.run();
        }
    }

    public static void renderAll(Graphics pen) {
        for (int i = 0;i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.render(pen);
        }

    }

    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;

    public GameObject() {
        this.position = new Vector2D(0, 0);
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity = new Vector2D();
    }

    public void run() {
        this.position.addThis(velocity);
    }

    public void render(Graphics pen) {
        if(this.renderer != null) {
            this.renderer.render(pen, this);
        }
    }
}
