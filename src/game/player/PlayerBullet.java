package game.player;

import game.GameObject;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider boxCollider;

    public PlayerBullet() {
        super();
        this.createRenderer();
        this.velocity.set(0, -3);
//        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));

        this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y < -20) {
            this.deactivate();
        }
        this.checkIntersect();
    }

    private void checkIntersect() {
        Enemy enemy = GameObject.findIntersectedBoxes(Enemy.class, this.boxCollider);
        System.out.println(enemy);
        if (enemy != null) {
            this.deactivate();
            enemy.deactivate();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
