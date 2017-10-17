package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;



public class EnemiesBullet {

    BufferedImage imageEB;
    final int SPEED = 5;
    public int x;
    public int y;

    Random rd = new Random();

    public EnemiesBullet() {
        imageEB = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void render(Graphics graphicsEB) {
        graphicsEB.drawImage(imageEB, x, y, null );
    }

    public void run() {
        x += rd.nextInt(10);
        y += SPEED;

        x = (int)clamp(x,0, 350);
    }
    public float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }

        if (value > max) {
            return max;
        }

        return value;
    }


}
