package net.zinnig.listener;

import net.zinnig.commands.GodCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player && GodCommand.GodMode.contains(e.getEntity())) {
            e.setCancelled(true);
            ((Player) e.getEntity()).setHealth(((Player) e.getEntity()).getMaxHealth());
        }
    }
}
