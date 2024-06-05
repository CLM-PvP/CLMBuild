package de.clmpvp.clmbuild.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();
        m.replace("%", "Prozent");

        if (p.hasPermission("clmlobby.leitung")) {
            e.setFormat("§4Admin §8» §4" + p.getDisplayName() + " §7> " + m);
        } else if (p.hasPermission("clmlobby.derechteclm")) {
            e.setFormat("§5Der echte CLM §8» §5" + p.getDisplayName() + " §7> " + m);
        } else if (p.hasPermission("clmlobby.dev")) {
            e.setFormat("§bDev §8» §b" + p.getDisplayName() + " §7> " + m);
        } else if (p.hasPermission("clmlobby.supporter")) {
            e.setFormat("§aSupporter §8» §a" + p.getDisplayName() + " §7> " + m);
        } else if (p.hasPermission("clmlobby.premium")) {
            e.setFormat("§6Premium §8» §6" + p.getDisplayName() + " §7> " + m);
        } else if (p.hasPermission("clmlobby.spieler")) {
            e.setFormat("§7Spieler §8» §7" + p.getDisplayName() + " §7> " + m);
        }
    }

}
