package net.zinnig.commands;

import net.zinnig.utils.Files;
import net.zinnig.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Zinnig
 * Created: 10.08.2018
 */
public class DelWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            if (sender.hasPermission("essence.delwarp")) {
                String warpName = args[0];
                if(Files.warpCfg.contains("Warps." + warpName)){
                    Files.warpCfg.set("Warps." + warpName, null);
                    sender.sendMessage("§aYou've successfully deleted the warp point:" + warpName);
                    Files.saveFileWarps();
                }else
                    sender.sendMessage(StringUtils.warpPointNotExists);
            }else
                sender.sendMessage(StringUtils.permissionError);
        }else
            sender.sendMessage(StringUtils.argumentsError);
            return false;

    }
}
