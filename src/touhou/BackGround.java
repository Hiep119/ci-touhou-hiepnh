package touhou;

import bases.GameObject;
import bases.Utils;

public class BackGround extends GameObject{
    final int TOP = 0;
    final int BOTTOM = -2500;

    public BackGround() {
        image = Utils.loadImage("assets/images/background/0.png");
        position.setVector(image.getWidth() / 2, TOP);
    }


    public void run() {
        y += 10;
        y = (int) clamp(y, BOTTOM, TOP);
    }

    private float clamp(float value, float min, float max) {
        if (value > max) {
            return min;
        }
        return value;
    }
}
