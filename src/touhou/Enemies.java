package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedMap;

import static com.sun.javafx.util.Utils.clamp;

public class Enemies {
    BufferedImage imageEnemies;
    public int x = 0;
    public int y = 0;
    final int SPEED = 2;
    Random rd = new Random();

    public Enemies() {
        imageEnemies = Utils.loadImage("assets/images/enemies/level0/pink/0.png");
    }

    public void render(Graphics graphicsEnemies) {
        graphicsEnemies.drawImage(imageEnemies, x, y, null);
    }

    public void run() {
        int a = -10 + rd.nextInt(20);
        x += a;
        y += SPEED;

        x = (int)clamp(x, 0, 350);
    }

    public void shoot(ArrayList<EnemiesBullet> bullets) {

        if(rd.nextInt(15) == 3) {
            EnemiesBullet newBullet = new EnemiesBullet();
            newBullet.x = x;
            newBullet.y = y;

            bullets.add(newBullet);

        }

    }



}
