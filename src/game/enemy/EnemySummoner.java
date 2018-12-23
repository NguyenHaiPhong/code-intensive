package game.enemy;

import game.FrameCounter;
import game.GameObject;

public class EnemySummoner extends GameObject {
    FrameCounter summonCounter;

    public EnemySummoner() {
        this.summonCounter = new FrameCounter(40);
    }

    @Override
    public void run() {
        super.run();
        if(this.summonCounter.run()) {
            Enemy enemy = GameObject.controlGameObject(Enemy.class);
            enemy.position.set(100, -30);
            summonCounter.reset();
        }
    }
}
