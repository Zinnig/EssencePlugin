package net.zinnig.listener;

import net.zinnig.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


/**
 * @author Zinnig
 * Created: 10.08.2018
 */
public class ChatListener implements Listener { 
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String msgTrim = e.getMessage().trim();
        String msg = msgTrim.replace("%", " percent");
        e.setMessage(msg);

        if(p.hasPermission("essence.chat.owner")){
            e.setFormat(StringUtils.ownerFormat + p.getName() + StringUtils.suffix + " " + StringUtils.ownerWriteColor + msg);
        }else if(p.hasPermission("essence.chat.admin")){
            e.setFormat(StringUtils.adminFormat + p.getName() + StringUtils.suffix + " " + StringUtils.adminWriteColor + msg);
        }else if(p.hasPermission("essence.chat.dev")){
            e.setFormat(StringUtils.devFormat  + p.getName() + StringUtils.suffix + " " + StringUtils.devWriteColor + msg);
        }else if(p.hasPermission("essence.chat.mod")){
            e.setFormat(StringUtils.modFormat + p.getName() + StringUtils.suffix + " " + StringUtils.modWriteColor + msg);
        }else if(p.hasPermission("essence.chat.helper")){
            e.setFormat(StringUtils.helperFormat  + p.getName() + StringUtils.suffix + " " + StringUtils.helperWriteColor + msg);
        }else if(p.hasPermission("essence.chat.youtube")){
            e.setFormat(StringUtils.youtubeFormat + p.getName() + StringUtils.suffix + " " + StringUtils.youtubeWriteColor + msg);
        }else if(p.hasPermission("essence.chat.vip")){
            e.setFormat(StringUtils.vipFormat  + p.getName() + StringUtils.suffix + " " + StringUtils.vipWriteColor + msg);
        }else{
            e.setFormat(StringUtils.playerFormat + p.getName() + StringUtils.suffix + " " + StringUtils.playerWriteColor + msg);
        }


    }



}
