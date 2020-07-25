package net.zinnig.listener;

import net.zinnig.utils.Files;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Zinnig
 */
public class BlockBreakListener implements Listener {
    @EventHandler
    //when an iron- or a gold gets broken it drops a gold/iron ingot and xp-bottles.
    public void onBreak(BlockBreakEvent e){
        Block b = e.getBlock();
        Player p = e.getPlayer();
        if(p.hasPermission("essence.goldore") && Files.cfg.getBoolean("OreAutoSmelt.goldOre")) {
            if (b.getType() == Material.GOLD_ORE) {
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 0), new ItemStack(Material.GOLD_INGOT));
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 0), new ItemStack(Material.EXPERIENCE_BOTTLE));
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 0), new ItemStack(Material.EXPERIENCE_BOTTLE));
                b.setType(Material.AIR);
            }
        }
        if(p.hasPermission("essence.ironore") && Files.cfg.getBoolean("OreAutoSmelt.ironOre")) {
            if (b.getType() == Material.IRON_ORE) {
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 0), new ItemStack(Material.IRON_INGOT));
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 0), new ItemStack(Material.EXPERIENCE_BOTTLE));
                b.setType(Material.AIR);

            }
        }
    }
}
