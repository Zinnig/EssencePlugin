package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Zinnig
 */
public class RandomCommand implements CommandExecutor {
    private final ArrayList<Player> alreadyRandom = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("essence.random")) {
                if (!alreadyRandom.contains(p)) {
                    int min = 500;
                    int max = 1000;
                    int randomNumX = ThreadLocalRandom.current().nextInt(min, max + 1);
                    int randomNumZ = ThreadLocalRandom.current().nextInt(min, max + 1);
                    p.teleport(p.getLocation().add(randomNumX, 100, randomNumZ));
                    p.setBedSpawnLocation(p.getLocation().add(randomNumX, 100, randomNumZ));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255, true));
                    alreadyRandom.add(p);

                } else
                    p.sendMessage(StringUtils.alreadyRandomInSession);
            }else
                p.sendMessage(StringUtils.permissionError);
            }else
                sender.sendMessage(StringUtils.notAPlayerError);
        return false;
    }

}
