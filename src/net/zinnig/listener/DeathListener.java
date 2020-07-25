package net.zinnig.listener;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


/**
 * @author Zinnig
 */
public class DeathListener implements Listener {
    @EventHandler
    //When a player dies
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity().getPlayer();
        if(p.hasPermission("essence.deathtp")) {
            double deathX = e.getEntity().getPlayer().getLocation().getX();
            double deathY = e.getEntity().getPlayer().getLocation().getY();
            double deathZ = e.getEntity().getPlayer().getLocation().getZ();
            TextComponent tc = new TextComponent();
            tc.setText("You died there(click)");
            tc.setColor(ChatColor.AQUA);
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/minecraft:tp " + p.getName() + " " + deathX + " " + deathY + " " + deathZ));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Teleport you to your death point!").create()));
            p.spigot().sendMessage(tc);
        }
    }
}
