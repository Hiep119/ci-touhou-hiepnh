package bases;

import bases.physics.BoxCollider;
import touhou.enemies.Enemies;
import touhou.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public float x;
    public float y;
    protected BufferedImage image;
    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.render(graphics);
        }
    }

    public static void addAll(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public static Enemies collideWidth(BoxCollider boxCollider) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Enemies) {
                Enemies enemies = (Enemies) gameObject;
                if (enemies.boxCollider.collideWidhth(boxCollider)) {
                    return enemies;
                }
            }
        }

        return null;
    }

    public static Player collideWidth2(BoxCollider boxCollider) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Player) {
                Player player = (Player) gameObject;
                if (player.boxCollider.collideWidhth(boxCollider)) {
                    return player;
                }
            }
        }
        return null;
    }

    public GameObject() {
            position = new Vector2D();
            isActive = true;

        }

    public void run() {

    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image,
                    (int) (position.x - image.getWidth() / 2),
                    (int) (position.y - image.getHeight() / 2),
                    null);
        }
    }


}
