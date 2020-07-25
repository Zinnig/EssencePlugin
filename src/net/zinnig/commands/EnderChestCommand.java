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
public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                if (p.hasPermission("essence.enderchest.self")) {
                    p.openInventory(p.getEnderChest());
                } else
                    sender.sendMessage(StringUtils.argumentsError);

            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (p.hasPermission("essence.enderchest.other")) {
                        p.openInventory(target.getEnderChest());
                    } else
                        sender.sendMessage(StringUtils.permissionError);
                } else
                    sender.sendMessage(StringUtils.noPlayerFoundError);

            } else {
                sender.sendMessage(StringUtils.argumentsError);
            }

        } else
            sender.sendMessage(StringUtils.notAPlayerError);
        return false;

    }
}
