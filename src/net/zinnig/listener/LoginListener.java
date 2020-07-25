package net.zinnig.listener;

import net.zinnig.utils.PlayerData;
import net.zinnig.utils.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LoginListener implements Listener{


    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        UUID s = p.getUniqueId();
        new PlayerData(s);
        File playerfile = PlayerData.getFileByName(s.toString());
        YamlConfiguration playerCfg = YamlConfiguration.loadConfiguration(playerfile);
        if(p.isOp()){
            playerCfg.set("Ban.Bannable", false);
        }else
            playerCfg.set("Ban.Bannable", true);
        PlayerData.saveFilePlayerdata(s, playerCfg);
        if(playerCfg.getLong("Ban.Until") > 0) {
            if (playerCfg.getBoolean("Ban.isBanned") && (playerCfg.getLong("Ban.Until") > System.currentTimeMillis())) {

                String banMessage = StringUtils.banFormat.replace("%Reason%", playerCfg.get("Ban.Reason").toString());
                Date replacementDate = new Date();
                replacementDate.setTime(playerCfg.getLong("Ban.Until"));
                String rdFormat = new SimpleDateFormat(StringUtils.dateFormat).format(replacementDate);
                String banMessage1 = banMessage.replace("%Until%", rdFormat);
                String banMessage2 = banMessage1.replace("%From%", playerCfg.get("Ban.From").toString());
                e.disallow(PlayerLoginEvent.Result.KICK_BANNED, banMessage2);
            }
        }else if(playerCfg.getBoolean("Ban.isBanned")){
            String banMessage = StringUtils.banFormat.replace("%Reason%", playerCfg.get("Ban.Reason").toString());
            String banMessage1 = banMessage.replace("%Until%", "-");
            String banMessage2 = banMessage1.replace("%From%", playerCfg.get("Ban.From").toString());
            e.disallow(PlayerLoginEvent.Result.KICK_BANNED, banMessage2);
        }


    }
}