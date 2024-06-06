package de.clmpvp.clmbuild.Api;

import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BreakBlock implements CommandExecutor {

    private Main plugin;

    public BreakBlock(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("breakblock").setExecutor(this);
    }

    public static ArrayList<Player> BB = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            p.sendMessage(Main.prefix + "klicke einen Block an, um ihn zu zerstören zu können");

                    BB.add(p);

        } else {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "Console kann keine Blöcke zerstören");
        }

        return true;
    }
}
