package game.enemy;

import game.GameObject;
import game.GameObjectPhysics;
import game.GameSettings;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObjectPhysics {
    int damage;

    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, 3);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 6, 6);
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y > GameSettings.SREEN_HEIGHT) {
            this.deactivate();
        }
        this.checkIntersect();
    }

    private void checkIntersect() {
        Player player = GameObject.findIntersectedBoxes(Player.class, this.boxCollider);
            if (player != null) {
                this.deactivate();
                player.takeDamage(this.damage);
            }
    }
}
