package game.renderer;

import game.FrameCounter;
import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    FrameCounter nextImageCounter;
    boolean isOnce;

    public Animation(ArrayList<BufferedImage> images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCounter = new FrameCounter(14);
    }

    public Animation(ArrayList<BufferedImage> images, boolean isOnce) {
        this(images);
        this.isOnce = isOnce;
    }

    int count = 0;
    @Override
    public void render(Graphics pen, GameObject master) {
        BufferedImage image = this.images.get(this.currentImageIndex);
        pen.drawImage(image, (int)(master.position.x - image.getWidth() * master.anchor.x), (int)(master.position.y - image.getHeight() * master.anchor.y), null);
        if(this.nextImageCounter.run()) {
            this.currentImageIndex++;
            if(this.isOnce && this.currentImageIndex >= this.images.size()) {
                master.deactivate();
            }
            if(this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }

    }
}
