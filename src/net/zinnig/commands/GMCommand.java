package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Zinnig
 */
public class GMCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if (args.length == 1) {
                    if (sender.hasPermission("essence.gm.self")) {
                        if (sender instanceof Player) {
                            Player p = (Player) sender;

                            if (args[0].equalsIgnoreCase("1")) {
                                p.setGameMode(GameMode.CREATIVE);
                                p.sendMessage("§aYour gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("0")) {
                                p.setGameMode(GameMode.SURVIVAL);
                                p.sendMessage("§aYour gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("2")) {
                                p.setGameMode(GameMode.ADVENTURE);
                                p.sendMessage("§aYour gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("3")) {
                                p.setGameMode(GameMode.SPECTATOR);
                                p.sendMessage("§aYour gamemode has been updated!");
                            } else
                                p.sendMessage(StringUtils.argumentsError);
                        }else
                            sender.sendMessage(StringUtils.notAPlayerError);
                    }else
                        sender.sendMessage(StringUtils.permissionError);

                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        if (sender.hasPermission("essence.gm.other")) {
                            if (args[0].equalsIgnoreCase("1")) {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage("§aYour gamemode has been updated!");
                                sender.sendMessage("§6"+target.getName() + "§a's gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("0")) {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage("§aYour gamemode has been updated!");
                                sender.sendMessage("§6"+target.getName() + "§a's gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("2")) {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage("§aYour gamemode has been updated!");
                                sender.sendMessage("§6"+target.getName() + "§a's gamemode has been updated!");
                            } else if (args[0].equalsIgnoreCase("3")) {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage("§aYour gamemode has been updated!");
                                sender.sendMessage("§6"+target.getName() + "§a's gamemode has been updated!");
                            }
                        }else
                            sender.sendMessage(StringUtils.permissionError);
                    } else
                        sender.sendMessage(StringUtils.noPlayerFoundError);

                } else
                    sender.sendMessage(StringUtils.argumentsError);
          return false;
    }

        }







