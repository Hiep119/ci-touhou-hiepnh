package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedMap;

import static com.sun.javafx.util.Utils.clamp;

public class Enemies extends GameObject {

    final int SPEED = 2;
    Random rd = new Random();

    public Enemies() {
        image = Utils.loadImage("assets/images/enemies/level0/pink/0.png");
    }


    public void run() {
        int a = -10 + rd.nextInt(20);
        x += a;
        y += SPEED;

        x = (int)clamp(x, 0, 350);
        shoot();
    }

    public void shoot() {

        if(rd.nextInt(15) == 3) {
            EnemiesBullet newBullet = new EnemiesBullet();
            newBullet.x =  x;
            newBullet.y =  y;

           GameObject.addAll(newBullet);

        }

    }



}
