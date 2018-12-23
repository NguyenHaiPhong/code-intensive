package game.scene;

import game.Background;
import game.GameObject;
import game.enemy.EnemySummoner;
import game.player.Player;

public class SceneLv1 extends Scene {

    @Override
    public void init() {
        GameObject.controlGameObject(Background.class);
        GameObject.controlGameObject(Player.class);
        GameObject.controlGameObject(EnemySummoner.class);
        }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}