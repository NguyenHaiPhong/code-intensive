package game.scene;

import game.GameObject;
import game.GameSettings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class EndingBackground extends GameObject {
    public EndingBackground() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/scenes/game over (1).png"));
        this.position.set(GameSettings.SCREEN_WIDTH / 2, GameSettings.SREEN_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
    }
}
