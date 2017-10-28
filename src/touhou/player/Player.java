package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.Clamp;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.Inputs.InputManager;

import java.awt.event.KeyEvent;
import java.util.Random;


public class Player extends GameObject implements PhysicsBody{

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 375;
    final int TOP = 0;
    final int BOTTOM = 500;

    PlayerCastSpell castSpell;

    public BoxCollider boxCollider;


    Random rd = new Random();

    public Player() {
        castSpell = new PlayerCastSpell();
        position.setVector(182, 500);
        boxCollider = new BoxCollider(8, 8);
        boxCollider.position.setVector(this.position);
        image = Utils.loadImage("assets/images/players/straight/0.png");

    }


    public void run() {


        boxCollider.position.setVector(this.position);
        castSpell.run(this);
        move();

    }



    public void move() {
        Vector2D velocity = new Vector2D();
        velocity.setVector(0, 0);

        InputManager inputManager = InputManager.instance;

        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }

        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
        }

        if(inputManager.downPressed) {
            velocity.y += SPEED;
        }

        if(inputManager.upPressed) {
            velocity.y -= SPEED;
        }

        position.x += velocity.x;
        position.y += velocity.y;

        position.x = (int)Clamp.clamp(position.x, LEFT, RIGHT);
        position.y = (int)Clamp.clamp(position.y, TOP, BOTTOM);


    }



    public void shoot() {

    }


    public void getHit() {
        isActive = false;
        System.out.println("Thua");
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
