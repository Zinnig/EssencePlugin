package net.zinnig.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * @author Zinnig
 */
public class FindCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("essence.find")){
                if(args.length == 1){
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(target != null){
                        double coordsX = target.getLocation().getX();
                        double coordsY = target.getLocation().getY();
                        double coordsZ = target.getLocation().getZ();
                        String worldName = target.getLocation().getWorld().toString().replace("CraftWorld={name=}", " ");
                        TextComponent tc = new TextComponent();
                        tc.setText("§aThe player§c " + target.getName() + " §ais located there --> §b(click) §f" + coordsX + " "
                                + coordsY + " §f" + coordsZ + ", World: " + worldName );
                        tc.setColor(ChatColor.GREEN);
                        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + p.getName() + " " + coordsX + " " + coordsY + " " + coordsZ));
                        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport you to " + target.getName()).create()));
                        p.spigot().sendMessage(tc);
                    }
                }
            }else
                p.sendMessage(StringUtils.permissionError);
        }else
            sender.sendMessage(StringUtils.notAPlayerError);

        return false;
    }
}
