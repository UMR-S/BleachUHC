package umaru.bleachuhc.bleachuhc;

import org.bukkit.plugin.java.JavaPlugin;
import umaru.bleachuhc.abilities.classes.ClassesSpells;
import umaru.bleachuhc.commands.*;
import umaru.bleachuhc.listeners.entities.EntityDamageByEntity;
import umaru.bleachuhc.listeners.entities.UndyingEvent;
import umaru.bleachuhc.listeners.players.*;
import umaru.bleachuhc.utils.classesUtils.ClassesUtils;
import umaru.bleachuhc.utils.combatZone.CombatZoneUtils;
import umaru.bleachuhc.utils.configUtils.CombatZoneConfigManager;

public final class BleachUHC extends JavaPlugin {

    private static BleachUHC plugin;
    public static ClassesSpells classesSpells;
    public static CombatZoneUtils combatzoneUtils;
    public static CombatZoneConfigManager combatZoneComfigManager;
    public static ClassesUtils classesUtils;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        getServer().getPluginManager().registerEvents(new InteractEvent(), plugin);
        getServer().getPluginManager().registerEvents(new CombatZoneEvent(), plugin);
        getServer().getPluginManager().registerEvents(new EnityOnFireEvent(), plugin);
        getServer().getPluginManager().registerEvents(new EntityPotion(), plugin);
        getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), plugin);
        //getServer().getPluginManager().registerEvents(new ShootArrow(), plugin); pas utilisé au final
        getServer().getPluginManager().registerEvents(new EntityPickItemEvent(), plugin);
        //getServer().getPluginManager().registerEvents(new EntityDamage(), plugin); pas utilisé au final
        getServer().getPluginManager().registerEvents(new UndyingEvent(), plugin);
        getServer().getPluginManager().registerEvents(new PlayerDropEvent(), plugin);
        getServer().getPluginManager().registerEvents(new InventoryMoveEvent(), plugin);
        getCommand("drawline").setExecutor(new DrawLineCommand());
        getCommand("wandCombatZone").setExecutor(new WandCombatZone());
        getCommand("setYcombatZone").setExecutor(new CombatZoneSetY());
        getCommand("saveCombatZone").setExecutor(new SaveCombatZone());
        getCommand("cancelAll").setExecutor(new CancelAll());
        getCommand("chooseClasse").setExecutor(new ChooseClasse());
        classesSpells =new ClassesSpells();
        combatzoneUtils = new CombatZoneUtils();
        combatZoneComfigManager = new CombatZoneConfigManager(this);
        classesUtils = new ClassesUtils();

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
