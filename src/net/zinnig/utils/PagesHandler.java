package net.zinnig.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PagesHandler {

    public static Inventory createNewPage(Player p, int size, String title){
        Inventory inv = Bukkit.createInventory(null, size, title);
        p.openInventory(inv);
        return inv;
    }
}
