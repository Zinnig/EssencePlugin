package net.zinnig.commands;
import net.zinnig.utils.Items;
import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zinnig
 */
public class LuckyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender.hasPermission("essence.lucky")) {
            int max = 10;
            int min = 1;

            int lucky = ThreadLocalRandom.current().nextInt(min, max + 1);
            switch (lucky) {
                case 1:
                    ItemStack i = Items.createItem(Material.EXPERIENCE_BOTTLE, 20, 1, "Xa");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i);
                    }
                    break;
                case 2:
                    ItemStack i1 = Items.createItem(Material.SLIME_BLOCK, 64, 1, "Slime");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i1);
                    }
                    break;
                case 3:
                    ItemStack i2 = Items.createItem(Material.PINK_TERRACOTTA, 20, 1, "Terracotta");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i2);
                    }
                    break;
                case 4:
                    ItemStack i3 = Items.createItem(Material.GOLD_INGOT, 20, 1, "GOOOOOLD");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i3);
                    }
                    break;
                case 5:
                    ItemStack i4 = Items.createItem(Material.DIAMOND, 20, 1, "DIa");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i4);
                    }
                    break;
                case 6:
                    ItemStack i5 = Items.createItem(Material.CONDUIT, 1, 1, "Conduit");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i5);
                    }
                    break;
                case 7:
                    ItemStack i6 = Items.createItem(Material.DIAMOND_AXE, 1, 1, "Diamond Axe");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i6);
                    }
                    break;
                case 8:
                    ItemStack i7 = Items.createItem(Material.COOKED_COD, 20, 1, "fish");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i7);
                    }
                    break;
                case 9:
                    ItemStack i8 = Items.createItem(Material.WITHER_SKELETON_SKULL, 1, 1, "head");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i8);
                    }
                    break;
                case 10:
                    ItemStack i9 = Items.createItem(Material.ELYTRA, 1, 1, "Let's fly");
                    for (Player a : Bukkit.getOnlinePlayers()) {
                        a.getInventory().setItemInOffHand(i9);
                    }
                    break;
                default:
                    break;
            }
        }else
            sender.sendMessage(StringUtils.permissionError);
        return false;
    }
}
