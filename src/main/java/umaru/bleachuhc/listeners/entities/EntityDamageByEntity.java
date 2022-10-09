package umaru.bleachuhc.listeners.entities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import umaru.bleachuhc.bleachuhc.game.task.ReturnsDamageTask;

public class EntityDamageByEntity implements Listener {


    @EventHandler
    public void EntityHitByEntity(EntityDamageByEntityEvent event){



        if(event.getDamager() instanceof Player){

            //Pour Ukitake

            if(event.getEntity() instanceof LivingEntity){

                Player player = (Player) event.getDamager();
                LivingEntity entity = (LivingEntity) event.getEntity();
                Boolean isUkitakeThors = false;
                for(PotionEffect potionEffect : entity.getActivePotionEffects()){
                    if(potionEffect.getType().equals(PotionEffectType.NIGHT_VISION) && potionEffect.getAmplifier() == 10){
                        isUkitakeThors = true;
                    }
                }
                if(isUkitakeThors){
                    ReturnsDamageTask.addDamageToPlayer(event.getDamage(), player.getUniqueId());
                }

            }

            //Pour 4 cieux

            if(event.getEntity() instanceof Player){

                Player damager = (Player) event.getDamager();
                Player player = ((Player) event.getEntity()).getPlayer();
                Boolean isPlayerThors = false;
                for(PotionEffect potionEffect : player.getActivePotionEffects()){
                    if(potionEffect.getType().equals(PotionEffectType.HERO_OF_THE_VILLAGE) && potionEffect.getAmplifier() == 0){
                        isPlayerThors = true;
                    }
                }
                if(isPlayerThors){
                    ReturnsDamageTask.addDamageToPlayer(event.getDamage(), player.getUniqueId());
                }

            }
        }
    }

}
