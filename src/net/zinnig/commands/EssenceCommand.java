/*
 * Copyright (c) Zinnig 2019.
 * File created: 5/12/19 3:14 PM
 * File last modified: 5/12/19 3:14 PM
 */

package net.zinnig.commands;

import net.zinnig.utils.CommandUtils;
import net.zinnig.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EssenceCommand implements CommandExecutor {
    public static boolean invOpened = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandUtils.normalChecks("essence.playerdata", 0, sender, args)){
            Player p = (Player) sender;
            Inventory tools = Bukkit.createInventory(null, 36, "Tools");
            tools.setItem(12, Items.createItem(Material.IRON_PICKAXE, 1, 0, "Config"));
            tools.setItem(24, Items.createSkull("Zinnig", "PlayerData"));
            p.openInventory(tools);
            invOpened = true;
        }
        return false;
    }
}
