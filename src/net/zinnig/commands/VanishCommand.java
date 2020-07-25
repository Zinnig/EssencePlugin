package net.zinnig.commands;

import net.zinnig.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Zinnig
 * Created: 25.08.2018
 */
public class VanishCommand implements CommandExecutor {
     private final ArrayList<UUID> vanished = new ArrayList<>();
    @Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("essence.vanish")) {
                if (vanished.contains(p.getUniqueId())) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.showPlayer(Main.getInstance(), p);
                    }
                    vanished.remove(p.getUniqueId());
                    p.sendMessage("§aYou're now visible again!");
                }else if(!vanished.contains(p.getUniqueId())) {
                    vanished.add(p.getUniqueId());
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(Main.getInstance(), p);
                    }
                    p.sendMessage("§aNo one can see you now");
                }
            }
        }
        return false;
    }
}
