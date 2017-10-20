package bases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public float x;
    public float y;
    protected BufferedImage image;
    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for(GameObject gameObject: gameObjects) {
            gameObject.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

    }

    public static void renderAll(Graphics graphics) {
        for(GameObject gameObject: gameObjects) {
            gameObject.render(graphics);
        }
    }

    public static void addAll(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public GameObject() {


    }

    public void run() {

    }

    public void render(Graphics g) {
        if(image != null) {
            g.drawImage(image, (int)x, (int)y, null);
        }
    }




}
