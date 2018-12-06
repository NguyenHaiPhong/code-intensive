package game;

import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public Renderer renderer;
    public Vector2D position;

    public GameObject() {
        this.position = new Vector2D(0, 0);
    }

    public void run() {

    }

    public void render(Graphics pen) {
        if(this.renderer != null) {
            this.renderer.render(pen, this);
        }
    }
}
