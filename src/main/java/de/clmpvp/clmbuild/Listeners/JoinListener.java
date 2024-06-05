package de.clmpvp.clmbuild.Listeners;

import de.clmpvp.clmbuild.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    public static Main plugin;

    public JoinListener() {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        if (p.hasPermission("citybuild.vanish")) {
            Main.getVanishManager().setVanished(p, true);
            Main.getVanishManager().hideAll(p);
            p.sendMessage(Main.prefix + "Da du die Permission citybuild.vanish hast bist du beim Joinen automatisch im Vanish");
        } else {
            Main.getVanishManager().setVanished(p, false);
        }
    }

}
