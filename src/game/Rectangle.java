package game;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle() {
        this(new Vector2D(), 1, 1);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Rectangle other) {
        if (this.position.x + this.width < other.position.x ||
            other.position.x + other.width < this.position.x ||
            this.position.y + this.height < other.position.y ||
            other.position.y + other.height < this.position.y) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(5, 5), 3, 3);
        Rectangle rect2 = new Rectangle(new Vector2D(4, 4), 3, 3);
        Rectangle rect3 = new Rectangle(new Vector2D(10, 10), 3, 3);
        System.out.println(String.format("rect1 intersects rect2: %s (correct: true)", rect1.intersects(rect2)));
        System.out.println(String.format("rect2 intersects rect1: %s (correct: true)", rect2.intersects(rect1)));
        System.out.println(String.format("rect1 intersects rect3: %s (correct: false)", rect1.intersects(rect3)));
        System.out.println(String.format("rect3 intersects rect2: %s (correct: false)", rect3.intersects(rect2)));
    }
}
