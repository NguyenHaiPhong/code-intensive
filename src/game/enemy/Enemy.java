package game.enemy;

import game.FrameCounter;
import game.GameObject;
import game.GameObjectPhysics;
import game.GameSettings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObjectPhysics {
    FrameCounter fireCounter;

    public Enemy() {
        super();
        this.createRenderer();
        this.velocity.set(3, -1);
        this.fireCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
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
        super.run();
        this.move();
        if (this.fireCounter.run()) {
            this.fire();
        }
    }

    private void move() {
        if (this.position.x > GameSettings.BACKGROUND_WIDTH - GameSettings.ENEMY_WIDTH / 2  && this.velocity.x > 0) {
            this.velocity.set(-3, this.velocity.y);
        }
        if (this.position.x < 14 && this.velocity.x < 0) {
            this.velocity.set(3, this.velocity.y);
        }
        if (this.position.y > GameSettings.SREEN_HEIGHT - GameSettings.ENEMY_HEIGHT / 2 && this.velocity.y > 0) {
            this.velocity.set(this.velocity.x, -1);
        }
        if (this.position.y < GameSettings.ENEMY_HEIGHT / 2 && this.position.y < 0) {
            this.velocity.set(this.velocity.x, 1);
        }
    }

    public void fire() {
        EnemyBullet bullet = GameObject.controlGameObject(EnemyBullet.class);
        bullet.position.set(this.position.x, this.position.y);
        this.fireCounter.reset();
    }

    @Override
    public void deactivate() {
        super.deactivate();
        EnemyExplosion explosion = GameObject.controlGameObject(EnemyExplosion.class);
        explosion.position.set(this.position);
    }
}
