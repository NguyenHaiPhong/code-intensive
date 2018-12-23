package game.scene;

import game.GameObject;
import game.GameSettings;
import game.GameWindow;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class OpeningBackground extends GameObject {
    public OpeningBackground() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/49094894_2068334896614329_8354550592969900032_n.jpg"));
        this.position.set(GameSettings.SCREEN_WIDTH / 2, GameSettings.SREEN_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneLv1());
        }
    }
}
