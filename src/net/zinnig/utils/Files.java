package net.zinnig.utils;

import net.zinnig.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @author Zinnig
 * Created: 09.08.2018
 */
public class Files {

    private static final File folder = new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/");
    private static final File file = new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/config.yml");
    public static final FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static final File warps = new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/warps.yml");
    public static final FileConfiguration warpCfg = YamlConfiguration.loadConfiguration(warps);

    private static void saveFile() {

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void reloadCustomConfig() {
        YamlConfiguration.loadConfiguration(file);
    }

    public static void setupFile() {
        if (!folder.exists()) {
            if (!file.exists()) {

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }


        }
        cfg.options().header("Coded by Zinnig");
        //Chat-Prefix
        cfg.addDefault("Chat.Prefix.OwnerPrefix", "&4Owner&7>&4");
        cfg.addDefault("Chat.Prefix.AdminPrefix", "&cAdmin&7>&c");
        cfg.addDefault("Chat.Prefix.DevPrefix", "&bDev&7>&b");
        cfg.addDefault("Chat.Prefix.ModPrefix", "&eModerator&7>&e");
        cfg.addDefault("Chat.Prefix.HelperPrefix", "&1Helper&7>&1");
        cfg.addDefault("Chat.Prefix.YoutubePrefix", "&5YT&7>&5");
        cfg.addDefault("Chat.Prefix.VIPPrefix", "&6VIP&7>&6");
        cfg.addDefault("Chat.Prefix.PlayerPrefix", "&aPlayer&7>&a");
        //Chat-Suffix
        cfg.addDefault("Chat.Suffix", "&7:");
        //The write-color of the different ranks
        cfg.addDefault("Chat.WriteColor.Owner", "&f");
        cfg.addDefault("Chat.WriteColor.Admin", "&f");
        cfg.addDefault("Chat.WriteColor.Dev", "&f");
        cfg.addDefault("Chat.WriteColor.Mod", "&f");
        cfg.addDefault("Chat.WriteColor.Helper", "&f");
        cfg.addDefault("Chat.WriteColor.Youtube", "&f");
        cfg.addDefault("Chat.WriteColor.VIP", "&f");
        cfg.addDefault("Chat.WriteColor.Player", "&f");
        //Tablist Color Prefix 
        cfg.addDefault("Tablist.Prefix.OwnerPrefix", "&4");
        cfg.addDefault("Tablist.Prefix.AdminPrefix", "&c");
        cfg.addDefault("Tablist.Prefix.DevPrefix", "&b");
        cfg.addDefault("Tablist.Prefix.ModPrefix", "&e");
        cfg.addDefault("Tablist.Prefix.HelperPrefix", "&1");
        cfg.addDefault("Tablist.Prefix.YoutubePrefix", "&5");
        cfg.addDefault("Tablist.Prefix.VIPPrefix", "&6");
        cfg.addDefault("Tablist.Prefix.PlayerPrefix", "&a");
        // Ban Format
        cfg.addDefault("Ban.BanFormat", "You've been banned from this Server! \nReason:%Reason% \nUntil: %Until% \n By: %From%");
        //Date Format
        cfg.addDefault("Ban.DateFormat", "dd:MM:yyyy HH:mm:ss");
        //Error Messages
        cfg.addDefault("ErrorMessage.ErrorFormat", "&cERROR &7>> &c");
        cfg.addDefault("ErrorMessage.ArgumentsError", "You've specified too many or too less arguments.");
        cfg.addDefault("ErrorMessage.PermissionsError", "You don't own the permission to do that.");
        cfg.addDefault("ErrorMessage.NotAPlayerError", "You're not a player.");
        cfg.addDefault("ErrorMessage.NoPlayerFoundError", "This player couldn't be found.");
        cfg.addDefault("ErrorMessage.WarpPointNotExists", "This warp point doesn't exists.");
        cfg.addDefault("ErrorMessage.WarpPointAlreadyExists", "This warp point already exists.");
        cfg.addDefault("ErrorMessage.HealPointsAlreadyFull", "Your heal points are already full.");
        cfg.addDefault("ErrorMessage.HungerPointsAlreadyFull", "Your hunger points are already full.");
        cfg.addDefault("ErrorMessage.AlreadyRandomInSession", "You've already executed the random command in this session.");
        //Join Message
        cfg.addDefault("JoinLeaveMessage.JoinMessage", "§a+ %player%");
        cfg.addDefault("JoinLeaveMessage.LeaveMessage", "§c- %player%");
        //Auto-Smelt Ores
        cfg.addDefault("OreAutoSmelt.goldOre", false);
        cfg.addDefault("OreAutoSmelt.ironOre", false);

        cfg.options().copyDefaults(true);
        cfg.options().copyHeader(true);

        saveFile();
    }

    public static void saveFileWarps() {

        try {
            warpCfg.save(warps);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void reloadCustomConfigWarps() {
        YamlConfiguration.loadConfiguration(warps);
    }

    public static void setupFileWarps() {
        if (!folder.exists()) {
            if (!warps.exists()) {

                try {
                    warps.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }


        }
        saveFileWarps();
    }


}
