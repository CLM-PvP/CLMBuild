package de.clmpvp.clmbuild.Main;

import de.clmpvp.clmbuild.Commands.*;
import de.clmpvp.clmbuild.Listeners.ChatListener;
import de.clmpvp.clmbuild.Listeners.JoinListener;
import de.clmpvp.clmbuild.Listeners.QuitListener;
import de.clmpvp.clmbuild.Vanish.Manager;
import de.clmpvp.clmbuild.Vanish.VanishCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private static Manager manager;

    public static String prefix = "§7[§bCityBuild§7] ";
    public static String noperm = "§7[§bCityBuild§7] Dazu hast du keine Rechte ";
    public static String console = "§7[§bCityBuild§7] §cDu musst ein Spieler sein umd dies Auszuführen! ";
    public static String use = "§7[§bCityBuild§7] §cBitte benutze ";
    public static String notonline = "§7[§bCityBuild§7] Dieser Spieler ist nicht online! ";
    public static String world = "CityBuild1";

    @Override
    public void onEnable() {
        manager = new Manager((Main) this);
        instance = this;
        //Commands
        getCommand("tc").setExecutor(new TeamChat());
        getCommand("teamchat").setExecutor(new TeamChat());
        getCommand("ec").setExecutor(new EnderChest());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("fly").setExecutor(new Fly());
        getCommand("kopf").setExecutor(new Kopf());
        getCommand("matti").setExecutor(new Matti());
        getCommand("v").setExecutor(new VanishCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("perks").setExecutor(new Perks(this));
        getCommand("luckyblock").setExecutor(new Luckyblock(this));
        getCommand("ban").setExecutor(new Ban(this));

        //Listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new JoinListener(), this);
    }

    @Override
    public void onDisable() {

    }
    public static Manager getVanishManager() {
        return manager;
    }
}
