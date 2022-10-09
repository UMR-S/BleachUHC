package umaru.bleachuhc.listeners.players;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import umaru.bleachuhc.bleachuhc.BleachUHC;
import umaru.bleachuhc.bleachuhc.game.task.ReturnsDamageTask;
import umaru.bleachuhc.abilities.items.IceCage;

import java.util.HashMap;
import java.util.UUID;

public class EntityPotion implements Listener {

    @EventHandler
    public void PlayerGetPotionEffect(EntityPotionEffectEvent event){

        //Cage de glace de Toshiro

        if(event.getEntity() instanceof Player){

            Player player = ((Player) event.getEntity()).getPlayer();
            if(event.getNewEffect() != null){

                if(event.getNewEffect().getType().equals(PotionEffectType.SLOW) && event.getNewEffect().getAmplifier() == 3){

                    IceCage.iceCage(player.getLocation().getBlock().getLocation().clone());

                }

            }
        }

        // 4 cieux

        if(event.getEntity() instanceof Player){

            if(event.getNewEffect() != null){

                if(event.getNewEffect().getType().equals(PotionEffectType.HERO_OF_THE_VILLAGE) && event.getNewEffect().getAmplifier() == 0){

                    ReturnsDamageTask.setReturnTime(5);
                    HashMap<UUID,Double> playerHashMap = new HashMap<UUID,Double>();
                    event.getEntity().getWorld().getLivingEntities().forEach(e -> playerHashMap.put(e.getUniqueId(),0.0));
                    ReturnsDamageTask.setHashMapReturnDamage(playerHashMap);
                    BukkitTask playerReturnsDamage = new ReturnsDamageTask(BleachUHC.getPlugin()).runTaskTimer(BleachUHC.getPlugin(), 0, 20);


                }

            }
        }

        //Fusion poison Mayuri

        if(event.getEntity() instanceof Player){

            if(event.getNewEffect() != null){

                if(event.getOldEffect() != null){

                    if(event.getNewEffect().getType().equals(PotionEffectType.POISON) && event.getOldEffect().getType().equals(PotionEffectType.POISON)){

                        Player player = ((Player) event.getEntity()).getPlayer();
                        int duration = event.getNewEffect().getDuration() + event.getOldEffect().getDuration();
                        int amplifier = event.getNewEffect().getAmplifier() + event.getOldEffect().getAmplifier() + 1;
                        player.removePotionEffect(PotionEffectType.POISON);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, duration, amplifier));

                    }
                }
            }
        }

    }
    @EventHandler
    public void EntityGetPotionEffect(EntityPotionEffectEvent event){

        //Ukitake send damage back

        if(event.getEntity() instanceof LivingEntity){

            if(event.getNewEffect() != null){

                if(event.getNewEffect().getType().equals(PotionEffectType.NIGHT_VISION) && event.getNewEffect().getAmplifier() == 10){

                    ReturnsDamageTask.setReturnTime(5);
                    HashMap<UUID,Double> playerHashMapUkitake = new HashMap<UUID,Double>();
                    Bukkit.getOnlinePlayers().forEach(p -> playerHashMapUkitake.put(p.getUniqueId(),0.0));
                    ReturnsDamageTask.setHashMapReturnDamage(playerHashMapUkitake);
                    BukkitTask ukitakeReturnsDamage = new ReturnsDamageTask(BleachUHC.getPlugin()).runTaskTimer(BleachUHC.getPlugin(), 0, 20);

                }

            }
        }

    }

}
