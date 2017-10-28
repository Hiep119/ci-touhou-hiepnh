import bases.GameObject;
import touhou.*;
import touhou.enemies.Enemies;
import touhou.enemies.EnemySpawner;
import touhou.player.Player;
import touhou.player.Sphere1;
import touhou.player.Sphere2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 10/11/17.
 */
public class GameCanvas extends JPanel {


    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    Enemies enemies = new Enemies();
    EnemySpawner enemySpawner = new EnemySpawner();
    BackGround backGround = new BackGround();
    Sphere1 sphere1 = new Sphere1();
    Sphere2 sphere2 = new Sphere2();

    public GameCanvas() {
        //1. Create back buffer

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics(); //  lấy bút

        // 2. Load Background

        GameObject.addAll(backGround);
        GameObject.addAll(player);
        GameObject.addAll(enemies);
        GameObject.addAll(enemySpawner);
        GameObject.addAll(sphere1);
        GameObject.addAll(sphere2);
    }

    public void render() {
        //1. Draw everything on back buffer

        GameObject.renderAll(backGraphics);


        //2. Call repaint

        repaint();
    }

    //2. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }



    public void run() {
       GameObject.runAll();

    }


}
