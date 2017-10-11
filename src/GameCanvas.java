import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background; // copy ảnh từ ổ cứng vào ram (biến)
    BufferedImage players;

    public GameCanvas() {

        //1. Load background
        try { // thử xem link lỗi ko?
            background = ImageIO.read(new File("assets/images/background/0.png"));
            players = ImageIO.read(new File("assets/images/players/straight/5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //2. Draw background

    @Override
    protected void paintComponent(Graphics g) { // vẽ component >> component con
        g.drawImage(background, 0, 0, null);
        g.drawImage(players, 175, 520, null);

    }
}
