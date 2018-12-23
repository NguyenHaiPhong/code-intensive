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
    boolean blinking;

    public PlayerRenderer(String text, ArrayList<BufferedImage> images) {
//        this.textRenderer = new TextRenderer(text);
        this.animation = new Animation(images);
        this.blinking = false;
    }

    @Override
    public void render(Graphics pen, GameObject master) {
//        this.textRenderer.render(pen, master);
        Player player = (Player) master;
        if (player.immune) {
            if (this.blinking) {
                this.animation.render(pen, master);
            }
            this.blinking = !this.blinking;
        } else {
            this.animation.render(pen, master);
        }
    }
}
