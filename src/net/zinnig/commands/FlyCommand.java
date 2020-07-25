package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Zinnig
 */
public class FlyCommand implements CommandExecutor {

    private final ArrayList<UUID> flying = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("essence.fly")) {
                if (args.length == 0) {
                    if (flying.contains(p.getUniqueId())) {
                        flying.remove(p.getUniqueId());
                        p.setAllowFlight(false);
                        p.sendMessage("§aYou're now no more able to fly!");
                    } else if (!flying.contains(p.getUniqueId())) {
                        flying.add(p.getUniqueId());
                        p.setAllowFlight(true);
                        p.sendMessage("§aYou're now able to fly!");
                    }
                } else
                    p.sendMessage(StringUtils.argumentsError);
            }else
                p.sendMessage(StringUtils.permissionError);
        } else
            sender.sendMessage(StringUtils.notAPlayerError);

        return false;
    }
}
