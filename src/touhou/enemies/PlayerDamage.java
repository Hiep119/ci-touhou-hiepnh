package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.player.Player;

import javax.swing.*;

public class PlayerDamage {
    public void run(Enemies owner) {
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWidth(boxCollider, Player.class);

        if(player != null) {
            owner.isActive = false;
            player.getHit();
        }
    }
}
