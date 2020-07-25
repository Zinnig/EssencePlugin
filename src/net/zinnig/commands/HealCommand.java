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
public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if(sender.hasPermission("essence.heal.self")){
                if(sender instanceof Player){
                    Player p = (Player) sender;
                    if (p.getHealth() < 20) {
                        p.setHealth(20);
                        p.sendMessage("§aYou're heal points are now full!");
                    }else
                        p.sendMessage(StringUtils.healPointsAlreadyFull);
                }else
                    sender.sendMessage(StringUtils.notAPlayerError);
            }else
                sender.sendMessage(StringUtils.permissionError);
        }else if(args.length == 1) {
            if (sender.hasPermission("zinnig.heal.other")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target.getHealth() < 20) {
                    target.setHealth(20);
                    target.sendMessage("§aYou're heal points are now full!");
                    sender.sendMessage("§aYou've filled the heal points from §c" + target.getName());
                } else
                    sender.sendMessage(StringUtils.getErrorPrefix() + "§cThe heal points from §6" + target.getName() + " §aare already full!");
            }else
                sender.sendMessage(StringUtils.permissionError);
        }else
            sender.sendMessage(StringUtils.argumentsError);
        return false;
    }

}
