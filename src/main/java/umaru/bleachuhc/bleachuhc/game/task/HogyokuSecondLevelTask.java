package umaru.bleachuhc.bleachuhc.game.task;

import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import umaru.bleachuhc.abilities.GiveItem;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class HogyokuSecondLevelTask extends BukkitRunnable {

    private static int timeActive;
    private static String playerName;

    private static boolean cancel = false;
    private BleachUHC bleachUHC;

    public HogyokuSecondLevelTask(BleachUHC bleachUHC) {
        this.bleachUHC = bleachUHC;
    }
    @Override
    public void run() {
        if(timeActive == 0){
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2160000, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 2160000, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2160000, 1, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2160000, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 2160000, 0, false, false, false));
        }
        if(timeActive%30 == 0){
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 24, 2, false, true, true));;
        }
        if(cancel){
            this.cancel();
            HogyokuInactifTask.setTimeInactive(3000);
            HogyokuInactifTask.setPlayerName(playerName);
            BukkitTask hogyokuInacyif = new HogyokuInactifTask(BleachUHC.getPlugin()).runTaskTimer(BleachUHC.getPlugin(),0,20);
            GiveItem.giveHogyokuInactif(playerName);
        }
        timeActive++;
    }

    public static void setTimeActive(int timeActive) {
        HogyokuSecondLevelTask.timeActive = timeActive;
    }

    public static void setPlayerName(String playerName) {
        HogyokuSecondLevelTask.playerName = playerName;
    }

    public static void setCancel(boolean cancel) {
        HogyokuSecondLevelTask.cancel = cancel;
    }
}
