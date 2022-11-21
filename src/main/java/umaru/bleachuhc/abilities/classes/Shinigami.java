package umaru.bleachuhc.abilities.classes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Shinigami {

    public static void ShinigamiStuff(){
        //Zanpakuto
        ItemStack zanpakuto = new ItemStack(Material.IRON_SWORD);
        ItemMeta zanpakutoMeta = zanpakuto.getItemMeta();
        zanpakutoMeta.setUnbreakable(true);
        zanpakutoMeta.setDisplayName("Zanpakuto");
        zanpakutoMeta.setLore(Arrays.asList("Pour les amateurs de grosses épées =w="));
        zanpakutoMeta.setCustomModelData(1000101);
        zanpakuto.setItemMeta(zanpakutoMeta);


    }

}
