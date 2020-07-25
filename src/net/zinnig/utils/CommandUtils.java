/*
 * Copyright (c) Zinnig 2019.
 * File created: 5/12/19 3:20 PM
 * File last modified: 5/12/19 3:20 PM
 */

package net.zinnig.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUtils {
    /**
    @Param
     @Return true if all checks return true, else false
     */
    public static boolean normalChecks(String permission, int size, CommandSender sender, String[] args){
        if (sender instanceof Player) {
            if (sender.hasPermission(permission)) {
                if (args.length == size) {
                    return true;
                } else
                    sender.sendMessage(StringUtils.argumentsError);
                    return false;
            } else
                sender.sendMessage(StringUtils.permissionError);
                return false;

        }else
            sender.sendMessage(StringUtils.notAPlayerError);
            return false;
    }
}
