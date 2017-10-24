package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.player.Player;

import java.awt.*;
import java.util.Random;

import static com.sun.javafx.util.Utils.clamp;

public class Enemies extends Player {

    final int SPEED = 2;
    Random rd = new Random();
    public BoxCollider boxCollider;

    public Enemies() {
        boxCollider = new BoxCollider(30, 30);
        image = Utils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.setVector(image.getWidth() / 2, image.getHeight() / 2);
    }



    @Override
    public void run() {
        position.addUp(0, 2);
        boxCollider.position.setVector(this.position);

       shoot();
    }

    public void shoot() {
        EnemiesBullet enemiesBullet = new EnemiesBullet();
        enemiesBullet.position.setVector(this.position);


        if(spellDisabled) {
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if(rd.nextInt(20) == 3) {
            spellDisabled = true;
            GameObject.addAll(enemiesBullet);
        }




    }

    public void getHit() {
        isActive = false;
    }

}
