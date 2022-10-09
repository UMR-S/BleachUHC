package umaru.bleachuhc.listeners.players;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import umaru.bleachuhc.bleachuhc.BleachUHC;
import umaru.bleachuhc.abilities.boss.Gin;

public class InteractEvent implements Listener {

    BleachUHC bleachUHC = BleachUHC.getPlugin();
    @EventHandler
    public void onClickBleachUHC(PlayerInteractEvent event) {

        // Dash shinigami (rajouter celui du quincy)
        Player player = event.getPlayer();
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().getType() == Material.HEART_OF_THE_SEA) {

            bleachUHC.dash.Dash(3, player.getName());

        }
        // Attaque arme de Gin
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD) {

            Gin.shinsoGin(player.getName());

        }
        // 4 Cieux
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().getType() == Material.STICK) {

            player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 100,0, false, false));

        }

        // Brazo bouclier

        // Wand combat zone
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType() == Material.STONE_AXE && (!BleachUHC.combatzoneUtils.isFirstPoint())){
            event.setCancelled(true);
            Location blockLoc = event.getClickedBlock().getLocation();
            BleachUHC.combatzoneUtils.setFirstPoint(blockLoc.getBlockX(),blockLoc.getBlockZ());
            BleachUHC.combatzoneUtils.setActualPoint(blockLoc.getBlockX(),blockLoc.getBlockZ());
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType() == Material.STONE_AXE && BleachUHC.combatzoneUtils.isFirstPoint()){
            event.setCancelled(true);
            Location blockLoc = event.getClickedBlock().getLocation();
            BleachUHC.combatzoneUtils.addLine(blockLoc.getBlockX(), blockLoc.getBlockZ());
            System.out.println(BleachUHC.combatzoneUtils.isClosedShape());
            if(BleachUHC.combatzoneUtils.isClosedShape()){
                System.out.println("Yes");
                BleachUHC.combatzoneUtils.sortingContours();
            }
        }
    }
}
