package umaru.bleachuhc.listeners.players;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemPickUpEvent implements Listener {

    @EventHandler
    public void PlayerPickUpEvent(EntityPickupItemEvent event){

        if(event.getEntity() instanceof Player){

        }

    }
}
