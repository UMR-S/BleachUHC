package umaru.bleachuhc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WandCombatZone implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            ItemStack wandCombatZone = new ItemStack(Material.STONE_AXE);
            ItemMeta wandCombatZoneItemMeta = wandCombatZone.getItemMeta();
            wandCombatZoneItemMeta.setDisplayName("Combat zone wand");
            wandCombatZone.setItemMeta(wandCombatZoneItemMeta);
            player.getInventory().addItem(wandCombatZone);
        }

        return false;
    }
}
