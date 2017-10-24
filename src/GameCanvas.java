import bases.GameObject;
import touhou.*;
import touhou.enemies.Enemies;
import touhou.enemies.EnemySpawner;
import touhou.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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

    public GameCanvas() {
        //1. Create back buffer

        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics(); //  lấy bút

        // 2. Load Background

        GameObject.addAll(backGround);
        GameObject.addAll(player);
        GameObject.addAll(enemies);
        GameObject.addAll(enemySpawner);
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


    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }


    public void keyReleased(KeyEvent e) {
       player.keyReleased(e);

    }

    public void run() {
       GameObject.runAll();

    }


}
