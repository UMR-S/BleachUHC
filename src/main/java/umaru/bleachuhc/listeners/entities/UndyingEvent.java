package umaru.bleachuhc.listeners.entities;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import umaru.bleachuhc.bleachuhc.game.task.HogyokuSecondLevelTask;

public class UndyingEvent implements Listener {
    @EventHandler
    public void UndiyingEvent(EntityResurrectEvent event){

        if(event.getEntity() instanceof Player){
            HogyokuSecondLevelTask.setCancel(true);
        }
    }

}
