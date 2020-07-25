package net.zinnig.commands;

import net.zinnig.utils.PlayerData;
import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class UnBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("essence.unban")){
            if(args.length == 1) {
                    UUID playerUUID = PlayerData.getUUIDfromName(args[0]);
                    if(playerUUID != null) {
                        File player = PlayerData.getFileByName(playerUUID.toString());
                        FileConfiguration playerfile = YamlConfiguration.loadConfiguration(player);
                        playerfile.set("Ban.isBanned", false);
                        playerfile.set("Ban.From", " ");
                        playerfile.set("Ban.Reason", " ");
                        playerfile.set("Ban.Until", 0);
                        playerfile.set("Ban.Timestamp", "unban: " + new SimpleDateFormat(StringUtils.dateFormat).format(new Date()));
                        PlayerData.saveFilePlayerdata(playerUUID, playerfile);
                        sender.sendMessage("§aYou successfully unbanned " + args[0]);
                    }else
                        sender.sendMessage(StringUtils.getErrorPrefix() + "This Playername isn't valid");

                }
            }

        return false;
    }
}
