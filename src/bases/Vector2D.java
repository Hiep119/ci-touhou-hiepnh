package bases;


public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);

    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2D(float x, float y) {

        this.x = x;
        this.y = y;
    }

    public void setVector(Vector2D vector2D){
       this.x = vector2D.x;
       this.y = vector2D.y;
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    private void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }
    private void addUp(Vector2D vector2D) {
        this.x += vector2D.x;
        this.y += vector2D.y;
    }

    public static void print(Vector2D vector2D) {
        System.out.println(vector2D);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);

    }
    public Vector2D add(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D subtractBy(Vector2D vector2D) {
       return this.subtractBy(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float x, float y) {
        return this.clone().subtractBy(x, y);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return this.subtract(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float factor) {
        return new Vector2D(this.x * factor, this.y * factor);
    }


    public static void main(String[] args) {
        Vector2D v = new Vector2D();

        Vector2D v2 = new Vector2D(1, 5);
        print(v2);

        Vector2D v3 = new Vector2D(10, -1);

        v2.addUp(1, 2);
        print(v2);

        v3.addUp(v2);
        print(v3);
        print(v2);

        Vector2D v4 = v3.clone().subtractBy(2, 3);
        print(v4);
        print(v3);




    }




}
