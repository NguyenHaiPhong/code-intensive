package game.scene;

import game.GameObject;

public class OpeningScene extends Scene {
    @Override
    public void init() {
        OpeningBackground background = GameObject.controlGameObject(OpeningBackground.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
