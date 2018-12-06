package game.renderer;

import game.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {
    int size;
    String content;

    @Override
    public void render(Graphics pen, GameObject master) {
        pen.drawString(this.content, (int)master.position.x, (int)master.position.y);
    }
}
