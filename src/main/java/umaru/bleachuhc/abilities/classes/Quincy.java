package umaru.bleachuhc.abilities.classes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Quincy {

    public static void QuincyStuff(){
        //Quincy bow
        //2000201
        ItemStack quincyBow = new ItemStack(Material.IRON_SWORD);
        ItemMeta quincyBowMeta = quincyBow.getItemMeta();
        quincyBowMeta.setUnbreakable(true);
        quincyBowMeta.setDisplayName("Arc Quincy");
        quincyBowMeta.setLore(Arrays.asList("Pour tirer un coup"));
        quincyBowMeta.setCustomModelData(2000201);
        quincyBow.setItemMeta(quincyBowMeta);

        //Carquois
    }

}
