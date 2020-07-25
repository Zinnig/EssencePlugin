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
import org.bukkit.entity.Player;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;



public class BanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /ban <PlayerName> <reason> <time(s,m,h,d,w,mo,y>
        if(sender.hasPermission("essence.ban")){
            if(args.length == 2) {
                String from = sender.getName();
                if (PlayerData.getUUIDfromName(args[0]) != null) {
                    UUID pUUID = PlayerData.getUUIDfromName(args[0]);
                    if (Bukkit.getPlayer(pUUID) != null) {
                        Player target = Bukkit.getPlayer(pUUID);
                            String reason = args[1];
                            File player = PlayerData.getFileByName(target.getUniqueId().toString());
                            FileConfiguration playerfile = YamlConfiguration.loadConfiguration(player);
                            if(playerfile.getBoolean("Ban.Bannable")) {
                                playerfile.set("Ban.isBanned", true);
                                playerfile.set("Ban.From", from);
                                playerfile.set("Ban.Reason", reason);
                                playerfile.set("Ban.Timestamp", new SimpleDateFormat("dd:MM:yyyy HH:mm:ss").format(new Date()));
                                PlayerData.saveFilePlayerdata(target.getUniqueId(), playerfile);
                                Bukkit.getServer().getPlayer(target.getName()).kickPlayer(reason);
                                sender.sendMessage("§aYou've successfully banned §5" + target.getName() + " §apermanently");
                            }else
                                sender.sendMessage(StringUtils.getErrorPrefix() + "You're not allowed to ban this player");
                    } else {
                        String reason = args[1];
                        File player = PlayerData.getFileByName(pUUID.toString());
                        FileConfiguration playerfile = YamlConfiguration.loadConfiguration(player);
                        if(playerfile.getBoolean("Ban.Bannable")) {
                            playerfile.set("Ban.isBanned", true);
                            playerfile.set("Ban.From", from);
                            playerfile.set("Ban.Reason", reason);
                            playerfile.set("Ban.Timestamp", new SimpleDateFormat("dd:MM:yyyy HH:mm:ss").format(new Date()));
                            PlayerData.saveFilePlayerdata(pUUID, playerfile);
                            sender.sendMessage("§aYou've successfully banned §5" + args[0] + " §apermanently");
                        }else
                            sender.sendMessage(StringUtils.getErrorPrefix() + "You're not allowed to ban this player");
                    }
                }else
                    sender.sendMessage(StringUtils.noPlayerFoundError);
            }else if(args.length == 3) {
                String time = args[2];
                int timeS = 1000;
                int timeM = timeS * 60;
                int timeH = timeM * 60;
                int timeD = timeH * 24;
                int timeW = timeD * 7;
                int timeMo = timeW * 4;
                int timeY = timeMo * 12;
                int timeI = 1;
                if(!(time.contains("s") || time.contains("m") || time.contains("h") || time.contains("d") || time.contains("w") || time.contains("mo") || time.contains("y"))){
                    sender.sendMessage(StringUtils.argumentsError);
                    return true;
                }
                if (time.contains("s")) {
                    final String replace = time.replace("s", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeS;
                    

                } else if (time.contains("m")) {
                    final String replace = time.replace("m", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeM;

                } else if (time.contains("h")) {
                    final String replace = time.replace("h", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeH;

                } else if (time.contains("d")) {
                    final String replace = time.replace("d", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeD;

                } else if (time.contains("w")) {
                    final String replace = time.replace("w", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeW;
                } else if (time.contains("mo")) {
                    final String replace = time.replace("mo", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeMo;

                } else if (time.contains("y")) {
                    final String replace = time.replace("y", "");
                    timeI = Integer.parseInt(replace);
                    timeI *= timeY;

                }
                    String from = sender.getName();
                    if(PlayerData.getUUIDfromName(args[0]) != null){
                        UUID pUUID = PlayerData.getUUIDfromName(args[0]);
                        if(Bukkit.getPlayer(pUUID) != null) {
                            Player target = Bukkit.getPlayer(pUUID);
                            String reason = args[1];
                            long until = System.currentTimeMillis() + timeI;
                            File player = PlayerData.getFileByName(target.getUniqueId().toString());
                            FileConfiguration playerfile = YamlConfiguration.loadConfiguration(player);
                            if(playerfile.getBoolean("Ban.Bannable")) {
                                playerfile.set("Ban.isBanned", true);
                                playerfile.set("Ban.From", from);
                                playerfile.set("Ban.Reason", reason);
                                playerfile.set("Ban.Until", until);
                                playerfile.set("Ban.Timestamp", new SimpleDateFormat(StringUtils.dateFormat).format(new Date()));
                                PlayerData.saveFilePlayerdata(target.getUniqueId(), playerfile);
                                Bukkit.getServer().getPlayer(target.getName()).kickPlayer(reason);
                                sender.sendMessage("§aYou've successfully banned §5" + target.getName());
                            }else
                                sender.sendMessage(StringUtils.getErrorPrefix() + "You're not allowed to ban this player");
                        }else {
                            String reason = args[1];
                            long until = System.currentTimeMillis() + timeI;
                            File player = PlayerData.getFileByName(pUUID.toString());
                            FileConfiguration playerfile = YamlConfiguration.loadConfiguration(player);
                            if (playerfile.getBoolean("Ban.Bannable")) {
                                playerfile.set("Ban.isBanned", true);
                                playerfile.set("Ban.From", from);
                                playerfile.set("Ban.Reason", reason);
                                playerfile.set("Ban.Until", until);
                                playerfile.set("Ban.Timestamp", new SimpleDateFormat(StringUtils.dateFormat).format(new Date()));
                                PlayerData.saveFilePlayerdata(pUUID, playerfile);
                                sender.sendMessage("§aYou've successfully banned §5" + args[0]);
                            }else
                                sender.sendMessage(StringUtils.getErrorPrefix() + "You're not allowed to ban this player");
                        }


                    }else
                        sender.sendMessage(StringUtils.noPlayerFoundError);

            }else
                sender.sendMessage(StringUtils.argumentsError);
        }else
            sender.sendMessage(StringUtils.permissionError);
        return false;
    }

}