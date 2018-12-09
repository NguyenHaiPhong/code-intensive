package game;

import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
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

    //
    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;

    public GameObject() {
        this.position = new Vector2D(0, 0);
        this.anchor = new Vector2D(0.5f, 0.5f);
    }

    public void run() {

    }

    public void render(Graphics pen) {
        if(this.renderer != null) {
            this.renderer.render(pen, this);
        }
    }
}
