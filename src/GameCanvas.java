import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background; // copy ảnh từ ổ cứng vào ram (biến)
    BufferedImage player;
    BufferedImage backBuffer;
    BufferedImage enemies;
    Graphics backGraphics;

    int playerX = 182;
    int playerY = 520;
    int backgroundX = 0;
    int backgroundY = -2600;
    int enemiesX = 0;
    int enemiesY = 0;

    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;


    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB); //ARGB = alpha, alpha càng lớn thì càng đục, ngược lại thì trong suốt
        backGraphics = backBuffer.getGraphics(); // lấy bút
        //2. Load background
        try { // thử xem link lỗi ko?
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/5.png"));
            enemies =ImageIO.read(new File("assets/images/enemies/level0/pink/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void render() {
        //1. Draw everything on back buffer (mỗi khung có một bút riêng) (bút trước là g, bút sau là backGraphics)
        backGraphics.drawImage(background, 0, backgroundY, null);
        backGraphics.drawImage(player, playerX, playerY, null);
        backGraphics.drawImage(enemies, enemiesX, enemiesY, null);

        //2. Call repaint
        if(backgroundY == 0) {
            backgroundY -= 2600;
        }else {
            backgroundY += 5;
        }
        enemiesY += 3;
        repaint();
    }


    //3. Draw background
    @Override
    public void paintComponents(Graphics g) {
        g.drawImage(backBuffer, 0, backgroundY, null);
    }

    @Override
    protected void paintComponent(Graphics g) { // vẽ component >> component con
        g.drawImage(background, 0, backgroundY, null);
        g.drawImage(player, playerX, playerY, null);
        g.drawImage(enemies, enemiesX, enemiesY, null);

    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true; // lưu vị trí
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false; // lưu vị trí
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }


    }

    public void run() {
        int dx = 0;
        int dy = 0;

        if (rightPressed) {
            if (playerX < 350) {
                dx += 5;
            }
        }
        if (leftPressed) {
            if(playerX > 0) {
                dx -= 5;
            }
        }
        playerX = playerX + dx;


        if (upPressed) {
            if(playerY > 0) {
                dy -= 5;
            }
        }
        if (downPressed) {
            if(playerY < 520) {
                dy += 5;
            }
        }
        playerY = playerY + dy;


    }


}
