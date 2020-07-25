package net.zinnig.utils;

import net.zinnig.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class PlayerData {
    private static final File playerdata = new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/playerdata/");

    public PlayerData(UUID uuid) {
        File fileplayer = new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/playerdata/"  + uuid.toString() + ".yml");
        if (!playerdata.exists()) {
            if (!fileplayer.exists()) {
                try {
                    playerdata.mkdir();
                    fileplayer.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (playerdata.exists()) {
            if (!fileplayer.exists()) {
                try {
                    fileplayer.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }
        }
        FileConfiguration fileConf = YamlConfiguration.loadConfiguration(fileplayer);
        fileConf.set("Name", Bukkit.getPlayer(uuid).getDisplayName());
        saveFilePlayerdata(uuid, fileConf);
    }
    public static File getFileByName(String name1) {
        return new File("plugins/" + (Main.getPlugin(Main.class)).getDescription().getName() + "/playerdata/" + name1 + ".yml");
    }

    public static void saveFilePlayerdata(UUID uuid, FileConfiguration fileConf){
        File fileplayer = getFileByName(uuid.toString());
        try {
            fileConf.save(fileplayer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static UUID getUUIDfromName(String name) {
        Player p = Bukkit.getPlayer(name);
        if (p != null) {
            return p.getUniqueId();
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);
            return offlinePlayer.getUniqueId();

        }
    }
    public static String getNameFromUUID(String uuid){
        Player p = Bukkit.getPlayer(uuid);
        if(p != null){
            return p.getName();
        }else {
            OfflinePlayer of = Bukkit.getOfflinePlayer(uuid);
            return of.getName();
        }
    }
    public static void reloadPlayerData(String name){
        File target = getFileByName(name);
        YamlConfiguration.loadConfiguration(target);
    }
    public static ArrayList<String> getAllUUIDsAsStrings(){
        ArrayList<String> uuids = new ArrayList<>();
        for (File file : playerdata.listFiles()){
            uuids.add(file.getName().replace(".yml", ""));
        }
        System.out.println(uuids);

        return uuids;
                
    }
    }

