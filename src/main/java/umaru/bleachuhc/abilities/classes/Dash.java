package umaru.bleachuhc.abilities.classes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class Dash {

    public void Dash(double power,String playerName){
        Player player = Bukkit.getPlayer(playerName);
        Vector playerFacing= player.getLocation().getDirection();
        playerFacing.normalize();
        playerFacing.multiply(power);
        player.setVelocity(playerFacing);
    }
}
