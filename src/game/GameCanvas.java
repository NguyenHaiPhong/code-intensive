package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;
import game.scene.EndingScene;
import game.scene.OpeningScene;
import game.scene.SceneManager;

import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{

    public GameCanvas() {
//        GameObject.addGameObject(new Background());
//        GameObject.controlGameObject(Background.class);
//        GameObject.addGameObject(new Player());
//        GameObject.controlGameObject(Player.class);
//        GameObject.addGameObject(new Enemy());
//        GameObject.controlGameObject(EnemySummoner.class);
//        GameObject.addGameObject();
        SceneManager.signNewScene(new OpeningScene());
    }

    @Override
    public void paint(Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, 800, 600);
        GameObject.renderAll(pen);
    }

    public void runAll() {
        GameObject.runAll();
    }

    public void renderAll() {
        this.repaint(); // ~ paint()
    }

    public void gameLoop() {
        long lastTimeRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTimeRun > 1000 / 60) {
                runAll(); // logic game
                renderAll(); // hien thi game
                lastTimeRun = currentTime;
            }
        }
    }
}
