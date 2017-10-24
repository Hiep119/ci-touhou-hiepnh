package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.Clamp;
import bases.physics.BoxCollider;

import java.awt.event.KeyEvent;
import java.util.Random;


public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 375;
    final int TOP = 0;
    final int BOTTOM = 500;

    public boolean spellDisabled;
    public final int COOL_DOWN_TIME = 5;

    public BoxCollider boxCollider;


    Random rd = new Random();

    public Player() {
        position.setVector(182, 500);
        boxCollider = new BoxCollider(20, 20);
        image = Utils.loadImage("assets/images/players/straight/0.png");
        spellDisabled = false;
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    public void run() {
        boxCollider.position.setVector(this.position);
        shoot();
        move();

    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.setVector(0, 0);


        if (rightPressed) {
            velocity.x += SPEED;
        }

        if (leftPressed) {
            velocity.x -= SPEED;
        }

        if(downPressed) {
            velocity.y += SPEED;
        }

        if(upPressed) {
            velocity.y -= SPEED;
        }

        position.x += velocity.x;
        position.y += velocity.y;

        position.x = (int)Clamp.clamp(position.x, LEFT, RIGHT);
        position.y = (int)Clamp.clamp(position.y, TOP, BOTTOM);

        position.addUp(0, 0);
    }

    public int coolDownCount;

    public void shoot() {
        if(spellDisabled) {
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if(xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.setVector(this.position);

            GameObject.addAll(newSpell);
            spellDisabled = true;
        }
    }


    public void getHit() {
        isActive = false;
        System.out.println("Thua");
    }
}
