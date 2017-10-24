package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.enemies.Enemies;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class PlayerSpell extends GameObject{

    final int SPEED = 10;
    public BoxCollider boxCollider;


    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(20, 20);
    }

    public void run() {
        this.position.subtractBy(0, SPEED);
        boxCollider.position.setVector(this.position);

        Enemies enemies = GameObject.collideWidth(this.boxCollider);
        if(enemies != null) {
           enemies.getHit();
           this.isActive = false;
        }
    }
}
