package umaru.bleachuhc.bleachuhc.game.task;

import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import umaru.bleachuhc.abilities.GiveItem;
import umaru.bleachuhc.bleachuhc.BleachUHC;

public class HogyokuFirstLevelTask extends BukkitRunnable {
    private static int timeActive;
    private static String playerName;
    private BleachUHC bleachUHC;
    public HogyokuFirstLevelTask(BleachUHC bleachUHC) {
        this.bleachUHC = bleachUHC;
    }

    @Override
    public void run() {
        if(timeActive == 12000){
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0, false, true, true));
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0, false, true, true));
        }
        if(timeActive%60 == 0 && timeActive != 0){
            Bukkit.getPlayer(playerName).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 24, 2, false, true, true));
        }
        if(timeActive == 0){
            GiveItem.removeHogyokuInactif(playerName);
            GiveItem.giveHogyokuActifFirstLvl(playerName);
            this.cancel();
            HogyokuSecondLevelTask.setPlayerName(playerName);
            HogyokuSecondLevelTask.setTimeActive(0);
            BukkitTask hogyokuSecondLevel = new HogyokuSecondLevelTask(BleachUHC.getPlugin()).runTaskTimer(BleachUHC.getPlugin(), 0, 20);
        }
        timeActive--;
    }
    public static void setTimeActive(int timeActive) {
        HogyokuFirstLevelTask.timeActive = timeActive;
    }

    public static void setPlayerName(String playerName) {
        HogyokuFirstLevelTask.playerName = playerName;
    }
}
