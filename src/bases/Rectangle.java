package bases;

public class Rectangle {

    public Rectangle(){

    }

    int x1, x2, x3 ,x4;
    int y1, y2, y3, y4;

    public boolean overlaps() {

        int leftX = Math.max(x1, x3);

        int rightX = Math.min(x2, x4);

        int botY = Math.max(y1, y3);

        int topY = Math.min(y2, y4);

        if (rightX > leftX && topY > botY) {
            return true;
        }else {return false;}

    }

}
