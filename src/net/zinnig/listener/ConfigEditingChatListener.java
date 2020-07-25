/*
 * Copyright (c) Zinnig 2019.
 * File created: 7/8/19 10:27 PM
 * File last modified: 7/8/19 10:27 PM
 */

package net.zinnig.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ConfigEditingChatListener implements Listener {
    private String message;
    @EventHandler
    public void onEdit(AsyncPlayerChatEvent e) {
        if (new InventoryClickListener().change) {
            e.setCancelled(true);
            message = e.getMessage();
            new InventoryClickListener().change = false;
        }
    }

    public String getMessage() {
        return message;
    }
}
