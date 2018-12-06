package game;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameCanvas extends JPanel{
    Background background;
    Player player;
    Text text;
    static ArrayList<PlayerBullet> playerBullets;
    
    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        this.text = new Text();
        this.playerBullets = new ArrayList<>();
    }

    @Override
    public void paint(Graphics pen) {
        pen.setColor(Color.WHITE);
        pen.fillRect(0, 0, 800, 600);
        this.background.render(pen);
        this.text.render(pen);
        this.player.render(pen);
        for(int i = 0; i < this.playerBullets.size(); i++) {
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.render(pen);
        }
    }

    public void runAll() {
        //
        this.background.run();
        this.player.run();
        for(int i = 0; i < this.playerBullets.size(); i++) {
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.run();
        }
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
