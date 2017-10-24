package bases.physics;

import bases.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width, float height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left() {
        return position.x - width / 2;
    }

    public float right() {
        return position.x + width / 2;
    }

    public float top() {
        return position.y - height / 2;

    }

    public float bottom() {
        return position.y + height / 2;
    }

    public boolean collideWidhth(BoxCollider other) {
        boolean xOverlap = other.right() >= this.left() && other.left() <= this.right();
        boolean yOverlap = other.bottom() >= this.top() && other.top() <= this.bottom();
        return xOverlap && yOverlap;
    }

}
