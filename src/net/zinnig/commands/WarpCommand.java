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
public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 1){
                if(p.hasPermission("essence.warp")){
                    String warpName = args[0];
                    if(Files.warpCfg.contains("Warps." + warpName)) {
                        Location loc = (Location) Files.warpCfg.get("Warps." + warpName);
                        p.teleport(loc);
                        p.sendMessage("§aYou got successfully teleported to the warp point: " + warpName);
                    }else
                     p.sendMessage(StringUtils.warpPointNotExists);
                }else
                    p.sendMessage(StringUtils.permissionError);
            }else
                p.sendMessage(StringUtils.argumentsError);
        }else
            sender.sendMessage(StringUtils.noPlayerFoundError);


        return false;
    }
}
