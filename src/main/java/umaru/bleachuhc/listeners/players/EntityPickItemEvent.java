package umaru.bleachuhc.listeners.players;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class EntityPickItemEvent implements Listener {

    //Item Interdit par classes
    @EventHandler
    public void PlayerPickEvent(EntityPickupItemEvent event){
        if(event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity()).getPlayer();
            //Shinigami
            if(BleachUHC.classesUtils.isPlayerClasse(player.getName(), "shinigami")){
                if(event.getItem().getItemStack().getType().equals(Material.BOW)
                        || event.getItem().getItemStack().getType().equals(Material.CROSSBOW)
                        || event.getItem().getItemStack().getType().equals(Material.SHIELD)){
                    event.setCancelled(true);
                }
            }
            //Quincy
            if(BleachUHC.classesUtils.isPlayerClasse(player.getName(), "quincy")){
                if(event.getItem().getItemStack().getType().equals(Material.WOODEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.STONE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.IRON_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.GOLDEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.DIAMOND_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.NETHERITE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.CROSSBOW)
                        || event.getItem().getItemStack().getType().equals(Material.SHIELD)){
                    event.setCancelled(true);
                }
            }
            //Shun shun rika
            if(BleachUHC.classesUtils.isPlayerClasse(player.getName(), "ssr")){
                if(event.getItem().getItemStack().getType().equals(Material.WOODEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.STONE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.IRON_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.GOLDEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.DIAMOND_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.NETHERITE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.BOW)
                        || event.getItem().getItemStack().getType().equals(Material.CROSSBOW)
                        || event.getItem().getItemStack().getType().equals(Material.SHIELD)){
                    event.setCancelled(true);
                }
            }
            //Brazo
            if(BleachUHC.classesUtils.isPlayerClasse(player.getName(), "brazo")){
                if(event.getItem().getItemStack().getType().equals(Material.WOODEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.STONE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.IRON_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.GOLDEN_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.DIAMOND_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.NETHERITE_SWORD)
                        || event.getItem().getItemStack().getType().equals(Material.BOW)
                        || event.getItem().getItemStack().getType().equals(Material.CROSSBOW)){
                    event.setCancelled(true);
                }
            }
        }
    }

}
