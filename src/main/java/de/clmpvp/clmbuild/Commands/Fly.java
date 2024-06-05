package de.clmpvp.clmbuild.Commands;

import de.clmpvp.clmbuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.fly")) {
                if (args.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(Main.prefix + "Dein Fly Mode wurde §aDeaktiviert");
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(Main.prefix + "Dein Fly Mode wurde §aAktiviert");
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
                    }
                } else {
                    if (args.length == 1) {
                        if (p.hasPermission("ghostsys.fly.other")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                if (target.getAllowFlight()) {
                                    target.setAllowFlight(false);
                                    target.setFlying(false);
                                    target.sendMessage(Main.prefix + "Dein Fly Mode wurde §aDeaktiviert");
                                    p.sendMessage(Main.prefix + "Du hast den Fly Mode von " + target.getName() + " §aDeaktiviert");
                                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
                                } else {
                                    target.setAllowFlight(true);
                                    target.setFlying(true);
                                    target.sendMessage(Main.prefix + "Dein Fly Mode wurde §aAktiviert");
                                    p.sendMessage(Main.prefix + "Du hast den Fly Mode von " + target.getName() + " §aAktiviert");
                                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
                                }
                            } else {
                                p.sendMessage(Main.notonline);
                            }
                        } else {
                            p.sendMessage(Main.noperm);
                        }
                    }
                }
            }
        }
        return false;
    }
}
