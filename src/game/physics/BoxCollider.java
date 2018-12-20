package game.physics;

import game.Vector2D;

public class BoxCollider {
    Vector2D position, anchor;
    int width;
    int height;

    public BoxCollider() {
        this(new Vector2D(),new Vector2D(), 1, 1);
    }

    public BoxCollider(Vector2D position, Vector2D anchor, int width, int height) {
        this.position = position;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public float bottom() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other) {
        return this.bottom() >= other.top()
                && this.top() <= other.bottom()
                && this.left() <= other.right()
                && this.right() >= other.left();
    }
}
