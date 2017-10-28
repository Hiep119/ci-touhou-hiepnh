package touhou.player;

import bases.Utils;
import bases.physics.BoxCollider;

public class Sphere2 extends Sphere1 {

    BoxCollider boxCollider;
    PlayerCastSpell newSpell = new PlayerCastSpell();
    public Sphere2() {
        image = Utils.loadImage("assets/images/sphere/1.png");
        position.setVector(player.position.add(Dis, 0));
        this.boxCollider = new BoxCollider(15, 15);
    }

    @Override
    public void run() {
        boxCollider.position.setVector(this.position);
        this.player.move();
        newSpell.run(this);
        position.setVector(player.position.add(Dis, 0));
    }
}
