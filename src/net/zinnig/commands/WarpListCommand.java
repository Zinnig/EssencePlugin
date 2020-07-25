package net.zinnig.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.zinnig.utils.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Zinnig
 * Created: 25.08.2018
 */
// Not working yet
public class WarpListCommand implements CommandExecutor {
    private List<String> warps = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //if(sender instanceof Player){
            //Player p = (Player) sender;
            if(sender.hasPermission("essence.warplist")){
                if(Files.warpCfg.contains("Warps")){
                    ConfigurationSection warpSection = Files.warpCfg.getConfigurationSection("Warps");
                    for (String warp: warpSection.getKeys(false)) {
                        TextComponent tc = new TextComponent();
                        tc.setText(warp);
                        tc.setColor(ChatColor.GOLD);
                        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/warp " + warp));
                        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport you to the warp point: " + warp).create()));
                        sender.spigot().sendMessage(tc);
                    }
                }
            }
            //}
        return false;
        }

    }
