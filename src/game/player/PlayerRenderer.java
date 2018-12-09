package game.player;

import game.GameObject;
import game.renderer.Animation;
import game.renderer.Renderer;
import game.renderer.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerRenderer extends Renderer {
//    Renderer textRenderer;
    Renderer animation;

    public PlayerRenderer(String text, ArrayList<BufferedImage> images) {
//        this.textRenderer = new TextRenderer(text);
        this.animation = new Animation(images);
    }

    @Override
    public void render(Graphics pen, GameObject master) {
//        this.textRenderer.render(pen, master);
        this.animation.render(pen, master);
    }
}
