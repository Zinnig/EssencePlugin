package net.zinnig.listener;

import net.zinnig.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {
    private String s;
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission("essence.tablist.owner")){
            p.setPlayerListName(StringUtils.ownerTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.admin")){
            p.setPlayerListName(StringUtils.adminTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.dev")){
            p.setPlayerListName(StringUtils.devTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.mod")){
            p.setPlayerListName(StringUtils.modTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.helper")){
            p.setPlayerListName(StringUtils.helperTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.youtube")){
            p.setPlayerListName(StringUtils.youtubeTabFormat + p.getName());
        }else if (p.hasPermission("essence.tablist.vip")){
            p.setPlayerListName(StringUtils.vipTabFormat + p.getName());
        }else
            p.setPlayerListName(StringUtils.playerTabFormat + p.getName());
    if(!p.hasPermission("essence.silentjoin")) {
        if (p.hasPermission("essence.chat.owner")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.ownerFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.admin")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.adminFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.dev")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.devFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.mod")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.modFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.helper")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.helperFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.youtube")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.youtubeFormat + e.getPlayer().getName());
        } else if (p.hasPermission("essence.chat.vip")) {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.vipFormat + e.getPlayer().getName());
        } else {
            e.setJoinMessage(StringUtils.joinMessage.replace("%player%", "") + StringUtils.playerFormat + e.getPlayer().getName());
        }
    }
    }
    }


