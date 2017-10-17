package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class PlayerSpell {
    BufferedImage imageBullet;
    public int x;
    public int y;
    final int SPEED = 10;


    public PlayerSpell() {
        imageBullet = Utils.loadImage("assets/images/player-bullets/a/1.png");

    }

    public void render(Graphics gBullet) {
        gBullet.drawImage(imageBullet, x, y, null);
    }



    public void run() {
        y -= SPEED;
    }
}
