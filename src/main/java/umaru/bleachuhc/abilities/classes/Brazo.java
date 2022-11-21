package umaru.bleachuhc.abilities.classes;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Brazo {

    public static void ShinigamiStuff(){

        //Bouclier
        ItemStack shieldBrazo = new ItemStack(Material.SHIELD);
        ItemMeta shieldBrazoMeta = shieldBrazo.getItemMeta();
        shieldBrazoMeta.setDisplayName("Bouclier Brazo");
        shieldBrazoMeta.setLore(Arrays.asList("5 fois plus efficace","que le bouclier tarifaire"));
        shieldBrazoMeta.setUnbreakable(true);
        shieldBrazoMeta.setCustomModelData(4000401);
    }

}
