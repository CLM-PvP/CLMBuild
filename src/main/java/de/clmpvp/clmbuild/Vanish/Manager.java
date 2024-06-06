package de.clmpvp.clmbuild.Vanish;

import java.util.ArrayList;
import java.util.List;

import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Manager {
    private final Main plugin;

    private final List<Player> vanished;

    public Manager(Main plugin) {
        this.plugin = plugin;
        this.vanished = new ArrayList<>();
    }

    public Manager(Main plugin, List<Player> vanished) {
        this.plugin = plugin;
        this.vanished = vanished;
    }

    public List<Player> getVanished() {
        return this.vanished;
    }

    public boolean isVanished(Player player) {
        return this.vanished.contains(player);
    }

    public void setVanished(Player player, boolean bool) {
        if (bool) {
            this.vanished.add(player);
        } else {
            this.vanished.remove(player);
        }
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (player.equals(onlinePlayer))
                continue;
            if (bool) {
                onlinePlayer.hidePlayer(player);
                continue;
            }
            onlinePlayer.showPlayer(player);
        }
    }

    public void hideAll(Player player) {
        this.vanished.forEach(player1 -> player.hidePlayer(player1));
    }
}
