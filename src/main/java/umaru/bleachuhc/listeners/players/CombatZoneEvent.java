package umaru.bleachuhc.listeners.players;

import io.lumine.mythic.api.mobs.MythicMob;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class CombatZoneEvent implements Listener {

    @EventHandler
    public void BreakBlockInCombatZone(BlockBreakEvent event){

        Block block = event.getBlock();

        if(BleachUHC.combatzoneUtils.isBlockInZone(block.getX(), block.getY(), block.getZ())){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void PlaceBlockInCombatZone(BlockPlaceEvent event){

        Block block = event.getBlock();

        if(BleachUHC.combatzoneUtils.isBlockInZone(block.getX(), block.getY(), block.getZ())){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void PlayerHitBossOutsideZone(EntityDamageByEntityEvent event){

        if(event.getDamager() instanceof Player){
            if(event.getEntity() instanceof MythicMob){
                if(!BleachUHC.combatzoneUtils.isPlayerInZone(event.getDamager().getName())){
                    event.setCancelled(true);
                }
            }
        }
    }
}
