package net.zinnig.commands;

import net.zinnig.utils.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Zinnig
 * Created: 05.08.2018
 */
public class HeadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("essence.head")){
                if(args.length == 0 ){
                if(p.getInventory().getItemInMainHand().getType() != Material.AIR) {
                    //Getting the wearing helmet
                    ItemStack atHead = p.getInventory().getHelmet();
                    //Getting the item in the main hand
                    ItemStack inMainHand = p.getInventory().getItemInMainHand();
                    //Getting the HeldItemSlot
                    int HeldItemSlot = p.getInventory().getHeldItemSlot();
                    //Setting the Helmet/or at head slot wearing item in the hand
                    p.getInventory().setItem(HeldItemSlot, atHead);
                    //Setting the chosen Item to the head slot
                    p.getInventory().setHelmet(inMainHand);
                    //Name of the item, who got on the head slot
                    String itemHead = inMainHand.getData().getItemType().name().replace("LEGACY_", "").toLowerCase();
                    p.sendMessage("§aYou're now wearing: §b" + itemHead);
                }else
                    p.sendMessage(StringUtils.getErrorPrefix() + "§cYour can't carry air!");
                }else
                    p.sendMessage(StringUtils.argumentsError);
            }else
                p.sendMessage(StringUtils.permissionError);
        }else
            sender.sendMessage(StringUtils.notAPlayerError);

        return false;
    }
}
