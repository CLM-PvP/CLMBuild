package de.clmpvp.clmbuild.Commands;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import sun.security.mscapi.PRNG;

public class Ban implements CommandExecutor {

    public static File Banned = new File("plugins/CLMBuild/Data/BanSystem/Banned.yml");
    public static YamlConfiguration Banned_cfg = YamlConfiguration.loadConfiguration(Banned);

    public static File Mutet = new File("plugins/CLMBuild/Data/BanSystem/Mutet.yml");
    public static YamlConfiguration Mutet_cfg = YamlConfiguration.loadConfiguration(Mutet);

    private static Main plugin;

    @SuppressWarnings("static-access")
    public Ban(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("ban").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(p.hasPermission("system.BanSystem.ban.use")) {
                if(args.length == 2) {

                    String target = args[0];
                    Player tar = Bukkit.getPlayer(target);

                    @SuppressWarnings("deprecation")
                    UUID UUIDP = Bukkit.getOfflinePlayer(target).getUniqueId();

                    if(args[1].equalsIgnoreCase("1")) {
                        if(p.hasPermission("system.BanSystem.ban.1")) {
                            SetBanned(tar, UUIDP, target, 1209600, "Hacking", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("2")) {
                        if(p.hasPermission("system.BanSystem.ban.2")) {
                            SetBanned(tar, UUIDP, target, 1209600, "Rassismus in extremer Form", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("3")) {
                        if(p.hasPermission("system.BanSystem.ban.3")) {
                            SetMutet(tar, UUIDP, target, 10800, "harte Beleidigung", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("4")) {
                        if(p.hasPermission("system.BanSystem.ban.4")) {
                            SetMutet(tar, UUIDP, target, 86400, "mehrfache Werbung", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("5")) {
                        if(p.hasPermission("system.BanSystem.ban.5")) {
                            SetMutet(tar, UUIDP, target, 3600, "Extremer Spam", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("6")) {
                        if(p.hasPermission("system.BanSystem.ban.6")) {
                            SetBanned(tar, UUIDP, target, 604800, "Rangmissbrauch", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("7")) {
                        if(p.hasPermission("system.BanSystem.ban.7")) {
                            SetBanned(tar, UUIDP, target, 259200, "Unangebrachter Skin/Name", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("8")) {
                        if(p.hasPermission("system.BanSystem.ban.8")) {
                            SetMutet(tar, UUIDP, target, 1800, "Provokantes Verhalten", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("9")) {
                        if(p.hasPermission("system.BanSystem.ban.9")) {
                            SetBanned(tar, UUIDP, target, 86400, "Bugusing", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("10")) {
                        if(p.hasPermission("system.BanSystem.ban.10")) {
                            SetBanned(tar, UUIDP, target, 1814400, "Echtgeldhandel", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("11")) {
                        if(p.hasPermission("system.BanSystem.ban.11")) {
                            SetMutet(tar, UUIDP, target, 10800, "Nicken als bekannte Person", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("12")) {
                        if(p.hasPermission("system.BanSystem.ban.12")) {
                            SetMutet(tar, UUIDP, target, 43200, "Ingamebetrug", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("13")) {
                        if(p.hasPermission("system.BanSystem.ban.13")) {
                            SetMutet(tar, UUIDP, target, 1209600, "verprivater Daten", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("14")) {
                        if(p.hasPermission("system.BanSystem.ban.14")) {
                            SetPermaBanned(tar, UUIDP, target, "Duplizieren", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("15")) {
                        if(p.hasPermission("system.BanSystem.ban.15")) {
                            SetMutet(tar, UUIDP, target, 604800, "Sexismus", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("16")) {
                        if(p.hasPermission("system.BanSystem.ban.16")) {
                            SetBanned(tar, UUIDP, target, 900, "Kurzer Timeout vom Admin", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("17")) {
                        if(p.hasPermission("system.BanSystem.ban.17")) {
                            SetMutet(tar, UUIDP, target, 1800, "Spam", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "darfst diese BanId nicht nutzen!");
                        }
                    } else if(args[1].equalsIgnoreCase("99")) {
                        if(p.hasPermission("system.BanSystem.ban.99")) {
                            SetPermaBanned(tar, UUIDP, target, "Ban eines Admins", p.getName(), p);
                        } else {
                            p.sendMessage(Main.prefix + "Du darfst diese BanId nicht nutzen!");
                        }
                    } else {
                        p.sendMessage(Main.prefix + "<Spieler> <GrundId>");
                        p.sendMessage("§4ID: §cBAN §c- §4Hacking");
                        p.sendMessage("§4ID: §cBAN §c- §4Rassismus in harter Form");
                        p.sendMessage("§4ID: §cMUTE §c- §4harte Beleidigung");
                        p.sendMessage("§4ID: §cMUTE §c- §4mehrfache Werbung");
                        p.sendMessage("§4ID: §cMUTE §c- §4Extremer Spam");
                        p.sendMessage("§4ID: §cBAN §c- §4Rangmissbrauch");
                        p.sendMessage("§4ID: §cBAN §c- §4Unangebrachter Skin/Name");
                        p.sendMessage("§4ID: §cMUTE §c- §4Provokantes Verhalten");
                        p.sendMessage("§4ID: §cBAN §c- §4Bugusing");
                        p.sendMessage("§4ID: §cBAN §c- §4Echtgeldhandel");
                        p.sendMessage("§4ID: §cMUTE §c- §4Nicken als bekannte Person");
                        p.sendMessage("§4ID: §cMUTE §c- §4Ingamebetrug");
                        p.sendMessage("§4ID: §cMUTE §c- §4veröffentlichung provater Daten");
                        p.sendMessage("§4ID: §cBAN §c- §4Duplizieren");
                        p.sendMessage("§4ID: §cMUTE §c- §4Sexismus");
                        p.sendMessage("§4ID: §cBAN §c- §4Kurzer Timeout vom Admin");
                        p.sendMessage("§4ID: §cMUTE §c- §4Spam");
                        p.sendMessage("§4ID: §cBAN §c- §4Ban eines Admins");

                    }
                } else {
                    p.sendMessage(Main.prefix + "<Spieler> <GrundId>");
                    p.sendMessage("§4ID: §cBAN §c- §4Hacking");
                    p.sendMessage("§4ID: §cBAN §c- §4Rassismus in harter Form");
                    p.sendMessage("§4ID: §cMUTE §c- §4harte Beleidigung");
                    p.sendMessage("§4ID: §cMUTE §c- §4mehrfache Werbung");
                    p.sendMessage("§4ID: §cMUTE §c- §4Extremer Spam");
                    p.sendMessage("§4ID: §cBAN §c- §4Rangmissbrauch");
                    p.sendMessage("§4ID: §cBAN §c- §4Unangebrachter Skin/Name");
                    p.sendMessage("§4ID: §cMUTE §c- §4Provokantes Verhalten");
                    p.sendMessage("§4ID: §cBAN §c- §4Bugusing");
                    p.sendMessage("§4ID: §cBAN §c- §4Echtgeldhandel");
                    p.sendMessage("§4ID: §cMUTE §c- §4Nicken als bekannte Person");
                    p.sendMessage("§4ID: §cMUTE §c- §4Ingamebetrug");
                    p.sendMessage("§4ID: §cMUTE §c- §4veröffentlichung provater Daten");
                    p.sendMessage("§4ID: §cBAN §c- §4Duplizieren");
                    p.sendMessage("§4ID: §cMUTE §c- §4Sexismus");
                    p.sendMessage("§4ID: §cBAN §c- §4Kurzer Timeout vom Admin");
                    p.sendMessage("§4ID: §cMUTE §c- §4Spam");
                    p.sendMessage("§4ID: §cBAN §c- §4Ban eines Admins");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        } else {

            ConsoleCommandSender p = Bukkit.getConsoleSender();

            p.sendMessage(Main.prefix + "Ban-Befehl ist derzeit aus Bug-Gründen für die Console geblockt.");

        }

        return true;
    }

    public static void SetBanned(Player BannedPlayer, UUID uuid, String Name, int Laenge, String Grund, String Von, Player von) {

        @SuppressWarnings("deprecation")
        UUID UUIDP = Bukkit.getOfflinePlayer(Name).getUniqueId();

        if(BannedPlayer != null) {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Banned_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§e" + " CLMBuild " + "§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwek §7gesperrt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + mm_dd_yyyy + " §7um §c" + hour_min_sec);
                        p2.sendMessage("§8===============§7[§e" + " CLMBuild " + "§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "Du hast §e" + Name + " §7erfolgreich gebannt!");

                BannedPlayer.kickPlayer("§8[§eStrafe§8] §7Du wurdest für §4" + Ban.Banned_cfg.getString(BannedPlayer.getUniqueId() + ".Grund") + " §7bestraft." + "\n" + "§4Ende der Strafe: §7" + mm_dd_yyyy + " um " + hour_min_sec);

            } else {
                von.sendMessage(Main.prefix + "§c Der Spieler ist bereits gebannt.");
            }
        } else {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Banned_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§e" + " CLMBuild " + "§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwek §7gesperrt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + mm_dd_yyyy + " §7um §c" + hour_min_sec);
                        p2.sendMessage("§8===============§7[§e" + " CLMBuild " + "§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "Du hast " + Name + " erfolgreich gebannt!");

            } else {
                von.sendMessage(Main.prefix + "§cDer Spieler ist bereits gebannt.");
            }
        }

        try {
            Banned_cfg.save(Banned);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    public static void SetMutet(Player MutetPlayer, UUID uuid, String Name, int Laenge, String Grund, String Von, Player von) {

        @SuppressWarnings("deprecation")
        UUID UUIDP = Bukkit.getOfflinePlayer(Name).getUniqueId();

        if(MutetPlayer != null) {
            if(Mutet_cfg.getString(UUIDP + ".Laenge") == null) {

                Mutet_cfg.set(uuid + ".Name", Name);
                Mutet_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Mutet_cfg.set(uuid + ".Grund", Grund);
                Mutet_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Mutet_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.mute.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7gemutet");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Mutet_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entmutedatum: §c" + mm_dd_yyyy + " um " + mm_dd_yyyy);
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§cDu hast " + Name + " erfolgreich gemutet!");

                MutetPlayer.kickPlayer("§8[§eStrafe§8] §c Du wurdest für §4" + Ban.Mutet_cfg.getString(MutetPlayer.getUniqueId() + ".Grund") + " §7bestraft" + "\n " + "Ende der Strafe: " + mm_dd_yyyy + " um " + hour_min_sec);
            } else {
                von.sendMessage(Main.prefix + "§c Der Spieler ist bereits gemutet.");
            }
        } else {
            if(Mutet_cfg.getString(UUIDP + ".Laenge") == null) {

                Mutet_cfg.set(uuid + ".Name", Name);
                Mutet_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Mutet_cfg.set(uuid + ".Grund", Grund);
                Mutet_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Mutet_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.mute.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7gemutet");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Mutet_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entmutedatum: §c" + mm_dd_yyyy + " um " + mm_dd_yyyy);
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§c Du hast §4" + Name + " erfolgreich gemutet!");

            } else {
                von.sendMessage(Main.prefix + "§cDer Spieler ist bereits gemutet.");
            }
        }

        try {
            Mutet_cfg.save(Mutet);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    public static void SetPermaBanned(Player BannedPlayer, UUID uuid, String Name, String Grund, String Von, Player von) {


        @SuppressWarnings("deprecation")
        UUID UUIDP = Bukkit.getOfflinePlayer(Name).getUniqueId();

        if(BannedPlayer != null) {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", "PERMANENT");
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7geperma bannt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + Ban.Banned_cfg.getString(BannedPlayer.getUniqueId() + " .Laenge"));
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§cDu hast §4" + Name + " erfolgreich gebannt!");

                BannedPlayer.kickPlayer("§8[§eStrafe§8] §c Du wurdest für §4" + Ban.Mutet_cfg.getString(BannedPlayer.getUniqueId() + ".Grund") + " §7bestraft" + " \n " + "Ende der Strafe: §4§lPERMANENT");

            } else {
                von.sendMessage(Main.prefix + "§cDer Spieler ist bereits gebannt.");
            }
        } else {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", "PERMANENT");
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7geperma bannt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + Ban.Banned_cfg.getString(BannedPlayer.getUniqueId() + " .Laenge"));
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§cDu hast §4" + Name + " erfolgreich gebannt!");

            } else {
                von.sendMessage(Main.prefix + "§cDer Spieler ist bereits gebannt.");
            }
        }

        try {
            Banned_cfg.save(Banned);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    public static void SetBannedConsole(Player BannedPlayer, UUID uuid, String Name, int Laenge, String Grund, String Von, ConsoleCommandSender von) {


        @SuppressWarnings("deprecation")
        UUID UUIDP = Bukkit.getOfflinePlayer(Name).getUniqueId();

        if(BannedPlayer != null) {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Banned_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7gebannt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + mm_dd_yyyy + " um " + hour_min_sec);
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§c Du hast §4"+ Name + " erfolgreich gebannt!");

                BannedPlayer.kickPlayer("§8[§eStrafe§8] §cDu wurdest für §4 "+ Ban.Banned_cfg.getString(BannedPlayer.getUniqueId() + ".Grund") + " §7bestraft." + "\n" + "§4Ende der Strafe: §7" + mm_dd_yyyy + " um " + hour_min_sec);

            } else {
                von.sendMessage(Main.prefix + "Spieler ist bereits gebannt.");
            }
        } else {
            if(Banned_cfg.getString(UUIDP + ".Laenge") == null) {

                Banned_cfg.set(uuid + ".Name", Name);
                Banned_cfg.set(uuid + ".Laenge", System.currentTimeMillis() + Laenge*1000);
                Banned_cfg.set(uuid + ".Grund", Grund);
                Banned_cfg.set(uuid + ".Von", Von);

                Date date = new Date(Ban.Banned_cfg.getLong(UUIDP + ".Laenge"));
                String mm_dd_yyyy = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String hour_min_sec = new SimpleDateFormat("HH:mm:ss").format(date);

                for(Player p2 : Bukkit.getOnlinePlayers()) {
                    if(p2.hasPermission("system.bansystem.ban.see")) {

                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                        p2.sendMessage(Main.prefix + "§c" + Name + " §7wurde vom §cNetzwerk §7gebannt");
                        p2.sendMessage(Main.prefix + "§7Grund: §c" + Banned_cfg.getString(UUIDP + ".Grund"));
                        p2.sendMessage(Main.prefix + "§7Von: §c" + von.getName());
                        p2.sendMessage(Main.prefix + "§7Entbannungsdatum: §c" + mm_dd_yyyy + " um " + hour_min_sec);
                        p2.sendMessage("§8===============§7[§eCLMBuild§7]§8===============");
                    }
                }

                von.sendMessage(Main.prefix + "§cDu hast §4" + Name + " erfolgreich gebannt!");

            } else {
                von.sendMessage(Main.prefix + "§cDer Spieler ist bereits gebannt.");
            }
        }

        try {
            Banned_cfg.save(Banned);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

}
