package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {
    public static final ArrayList<Player> GodMode = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("essence.godmode.self")) {
                    if(GodMode.contains(p)){
                        GodMode.remove(p);
                        p.sendMessage("§aYou are not invulnerable anymore");
                    }else if (!GodMode.contains(p)){
                        GodMode.add(p);
                        p.sendMessage("§aYou're now invulnerable");
                    }
                }else
                    p.sendMessage(StringUtils.permissionError);
            }else if (args.length == 1){
                if(p.hasPermission("essence.godmode.other")){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        if(GodMode.contains(target)){
                            GodMode.remove(target);
                            p.sendMessage(target.getName() + "§ais not invulnerable anymore");
                            target.sendMessage("§aYou are not invulnerable anymore");
                        }else if (!GodMode.contains(target)){
                            GodMode.add(target);
                            p.sendMessage(target.getName() + "§ais now invulnerable");
                            target.sendMessage("§aYou're now invulnerable");
                        }
                    }else
                        sender.sendMessage(StringUtils.noPlayerFoundError);

                }else
                    p.sendMessage(StringUtils.permissionError);
            }else
                p.sendMessage(StringUtils.argumentsError);

        }else
            sender.sendMessage(StringUtils.notAPlayerError);
        return false;
    }
}
