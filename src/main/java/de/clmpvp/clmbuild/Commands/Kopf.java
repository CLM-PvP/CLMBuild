package de.clmpvp.clmbuild.Commands;

import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Kopf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("ghostsys.kopf")) {
                if (args.length == 1) {
                    ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                    SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
                    skullMeta.setOwner(args[0]);
                    skullMeta.setDisplayName(args[0]);
                    itemStack.setItemMeta(skullMeta);
                    p.getInventory().addItem(new ItemStack[]{itemStack});
                    p.updateInventory();
                    p.sendMessage(Main.prefix + "Du hast den Kopf von §e" + args[0] + " §7erhalten");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);

                } else {
                    p.sendMessage(Main.use + "/kopf <spieler>");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return false;
    }
}
