package net.zinnig.utils;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * @author Zinnig
 * Created: 05.08.2018
 */
public class Items {
    public static ItemStack createItem(Material material , int value , int damage , String displayname){
        ItemStack i = new ItemStack(material, value , (short) damage);
        ItemMeta imeta = i.getItemMeta();
        imeta.setDisplayName(displayname);
        i.setItemMeta(imeta);

        return i;

    }
    public static ItemStack createSkull(String owner, String name){
        ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD, 1,(short) SkullType.PLAYER.ordinal());
        SkullMeta smeta  = (SkullMeta) playerhead.getItemMeta();
        smeta.setOwner(owner);
        smeta.setDisplayName(name);
        playerhead.setItemMeta(smeta);
        return playerhead;
    }
}
