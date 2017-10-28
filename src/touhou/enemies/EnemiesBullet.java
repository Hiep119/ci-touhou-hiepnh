package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static bases.Clamp.clamp;


public class EnemiesBullet extends GameObject implements PhysicsBody{


    final int SPEED = 5;
    public BoxCollider boxCollider;

    Random rd = new Random();

    public EnemiesBullet() {
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(15, 15);
    }


    public void run() {
        position.x += rd.nextInt(10);
        position.y += SPEED;

        position.x = (int)clamp(position.x,0, 360);
        boxCollider.position.setVector(this.position);

        Player player = GameObject.collideWidth(this.boxCollider, Player.class);
        if(player != null) {
            player.getHit();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
