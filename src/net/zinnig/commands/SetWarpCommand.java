package net.zinnig.commands;

import net.zinnig.utils.Files;
import net.zinnig.utils.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zinnig
 * Created: 10.08.2018
 */
public class SetWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if (args.length == 1) {
                Player p = (Player) sender;
                if(p.hasPermission("essence.setwarp")){
                    Location loc = p.getLocation();
                    String warpName = args[0];
                    if(Files.warpCfg.get("Warps." + warpName) == null) {
                        Files.warpCfg.set("Warps." + warpName, loc);
                        p.sendMessage("§aYou've successfully set the warp point: " + warpName);
                        Files.saveFileWarps();
                    }else
                        p.sendMessage(StringUtils.warpPointAlreadyExists);
                }else
                    p.sendMessage(StringUtils.permissionError);
            } else
                sender.sendMessage(StringUtils.argumentsError);
        }else
        sender.sendMessage(StringUtils.notAPlayerError);
        return false;
    }
}
