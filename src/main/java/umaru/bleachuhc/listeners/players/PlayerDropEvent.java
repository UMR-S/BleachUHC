package umaru.bleachuhc.listeners.players;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import umaru.bleachuhc.bleachuhc.game.task.HogyokuInactifTask;

public class PlayerDropEvent implements Listener {

    @EventHandler
    public void PlayerDropEvent(PlayerDropItemEvent event) {

        if(event.getItemDrop().getItemStack().getItemMeta().hasCustomModelData()
            && HogyokuInactifTask.isHogyokuActivated()){
            if(event.getItemDrop().getItemStack().getItemMeta().getCustomModelData() == 5149604
                || event.getItemDrop().getItemStack().getItemMeta().getCustomModelData() == 5149605
                || event.getItemDrop().getItemStack().getItemMeta().getCustomModelData() == 5149606){
                event.setCancelled(true);
            }
        }

    }

}
