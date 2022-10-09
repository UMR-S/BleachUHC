package umaru.bleachuhc.bleachuhc;

import org.bukkit.plugin.java.JavaPlugin;
import umaru.bleachuhc.abilities.classes.Dash;
import umaru.bleachuhc.commands.CombatZoneSetY;
import umaru.bleachuhc.commands.DrawLineCommand;
import umaru.bleachuhc.commands.SaveCombatZone;
import umaru.bleachuhc.commands.WandCombatZone;
import umaru.bleachuhc.listeners.entities.EntityDamageByEntity;
import umaru.bleachuhc.listeners.entities.ShootArrow;
import umaru.bleachuhc.listeners.players.EntityPotion;
import umaru.bleachuhc.listeners.players.InteractEvent;
import umaru.bleachuhc.listeners.players.EnityOnFireEvent;
import umaru.bleachuhc.utils.combatZone.CombatZoneUtils;
import umaru.bleachuhc.utils.configUtils.CombatZoneConfigManager;

public final class BleachUHC extends JavaPlugin {

    private static BleachUHC plugin;
    public static Dash dash;
    public static CombatZoneUtils combatzoneUtils;
    public static CombatZoneConfigManager combatZoneComfigManager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        getServer().getPluginManager().registerEvents(new InteractEvent(), plugin);
        getServer().getPluginManager().registerEvents(new EnityOnFireEvent(), plugin);
        getServer().getPluginManager().registerEvents(new EntityPotion(), plugin);
        getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), plugin);
        getServer().getPluginManager().registerEvents(new ShootArrow(), plugin);
        getCommand("drawline").setExecutor(new DrawLineCommand());
        getCommand("wandCombatZone").setExecutor(new WandCombatZone());
        getCommand("setYcombatZone").setExecutor(new CombatZoneSetY());
        getCommand("saveCombatZone").setExecutor(new SaveCombatZone());
        dash =new Dash();
        combatzoneUtils = new CombatZoneUtils();
        combatZoneComfigManager = new CombatZoneConfigManager(this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static BleachUHC getPlugin() {
        return plugin;
    }
}
