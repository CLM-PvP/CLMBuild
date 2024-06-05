package de.clmpvp.clmbuild.Vanish;

import de.clmpvp.clmbuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Manager manager = Main.getVanishManager();
        if (sender.hasPermission("ghostsys.vanish.other")) {
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(Main.notonline);
                    return true;
                }
                if (manager.isVanished(player)) {
                    manager.setVanished(player, false);
                    sender.sendMessage(Main.prefix + "Der Spieler ist jetzt nicht mehr im Vanish");
                } else {
                    manager.setVanished(player, true);
                    sender.sendMessage(Main.prefix + "Der Spieler ist jetzt im Vanish");
                }
                return true;
            }
        }
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("ghostsys.vanish")) {
                if (manager.isVanished(player)) {
                    manager.setVanished(player, false);
                    sender.sendMessage(Main.prefix + "Du bist jetzt nicht mehr im Vanish");
                } else {
                    manager.setVanished(player, true);
                    sender.sendMessage(Main.prefix + "Du bist jetzt im Vanish");
                }
            }
            return true;
        }
        return false;
    }
}
