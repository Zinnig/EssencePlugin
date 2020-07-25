package net.zinnig.utils;

import org.bukkit.ChatColor;

/**
 * @author Zinnig
 * Created: 10.08.2018
 */
public class StringUtils {

    private static final String errorPrefix = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.ErrorFormat"));
    public static final String argumentsError = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.ArgumentsError"));
    public static final String permissionError = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.PermissionsError"));
    public static final String notAPlayerError = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.NotAPlayerError"));
    public static final String noPlayerFoundError = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.NoPlayerFoundError"));
    public static final String warpPointNotExists = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.WarpPointNotExists"));
    public static final String warpPointAlreadyExists = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.WarpPointAlreadyExists"));
    public static final String healPointsAlreadyFull = errorPrefix +ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.HealPointsAlreadyFull"));
    public static final String alreadyRandomInSession = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.AlreadyRandomInSession"));
    public static final String hungerPointsAlreadyFull = errorPrefix + ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("ErrorMessage.HungerPointsAlreadyFull"));

    public static final String ownerFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.OwnerPrefix"));
    public static final String adminFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.AdminPrefix"));
    public static final String devFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.DevPrefix"));
    public static final String modFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.ModPrefix"));
    public static final String helperFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.HelperPrefix"));
    public static final String youtubeFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.YoutubePrefix"));
    public static final String vipFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.VIPPrefix"));
    public static final String playerFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Prefix.PlayerPrefix"));

    public static final String suffix = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.Suffix"));


    public static final String ownerWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Owner"));
    public static final String adminWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Admin"));
    public static final String devWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Dev"));
    public static final String modWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Mod"));
    public static final String helperWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Helper"));
    public static final String youtubeWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Youtube"));
    public static final String vipWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.VIP"));
    public static final String playerWriteColor = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Chat.WriteColor.Player"));

    public static final String ownerTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.OwnerPrefix"));
    public static final String adminTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.AdminPrefix"));
    public static final String devTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.DevPrefix"));
    public static final String modTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.ModPrefix"));
    public static final String helperTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.HelperPrefix"));
    public static final String youtubeTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.YoutubePrefix"));
    public static final String vipTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.VIPPrefix"));
    public static final String playerTabFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Tablist.Prefix.PlayerPrefix"));

    public static final String banFormat = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("Ban.BanFormat"));
    public static final String dateFormat = Files.cfg.getString("Ban.DateFormat");

    public static final String joinMessage = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("JoinLeaveMessage.JoinMessage"));
    public static final String leaveMessage = ChatColor.translateAlternateColorCodes('&', Files.cfg.getString("JoinLeaveMessage.LeaveMessage"));

    public static String getErrorPrefix() {
        return errorPrefix;
    }
}
