package de.clmpvp.clmbuild.Commands;

import de.clmpvp.clmbuild.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Matti implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            p.sendMessage(Main.console);
        } else {
            if (p.hasPermission("citybuild.matti")) {
                p.sendMessage(Main.prefix + "MattiCLM ist ein Hund");
            } else {
                p.sendMessage(Main.noperm);
            }
        }

        return false;
    }
}
