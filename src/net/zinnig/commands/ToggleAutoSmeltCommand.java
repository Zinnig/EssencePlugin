/*
 * Copyright (c) Zinnig 2020.
 * File created: 23.04.20, 16:43
 * File last modified: 23.04.20, 16:43
 */

package net.zinnig.commands;

import net.zinnig.utils.CommandUtils;
import net.zinnig.utils.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleAutoSmeltCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (CommandUtils.normalChecks("essence.toggleautosmelt", 1, sender, args)){
            boolean goldOre = Files.cfg.getBoolean("OreAutoSmelt.goldOre");
            boolean ironOre = Files.cfg.getBoolean("OreAutoSmelt.ironOre");
            if(args[0].equalsIgnoreCase("goldore")){
                Files.cfg.set("OreAutoSmelt.goldOre", !goldOre);
                sender.sendMessage("§aThe auto-smelting of gold ore is now &6" + !goldOre);
            }else if(args[0].equalsIgnoreCase("ironore")){
                Files.cfg.set("OreAutoSmelt.ironOre", !ironOre);
                sender.sendMessage("§aThe auto-smelting of gold ore is now &6" + !ironOre);
            }
        }
        return false;
    }
}
