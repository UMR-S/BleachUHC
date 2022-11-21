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
import umaru.bleachuhc.abilities.boss.Gin;
import umaru.bleachuhc.abilities.classes.ShunShunRika;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class InteractEvent implements Listener {

    BleachUHC bleachUHC = BleachUHC.getPlugin();

    @EventHandler
    public void onClickBleachUHC(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().hasItemMeta()) {

            //Shinigami
            // Dash shinigami

            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_AIR)
                    && !player.hasCooldown(Material.IRON_SWORD)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1000101
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "shinigami")) {

                bleachUHC.classesSpells.Dash(3, player.getName());
                player.setCooldown(Material.IRON_SWORD, 300);

            }
            // Attaque arme de Gin
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1010101) {

                Gin.shinsoGin(player.getName());

            }
            //Quincy
            //Dash quincy
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && !player.hasCooldown(Material.CARROT_ON_A_STICK)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 2000301
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "quincy")) {

                bleachUHC.classesSpells.Dash(5, player.getName());
                player.setCooldown(Material.CARROT_ON_A_STICK, 300);


            }
            //SSR
            // Ciel Unique
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && !player.hasCooldown(Material.CARROT_ON_A_STICK)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3000301
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "ssr")) {

                BleachUHC.classesSpells.cielUnique(player.getName());

            }
            // 2 Cieux
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && !player.hasCooldown(Material.NAUTILUS_SHELL)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3000302
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "ssr")) {

                BleachUHC.classesSpells.deuxCieux(player.getName());

            }
            // 3 Cieux
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && !player.hasCooldown(Material.PHANTOM_MEMBRANE)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3000303
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "ssr")) {

                BleachUHC.classesSpells.troisCieux(player.getName());

            }
            // 4 Cieux
            if ((event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    && !player.hasCooldown(Material.HEART_OF_THE_SEA)
                    && player.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3000304
                    && BleachUHC.classesUtils.isPlayerClasse(player.getName(), "ssr")) {

                player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 100, 0, false, false));

            }

            // Brazo bouclier
        }
        // Wand combat zone
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && player.getInventory().getItemInMainHand().getType() == Material.STONE_AXE
                && (!BleachUHC.combatzoneUtils.isFirstPoint())) {
            event.setCancelled(true);
            Location blockLoc = event.getClickedBlock().getLocation();
            BleachUHC.combatzoneUtils.setFirstPoint(blockLoc.getBlockX(), blockLoc.getBlockZ());
            BleachUHC.combatzoneUtils.setActualPoint(blockLoc.getBlockX(), blockLoc.getBlockZ());
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK
                && player.getInventory().getItemInMainHand().getType() == Material.STONE_AXE
                && BleachUHC.combatzoneUtils.isFirstPoint()) {
            event.setCancelled(true);
            Location blockLoc = event.getClickedBlock().getLocation();
            BleachUHC.combatzoneUtils.addLine(blockLoc.getBlockX(), blockLoc.getBlockZ());
            System.out.println(BleachUHC.combatzoneUtils.isClosedShape());
            if (BleachUHC.combatzoneUtils.isClosedShape()) {
                System.out.println("Yes");
                BleachUHC.combatzoneUtils.sortingContours();
            }
        }
    }
}
