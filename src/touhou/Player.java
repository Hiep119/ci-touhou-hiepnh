package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import static com.sun.javafx.util.Utils.clamp;

public class Player {
    public int X = 182;
    public int Y = 500;
    BufferedImage image;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int BOTTOM = 500;

    Random rd = new Random();

    public Player() {
        image = Utils.loadImage("assets/images/players/straight/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, X, Y, null);
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
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += SPEED;
        }

        if (leftPressed) {
            vx -= SPEED;
        }

        if(downPressed) {
            vy += SPEED;
        }

        if(upPressed) {
            vy -= SPEED;
        }

        X += vx;
        Y += vy;

        X = (int)clamp(X, LEFT, RIGHT);
        Y = (int)clamp(Y, TOP, BOTTOM);
    }

    public void shoot(ArrayList<PlayerSpell> spells) {
        if(xPressed && rd.nextInt(3) == 1) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = X;
            newSpell.y = Y;

            spells.add(newSpell);
        }
    }



}
