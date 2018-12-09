package game.enemy;

import game.GameObject;
import game.GameSettings;
import game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    int direction = 0;

    public Enemy() {
        super();
        this.position.set(0, 0);
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));

        this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        this.move();
//        this.limitEnemyMoveMent();

    }

//    public void limitEnemyMoveMent() {
//        int halfWidth = GameSettings.ENEMY_WIDTH / 2;
//        this.position.x = (float) Mathx.clamp(this.position.x, halfWidth, GameSettings.BACKGROUND_WIDTH - GameSettings.ENEMY_WIDTH + halfWidth);
//    }

        private void move() {
        if (this.position.x > GameSettings.BACKGROUND_WIDTH && direction == 0) {
//            this.position.addThis(-1, 1);
            direction = 1;
        }
        if (this.position.x < 0 && direction == 1) {
            direction = 0;
        }
        if (direction == 0) {
            this.position.addThis(1, 1);
        }
        if (direction == 1) {
            this.position.addThis(-1, 1);
        }
    }
}
