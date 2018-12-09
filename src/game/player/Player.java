package game.player;

import game.GameObject;
import game.GameSettings;
import game.GameWindow;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public Player(){
        super();
//        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200, 300);
        this.createRenderer();
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));

        this.renderer = new PlayerRenderer("Player name", images);
//        this.renderer = new Animation(images);
    }

    int count = 0; // TODO: se fix
    @Override
    public void run() {
        this.move();
        count++;
        if(count > 20) {
            this.fire();
        }
        this.limitPlayerPosition();
    }

    private void fire() {
        if(GameWindow.isFirePress) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            GameObject.addGameObject(bullet);
            count = 0;
        }
    }

    private void move() {
        if(GameWindow.isUpPress) {
            this.position.addThis(0, -4);
        }
        if(GameWindow.isDownPress) {
            this.position.addThis(0, 4);
        }
        if(GameWindow.isLeftPress) {
            this.position.addThis(-4, 0);
        }
        if(GameWindow.isRightPress) {
            this.position.addThis(4, 0);
        }
    }

    private void limitPlayerPosition() {
        int halfWidth = (int) (GameSettings.PLAYER_WIDTH * this.anchor.x);
        int halfHeight = (int) (GameSettings.PLAYER_HEIGHT * this.anchor.y);
        //limit x [0, game.Background.image.width] BACKGROUND_WIDTH
        float x = (float)Mathx.clamp(this.position.x, halfWidth,  GameSettings.BACKGROUND_WIDTH - halfWidth);
        //limit y [0, Screen.height]
        float y = (float)Mathx.clamp(this.position.y, halfHeight, GameSettings.SREEN_HEIGHT - halfHeight);
        this.position.set(x, y);
    }
}
