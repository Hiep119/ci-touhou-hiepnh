import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {

    GameCanvas canvas;
    long lastTimeUpdate; // thời gian repaint gần nhất

    public GameWindow() {
        this.setSize(800, 600);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas); // cho canvas vào khung

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // thoát >> giải phóng bộ nhớ.
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        }); // cách 1
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    // cách 2: tắt màn (nếu không có vẫn chạy ngầm)

        this.setResizable(false); // không cho resize màn hình lúc di chuyển

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                canvas.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.keyReleased(e);
            }
        });

        this.canvas.setVisible(true);
        this.setVisible(true);  // setVisible con trước
        lastTimeUpdate = System.nanoTime();


        //this.canvas.repaint(); // báo cho canvas vẽ lại (khi ko thấy canvas vẽ)

    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeUpdate >= 17000000) { // đo thời gian để repaint (phù hợp với từng loại máy)
                canvas.run();
                canvas.render();
                lastTimeUpdate = currentTime;
            }
        }

    }
}