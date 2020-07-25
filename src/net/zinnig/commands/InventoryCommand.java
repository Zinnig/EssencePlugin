package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zinnig
 * Created: 15.12.2018
 */
public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (p.hasPermission("essence.inventory")) {
                        p.openInventory(target.getInventory());
                    } else
                        sender.sendMessage(StringUtils.permissionError);
                } else
                    sender.sendMessage(StringUtils.noPlayerFoundError);

            } else
                sender.sendMessage(StringUtils.argumentsError);

        }
        else
            sender.sendMessage(StringUtils.notAPlayerError);
        return false;
    }

    }
