package game.scene;

import game.GameObject;

public class EndingScene extends Scene {
    @Override
    public void init() {
        EndingBackground background = GameObject.controlGameObject(EndingBackground.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
