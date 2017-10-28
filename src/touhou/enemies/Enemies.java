package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.player.Player;
import touhou.player.PlayerCastSpell;

import java.util.Random;

public class Enemies extends Player implements PhysicsBody {

    final int SPEED = 2;
    Random rd = new Random();
    public BoxCollider boxCollider;
    PlayerDamage playerDamage;
    public int coolDownCount;
    public boolean spellDisabled;
    public final int COOL_DOWN_TIME = 5;

    public Enemies() {
        boxCollider = new BoxCollider(30, 30);
        image = Utils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.setVector(image.getWidth() / 2, image.getHeight() / 2);
        this.playerDamage = new PlayerDamage();
    }



    @Override
    public void run() {
        position.addUp(0, 2);
        boxCollider.position.setVector(this.position);

        this.playerDamage.run(this);
       shoot();
    }

    public void shoot() {




        if(spellDisabled) {
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if(rd.nextInt(20) == 3) {
            spellDisabled = true;
            EnemiesBullet enemiesBullet = GameObject.recycle(EnemiesBullet.class);
            enemiesBullet.position.setVector(this.position);
        }




    }

    public void getHit() {
        isActive = false;
    }


    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
