package net.zinnig.listener;

import net.zinnig.utils.EnumUtil;
import net.zinnig.utils.Files;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author Zinnig
 * Created: 10.08.2018
 * ENUM Utils is from Essentials X ->
 */
public class SignListener implements Listener {
    private static final Material SIGN_POST = EnumUtil.getMaterial("SIGN", "SIGN_POST");
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[warp]")) {
            e.setLine(0, "§1[Warp]");
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(b.getType() == Material.WALL_SIGN || b.getType() == SIGN_POST){
                Sign s = (Sign) b.getState();
                if(ChatColor.stripColor(s.getLine(0)).equalsIgnoreCase("[warp]")){
                    String warpName = s.getLine(1);
                    if(Files.warpCfg.contains("Warps." + warpName)){
                        Bukkit.dispatchCommand(p,"warp " + warpName);
                    }
                }
            }
        }


    }
}
