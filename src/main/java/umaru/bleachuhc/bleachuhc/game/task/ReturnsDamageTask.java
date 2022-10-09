package umaru.bleachuhc.bleachuhc.game.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import umaru.bleachuhc.bleachuhc.BleachUHC;

import java.util.HashMap;
import java.util.UUID;

public class ReturnsDamageTask extends BukkitRunnable {

    private static int returnTime;
    private static HashMap<UUID,Double> hashMapReturnDamage;
    private
    BleachUHC bleachUHC;

    public ReturnsDamageTask(BleachUHC bleachUHC) {
        this.bleachUHC = bleachUHC;
    }

    @Override
    public void run() {

        returnTime--;
        if (returnTime == 0) {
            this.cancel();
            hashMapReturnDamage.keySet().forEach(p -> ((LivingEntity) Bukkit.getEntity(p)).damage(hashMapReturnDamage.get(p)));
//            hashMapReturnDamage.keySet().forEach(p -> Bukkit.getPlayer(p).sendMessage(p + " a reçu " + hashMapReturnDamage.get(p).toString() + " damages"));
        }
    }

    public static void setReturnTime(int returnTime) {
        ReturnsDamageTask.returnTime = returnTime;
    }

    public static void setHashMapReturnDamage(HashMap<UUID, Double> hashMapReturnDamage) {
        ReturnsDamageTask.hashMapReturnDamage = hashMapReturnDamage;
    }
    public static void addDamageToPlayer(Double damage, UUID entityUUID){

        Double oldDamage = ReturnsDamageTask.hashMapReturnDamage.get(entityUUID);
        ReturnsDamageTask.hashMapReturnDamage.put(entityUUID, oldDamage + damage);
    }
}
