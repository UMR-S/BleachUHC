package umaru.bleachuhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class SaveCombatZone implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            BleachUHC.combatZoneComfigManager.addCombatZone(args[0], BleachUHC.combatzoneUtils.getFinalZone(),BleachUHC.combatzoneUtils.getYmin(),BleachUHC.combatzoneUtils.getYmax());
            System.out.println(BleachUHC.combatzoneUtils.getFinalZone().size());
            BleachUHC.combatzoneUtils.resetZone();
        }

        return false;
    }
}
