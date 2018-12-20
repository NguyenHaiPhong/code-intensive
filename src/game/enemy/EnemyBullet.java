package game.enemy;

import game.GameObject;
import game.GameSettings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    BoxCollider boxCollider;

    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, 3);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y > GameSettings.SREEN_HEIGHT) {
            this.deactivate();
        }
    }
}
