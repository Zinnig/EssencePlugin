package net.zinnig.main;

import net.zinnig.commands.*;
import net.zinnig.listener.*;
import net.zinnig.utils.Files;
import net.zinnig.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Zinnig
 */
public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onDisable() {
        System.out.println("Stopped");
    }

    @Override
    public void onLoad() {
        System.out.println("Starting up...");
    }

    @Override
    public void onEnable() {
        System.out.println("Started");
        instance = this;
        //Setup Files - Config
        Files.setupFile();
        Files.reloadCustomConfig();
        //Setup Files - Warps
        Files.saveFileWarps();
        Files.reloadCustomConfigWarps();

        //Commands
        getCommand("gm").setExecutor(new GMCommand());
        getCommand("random").setExecutor(new RandomCommand());
        getCommand("find").setExecutor(new FindCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("lucky").setExecutor(new LuckyCommand());
        getCommand("head").setExecutor(new HeadCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("setwarp").setExecutor(new SetWarpCommand());
        getCommand("delwarp").setExecutor(new DelWarpCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("warplist").setExecutor(new WarpListCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("inventory").setExecutor(new InventoryCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("unban").setExecutor(new UnBanCommand());
        getCommand("essence").setExecutor(new EssenceCommand());
        getCommand("toggleautosmelt").setExecutor(new ToggleAutoSmeltCommand());
        //Listeners
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new SignListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(), this);


        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("essence.tablist.owner")) {
                p.setPlayerListName(StringUtils.ownerTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.admin")) {
                p.setPlayerListName(StringUtils.adminTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.dev")) {
                p.setPlayerListName(StringUtils.devTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.mod")) {
                p.setPlayerListName(StringUtils.modTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.helper")) {
                p.setPlayerListName(StringUtils.helperTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.youtube")) {
                p.setPlayerListName(StringUtils.youtubeTabFormat + p.getName());
            } else if (p.hasPermission("essence.tablist.vip")) {
                p.setPlayerListName(StringUtils.vipTabFormat + p.getName());
            } else
                p.setPlayerListName(StringUtils.playerTabFormat + p.getName());
        }
    }
    public static Main getInstance(){
        return instance;
    }
}
