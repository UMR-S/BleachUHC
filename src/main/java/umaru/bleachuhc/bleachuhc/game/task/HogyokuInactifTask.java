package umaru.bleachuhc.bleachuhc.game.task;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import umaru.bleachuhc.abilities.GiveItem;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class HogyokuInactifTask extends BukkitRunnable {

    private static int timeInactive;
    private static String playerName;
    private static boolean hogyokuActivated = false;
    private BleachUHC bleachUHC;

    public HogyokuInactifTask(BleachUHC bleachUHC) {
        this.bleachUHC = bleachUHC;
    }
    @Override
    public void run() {
        if(timeInactive==0){
            GiveItem.removeHogyokuInactif(playerName);
            GiveItem.giveHogyokuActifFirstLvl(playerName);
            HogyokuFirstLevelTask.setPlayerName(playerName);
            HogyokuFirstLevelTask.setTimeActive(12000);
            BukkitTask hogyokuFirstLevel = new HogyokuFirstLevelTask(BleachUHC.getPlugin()).runTaskTimer(BleachUHC.getPlugin(), 0, 20);
            this.cancel();
        }
        timeInactive--;
    }

    public static void setTimeInactive(int timeInactive) {
        HogyokuInactifTask.timeInactive = timeInactive;
    }

    public static void setPlayerName(String playerName) {
        HogyokuInactifTask.playerName = playerName;
    }

    public static boolean isHogyokuActivated() {
        return hogyokuActivated;
    }

    public static void setHogyokuActivated(boolean hogyokuActivated) {
        HogyokuInactifTask.hogyokuActivated = hogyokuActivated;
    }
}
