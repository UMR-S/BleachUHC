package umaru.bleachuhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class CombatZoneSetY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            BleachUHC.combatzoneUtils.setYmin(Integer.parseInt(args[0]));
            BleachUHC.combatzoneUtils.setYmax(Integer.parseInt(args[1]));
        }
        return false;
    }
}
