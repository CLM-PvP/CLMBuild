package de.clmpvp.clmbuild.Commands;

import java.io.File;
import java.io.IOException;

import de.clmpvp.clmbuild.Main.ItemBuilder;
import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Perks implements CommandExecutor {

    private Main plugin;

    public Perks(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("perk").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        File Perk = new File("plugins/GrieferGames/Data/Perk.yml");
        YamlConfiguration yPerk = YamlConfiguration.loadConfiguration(Perk);

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(p.hasPermission("system.perk.nofall.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".NoFall") == null) {

                    yPerk.set(p.getUniqueId() + ".NoFall", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(p.hasPermission("system.perk.mutep.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".Mutep") == null) {

                    yPerk.set(p.getUniqueId() + ".Mutep", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(p.hasPermission("system.perk.SlowChat.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".SlowChat") == null) {

                    yPerk.set(p.getUniqueId() + ".SlowChat", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(p.hasPermission("system.perk.NoHunger.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".NoHunger") == null) {

                    yPerk.set(p.getUniqueId() + ".NoHunger", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(p.hasPermission("system.perk.ClearChat.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".ClearChat") == null) {

                    yPerk.set(p.getUniqueId() + ".ClearChat", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if(p.hasPermission("system.perk.StartKick.bypass")) {
                if(yPerk.getString(p.getUniqueId() + ".StartKick") == null) {

                    yPerk.set(p.getUniqueId() + ".StartKick", true);
                    try {
                        yPerk.save(Perk);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            Inventory Perks = Bukkit.createInventory(null, 9*4, "§cPerks");

                    //Aktiviert
            @SuppressWarnings("deprecation")
            ItemStack Aktiviert = new ItemStack(351, 1, (short) 10);
            ItemMeta AktiviertM = Aktiviert.getItemMeta();
            AktiviertM.setDisplayName("§cPerks Aktiviert");
            Aktiviert.setItemMeta(AktiviertM);

            //Deaktiviert
            @SuppressWarnings("deprecation")
            ItemStack Deaktiviert = new ItemStack(351, 1, (short) 8);
            ItemMeta DeaktiviertM = Deaktiviert.getItemMeta();
            DeaktiviertM.setDisplayName("§cPerks Deaktiviert");
            Deaktiviert.setItemMeta(DeaktiviertM);

            Integer NoFall = plugin.getConfig().getInt("NoFallPerk");
            Integer NoHunger = plugin.getConfig().getInt("NoHungerPerk");
            Integer MutepPerk = plugin.getConfig().getInt("MutepPerk");
            Integer ClearChatPerk = plugin.getConfig().getInt("ClearChatPerk");
            Integer SlowChatPerk = plugin.getConfig().getInt("SlowChatPerk");
            Integer StartKickPerk = plugin.getConfig().getInt("StartKickPerk");

            //NoFall
            Perks.setItem(1, ItemBuilder.createItem(Material.FEATHER, "§6§lNoFall Perk", 1, new String[] {"Kein Fallschaden mehr"}));

            if(yPerk.getString(p.getUniqueId() + ".NoFall") == null) {
                Perks.setItem(2, preis(NoFall));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".NoFall") == true) {
                Perks.setItem(2, Aktiviert);
            } else if(yPerk.getBoolean(p.getUniqueId() + ".NoFall") == false) {
                Perks.setItem(2, Deaktiviert);
            }

            //KeinHunger

            if(yPerk.getString(p.getUniqueId() + ".NoHunger") == null) {
                Perks.setItem(6, preis(NoHunger));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".NoHunger") == true) {
                Perks.setItem(6, Aktiviert);
            } else if(yPerk.getBoolean(p.getUniqueId() + ".NoHunger") == false) {
                Perks.setItem(6, Deaktiviert);
            }

            Perks.setItem(7, ItemBuilder.createItem(Material.COOKED_BEEF, "Hunger", 1, new String[] {"Kein Hunger mehr"}));

            //Mutep
            Perks.setItem(10, ItemBuilder.createItem(Material.DIAMOND, "§6§ö/mutep", 1, new String[] {"Benutze den /mutep Befehl"}));

            if(yPerk.getString(p.getUniqueId() + ".Mutep") == null) {
                Perks.setItem(11, preis(MutepPerk));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".Mutep") == true) {
                Perks.setItem(11, Aktiviert);
            }

            //ClearChat

            if(yPerk.getString(p.getUniqueId() + ".ClearChat") == null) {
                Perks.setItem(15, preis(ClearChatPerk));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".ClearChat") == true) {
                Perks.setItem(15, Aktiviert);
            }

            Perks.setItem(16, ItemBuilder.createItem(Material.LAPIS_ORE, "§6§lClearchat", 1, new String[] {"Du kannst den Chat clearen"}));

                    //SlowChat
                    Perks.setItem(19, ItemBuilder.createItem(Material.GOLD_ORE, "§6§lSlowchat", 1, new String[] {"Du kannst den Chat verlangsamen"}));

            if(yPerk.getString(p.getUniqueId() + ".SlowChat") == null) {
                Perks.setItem(20, preis(SlowChatPerk));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".SlowChat") == true) {
                Perks.setItem(20, Aktiviert);
            }

            //StartKick

            if(yPerk.getString(p.getUniqueId() + ".StartKick") == null) {
                Perks.setItem(24, preis(StartKickPerk));
            } else if(yPerk.getBoolean(p.getUniqueId() + ".StartKick") == true) {
                Perks.setItem(24, Aktiviert);
            }

            Perks.setItem(25, ItemBuilder.createItem(Material.IRON_ORE, "§6§l/startkick", 1, new String[] {"Benutze den /startkick Befehl"}));

                    p.openInventory(Perks);

        } else {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "Die Console kann keine Perks nutzen!");
        }

        return true;
    }

    public org.bukkit.inventory.ItemStack preis(Integer Preis) {

        org.bukkit.inventory.ItemStack i = ItemBuilder.createItemOL(Material.PAPER, "§e§lPreis: §f"+ Preis + "$", 1);

        return i;
    }

}
