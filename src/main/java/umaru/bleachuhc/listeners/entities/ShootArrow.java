package umaru.bleachuhc.listeners.entities;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;


public class ShootArrow implements Listener {

    @EventHandler
    public void EntityShootArrow(EntityShootBowEvent event){
        if(event.getEntity() instanceof Player){
            MythicMob arrow = MythicBukkit.inst().getMobManager().getMythicMob("QuincyArrow").orElse(null);
            Vector arrowVector = event.getProjectile().getVelocity();
            Location arrowLoc = event.getProjectile().getLocation();
            Vector direction = event.getProjectile().getFacing().getDirection();
            event.getProjectile().remove();
            ActiveMob blueArrow = arrow.spawn(BukkitAdapter.adapt(arrowLoc),1);
            blueArrow.getEntity().getBukkitEntity().setVelocity(arrowVector);
        }
    }

}
