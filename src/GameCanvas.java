import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background; // copy ảnh từ ổ cứng vào ram (biến)
    BufferedImage player;

    int playerX = 182;
    int playerY = 520;

    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;

    BufferedImage backBuffer;
    Graphics backGraphics;


    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB); //ARGB = alpha, alpha càng lớn thì càng đục, ngược lại thì trong suốt
        backGraphics = backBuffer.getGraphics(); // lấy bút
        //2. Load background
        try { // thử xem link lỗi ko?
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void render() {
        //1. Draw everything on back buffer (mỗi khung có một bút riêng) (bút trước là g, bút sau là backGraphics)
        backGraphics.drawImage(background, 0, 0, null);
        backGraphics.drawImage(player, playerX, playerY, null);
        //2. Call repaint
        repaint();
    }


    //3. Draw background


    @Override
    public void paintComponents(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    @Override
    protected void paintComponent(Graphics g) { // vẽ component >> component con
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, playerX, playerY, null);

    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerX += 5;
            rightPressed = true; // lưu vị trí
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            playerX -= 5;
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            playerY -=5;
            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            playerY += 5;
            downPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerX += 5;
            rightPressed = false; // lưu vị trí
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            playerX -= 5;
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            playerY -=5;
            upPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            playerY += 5;
            downPressed = false;
        }


    }

    public void run() {
        int dx = 0;
        int dy = 0;

        if(rightPressed) {
            dx += 5;
        }
        if(leftPressed) {
            dx -= 5;
        }
        playerX = playerX + dx;

        if(upPressed) {
            dy -= 5;
        }
        if(downPressed) {
            dy += 5;
        }
        playerY = playerY + dy;

    }



}
