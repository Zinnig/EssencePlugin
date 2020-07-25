package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zinnig
 * Created: 06.08.2018
 */
public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
        if(sender.hasPermission("essence.feed.self")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                    if (p.getFoodLevel() < 20) {
                        p.setFoodLevel(20);
                        p.sendMessage("§aYou're hunger points are now full!");
                    }else
                        p.sendMessage(StringUtils.hungerPointsAlreadyFull);
                }else
                sender.sendMessage(StringUtils.notAPlayerError);
            }else
                sender.sendMessage(StringUtils.permissionError);
        }else if(args.length == 1) {
            if (sender.hasPermission("essence.feed.other")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target.getFoodLevel() < 20) {
                        target.setFoodLevel(20);
                        target.sendMessage("§aYou're hunger points are now full!");
                        sender.sendMessage("§aYou've filled the hunger points from §c" + target.getName());
                    } else
                        sender.sendMessage(StringUtils.getErrorPrefix() + "§cThe hunger points from §6" + target.getName() + " §aare already full!");
                }else
                sender.sendMessage(StringUtils.permissionError);
            }else
            sender.sendMessage(StringUtils.argumentsError);
        return false;
        }

    }