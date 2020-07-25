package net.zinnig.listener;


import net.zinnig.commands.EssenceCommand;
import net.zinnig.utils.Files;
import net.zinnig.utils.Items;
import net.zinnig.utils.PagesHandler;
import net.zinnig.utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.util.ArrayList;

public class InventoryClickListener implements Listener {
    public boolean change = false;

        @EventHandler

        public void onClick (InventoryClickEvent e){
            if(!EssenceCommand.invOpened){
                return;
            }
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getName().startsWith("Tools") && e.getClickedInventory().getSize() == 36) {
            e.setCancelled(true);
        }
        try {

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Config")) {
                /*
                 * Creating the Inventory "Config", putting the items in cet inventory.
                 */
                Inventory current = PagesHandler.createNewPage(p, 36, "Config");

                current.setItem(current.firstEmpty(), Items.createItem(Material.PAPER, 1, 0, "Chat"));
                current.setItem(current.firstEmpty(), Items.createItem(Material.BOOK, 1, 0, "Tablist"));
                current.setItem(current.firstEmpty(), Items.createItem(Material.BARRIER, 1, 0, "Ban"));
                current.setItem(current.firstEmpty(), Items.createItem(Material.STRUCTURE_VOID, 1, 0, "ErrorMessage"));

                File pFile = PlayerData.getFileByName(PlayerData.getUUIDfromName(p.getDisplayName()).toString());
                FileConfiguration pConf = YamlConfiguration.loadConfiguration(pFile);

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Chat")) {
                    current = PagesHandler.createNewPage(p, 36, "Config - Chat");
                    for (String s : Files.cfg.getConfigurationSection("Chat").getKeys(false)) {
                        current.setItem(current.firstEmpty(), Items.createItem(Material.PAPER, 1, 0, s));
                    }
                    if (e.getCurrentItem().getType() == Material.PAPER) {
                        p.closeInventory();
                        p.sendMessage("§aType your changes to the setting in the chat");
                        change = true;
                        pConf.set("Chat. " + e.getCurrentItem().getItemMeta().getDisplayName(), new ConfigEditingChatListener().getMessage());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Tablist")) {
                    current = PagesHandler.createNewPage(p, 36, "Config - Tablist");
                    for (String s : Files.cfg.getConfigurationSection("Tablist").getKeys(false)) {
                        current.setItem(current.firstEmpty(), Items.createItem(Material.BOOK, 1, 0, s));
                    }
                    if (e.getCurrentItem().getType() == Material.BOOK) {
                        p.closeInventory();
                        p.sendMessage("§aType your changes to the setting in the chat");
                        change = true;
                        pConf.set("Tablist. " + e.getCurrentItem().getItemMeta().getDisplayName(), new ConfigEditingChatListener().getMessage());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Ban")) {
                    current = PagesHandler.createNewPage(p, 36, "Config - Ban");
                    for (String s : Files.cfg.getConfigurationSection("Ban").getKeys(false)) {
                        current.setItem(current.firstEmpty(), Items.createItem(Material.BARRIER, 1, 0, s));
                    }
                    if (e.getCurrentItem().getType() == Material.BARRIER) {
                        p.closeInventory();
                        p.sendMessage("§aType your changes to the setting in the chat");
                        change = true;
                        pConf.set("Ban. " + e.getCurrentItem().getItemMeta().getDisplayName(), new ConfigEditingChatListener().getMessage());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("ErrorMessage")) {
                    current = PagesHandler.createNewPage(p, 36, "Config - ErrorMessage");
                    for (String s : Files.cfg.getConfigurationSection("ErrorMessage").getKeys(false)) {
                        current.setItem(current.firstEmpty(), Items.createItem(Material.STRUCTURE_VOID, 1, 0, s));
                    }
                }
                if (e.getCurrentItem().getType() == Material.STRUCTURE_VOID) {
                    p.closeInventory();
                    p.sendMessage("§aType your changes to the setting in the chat");
                    change = true;
                    pConf.set("ErrorMessage. " + e.getCurrentItem().getItemMeta().getDisplayName(), new ConfigEditingChatListener().getMessage());
                }

            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("PlayerData")) {
                Inventory current = PagesHandler.createNewPage(p, 36, "PlayerData");
                ArrayList<String> UUIDsAsStrings = PlayerData.getAllUUIDsAsStrings();
                for (String s : UUIDsAsStrings) {
                    if (UUIDsAsStrings.size() <= 36) {
                        Player p1 = Bukkit.getPlayer(s);
                        File playerfile = PlayerData.getFileByName(s);
                        YamlConfiguration playerCfg = YamlConfiguration.loadConfiguration(playerfile);
                        if (playerCfg.getBoolean("Ban.isBanned")) {
                            current.setItem(current.firstEmpty(), Items.createItem(Material.RED_CONCRETE, 1, 0, playerCfg.get("Name") + "(" + s + ")"));
                        } else if (!playerCfg.getBoolean("Ban.isBanned")) {
                            current.setItem(current.firstEmpty(), Items.createItem(Material.GREEN_CONCRETE, 1, 0, playerCfg.get("Name") + "(" + s + ")"));
                        }
                    } else {
                        //Will be added later
                        break;
                    }
                }
            }

        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause().toString());

        }
    }
}
