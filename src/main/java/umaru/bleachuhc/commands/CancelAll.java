package umaru.bleachuhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class CancelAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            BleachUHC.combatzoneUtils.resetZone();
        }
        return false;
    }
}
