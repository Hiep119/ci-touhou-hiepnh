package touhou.player;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

public class Sphere1 extends GameObject implements PhysicsBody {

    public BoxCollider boxCollider;
    Player player = new Player();
    PlayerCastSpell newSpell;

    final int Dis = 40;

    public Sphere1() {
        newSpell = new PlayerCastSpell();
        image = Utils.loadImage("assets/images/sphere/0.png");
        position.setVector(player.position.subtract(Dis, 0));
        this.boxCollider = new BoxCollider(15,15);

    }

    public void run() {

        boxCollider.position.setVector(this.position);
        this.player.move();
        newSpell.run(this);
        position.setVector(player.position.subtract(Dis, 0));
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
