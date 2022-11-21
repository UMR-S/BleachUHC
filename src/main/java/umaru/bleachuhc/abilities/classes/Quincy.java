package umaru.bleachuhc.abilities.classes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
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
        //2000301
        ItemStack quincyCarquois = new ItemStack(Material.CARROT_ON_A_STICK);
        ItemMeta quincyCarquoisMeta = quincyCarquois.getItemMeta();
        quincyCarquoisMeta.setUnbreakable(true);
        quincyCarquoisMeta.setDisplayName("Carquois");
        quincyCarquoisMeta.setLore(Arrays.asList("Cooldown : 30s","Vous donne 17 flèches"));
        quincyCarquoisMeta.setCustomModelData(2000301);
        quincyCarquois.setItemMeta(quincyCarquoisMeta);

    }

}
