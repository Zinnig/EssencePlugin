/*
 * Copyright (c) Zinnig 2019.
 * File created: 22/09/2019, 11:29
 * File last modified: 22/09/2019, 11:29
 */

package net.zinnig.listener;

import net.zinnig.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("essence.silentleave")) {
            e.setQuitMessage(StringUtils.leaveMessage.replace("%player%", "") + p.getName());
        }else{
            e.setQuitMessage(" ");
        }
    }
}
