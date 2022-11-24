package umaru.bleachuhc.listeners.players;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import umaru.bleachuhc.bleachuhc.game.task.HogyokuInactifTask;

public class InventoryMoveEvent implements Listener {
    @EventHandler
    public void InventoryMoveEvent(InventoryMoveItemEvent event) {

        if (event.getItem().getItemMeta().hasCustomModelData()
                && HogyokuInactifTask.isHogyokuActivated()) {
            if (event.getItem().getItemMeta().getCustomModelData() == 5149604
                    || event.getItem().getItemMeta().getCustomModelData() == 5149605
                    || event.getItem().getItemMeta().getCustomModelData() == 5149606) {
                event.setCancelled(true);
            }

        }
    }
}
