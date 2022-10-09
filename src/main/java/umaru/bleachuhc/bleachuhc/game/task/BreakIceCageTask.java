package umaru.bleachuhc.bleachuhc.game.task;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import umaru.bleachuhc.bleachuhc.BleachUHC;
import umaru.bleachuhc.abilities.items.IceCage;

public class BreakIceCageTask extends BukkitRunnable {

    private static int breakTime;
    private static Location locPlayer;
    private
    BleachUHC bleachUHC;

    public BreakIceCageTask(BleachUHC bleachUHC) {
        this.bleachUHC = bleachUHC;
    }

    @Override
    public void run() {

        breakTime--;
        if (breakTime == 0) {
            this.cancel();
            IceCage.breakIceCage(locPlayer);
        }
    }

    public static void setbreakTime(int breakTime) {
        BreakIceCageTask.breakTime = breakTime;
    }

    public static void setLocPlayer(Location locPlayer) {
        BreakIceCageTask.locPlayer = locPlayer;
    }
}