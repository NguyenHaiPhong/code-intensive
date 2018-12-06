package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;

    public Animation(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
    }

    int count = 0;
    @Override
    public void render(Graphics pen, GameObject master) {
        BufferedImage image = this.images.get(this.currentImageIndex);
        pen.drawImage(image, (int)master.position.x, (int)master.position.y, null);

        count++;
        if(count > 10) {
            this.currentImageIndex++;
            if(this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            count = 0;
        }
    }
}
