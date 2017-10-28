package touhou.player;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.Inputs.InputManager;
import touhou.enemies.Enemies;

import java.awt.event.KeyEvent;

public class PlayerCastSpell {
    public int coolDownCount;
    public boolean spellDisabled;
    public final int COOL_DOWN_TIME = 5;

    public void run (GameObject owner) {
        if(spellDisabled) {
            coolDownCount++;
            if(coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if(InputManager.instance.xPressed) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.setVector(owner.position.subtract(0, owner.image.getHeight() /2));

            spellDisabled = true;
        }

    }
}
