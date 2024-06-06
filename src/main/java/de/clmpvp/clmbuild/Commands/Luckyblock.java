package de.clmpvp.clmbuild.Commands;

import de.clmpvp.clmbuild.Main.ItemBuilder;
import de.clmpvp.clmbuild.Main.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("deprecation")
public class Luckyblock implements CommandExecutor {

    public static ArrayList<Player> FakeDias = new ArrayList<>();
    public static ArrayList<Player> byeInv = new ArrayList<>();

    private static Main plugin;

    @SuppressWarnings("static-access")
    public Luckyblock(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("luckyblock").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("clmbuild.luckyblock.give")) {
                p.getInventory().addItem(ItemBuilder.createItem(Material.SPONGE, "§6§lNoFall Perk", Integer.valueOf(1), new String[] { "GhostAdmin"}));
            } else {
                p.sendMessage(Main.noperm);
            }
        } else {
            sender.sendMessage(Main.noperm);
        }

        return false;
    }
    public static void onLuckyblockEvents(Player p, Block b) {

        World w = b.getWorld();
        Random r = new Random();
        int zufall = r.nextInt(18);
        switch (zufall) {
            case 0:

                ItemStack i1 = new ItemStack(Material.STICK);
                ItemMeta im1 = i1.getItemMeta();
                im1.setDisplayName("§c§lOP-Stock");
                im1.addEnchant(Enchantment.KNOCKBACK, 10, true);
                i1.setItemMeta(im1);

                p.getWorld().dropItemNaturally(b.getLocation(), i1);
                break;

            case 1:

                Pig pig = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);
                Pig pig1 = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);
                Pig pig2 = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);
                Pig pig3 = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);
                Pig pig4 = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);
                Pig pig5 = (Pig) p.getWorld().spawnCreature(b.getLocation(), CreatureType.PIG);

                pig.setPassenger(pig1);
                pig1.setPassenger(pig2);
                pig2.setPassenger(pig3);
                pig3.setPassenger(pig4);
                pig4.setPassenger(pig5);
                break;

            case 2:

                ItemStack i2 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta im2 = i2.getItemMeta();
                im2.setDisplayName("§bDIASWORD");
                im2.addEnchant(Enchantment.SILK_TOUCH, 5, true);
                im2.addEnchant(Enchantment.KNOCKBACK, 5, true);
                im2.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
                im2.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
                i2.setItemMeta(im2);

                p.getWorld().dropItemNaturally(b.getLocation(), i2);

                break;
            case 3:

                ItemStack i3 = new ItemStack(Material.DIAMOND, 8);
                ItemMeta im3 = i3.getItemMeta();
                im3.setDisplayName("§bFAKE-DIAMOND");
                i3.setItemMeta(im3);

                w.dropItemNaturally(b.getLocation(), i3);

                FakeDias.add(p);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        for(Entity e : w.getEntities()) {
                            if(e instanceof Item) {
                                if(e.getLocation().distance(b.getLocation()) < 3) {
                                    e.remove();
                                }
                            }
                        }

                        FakeDias.remove(p);

                    }
                }, 20*10);

                break;
            case 4:

                TNTPrimed tnt = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt.setFuseTicks(60);

                TNTPrimed tnt2 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt2.setFuseTicks(60);

                TNTPrimed tnt3 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt3.setFuseTicks(60);

                TNTPrimed tnt4 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt4.setFuseTicks(60);

                TNTPrimed tnt5 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt5.setFuseTicks(60);

                TNTPrimed tnt6 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt6.setFuseTicks(60);

                TNTPrimed tnt7 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt7.setFuseTicks(60);

                TNTPrimed tnt8 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt8.setFuseTicks(60);

                TNTPrimed tnt9 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt9.setFuseTicks(60);

                TNTPrimed tnt10 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                tnt10.setFuseTicks(60);

                break;
            case 5:

                Firework firework = b.getWorld().spawn(b.getLocation().add(1, 0, 0), Firework.class);
                Firework firework2 = b.getWorld().spawn(b.getLocation().add(-1, 0, 0), Firework.class);
                Firework firework3 = b.getWorld().spawn(b.getLocation().add(0, 0, 1), Firework.class);
                Firework firework4 = b.getWorld().spawn(b.getLocation().add(0, 0, -1), Firework.class);

                FireworkEffect effect4 = FireworkEffect.builder()
                        .withColor(Color.GREEN)
                        .flicker(true)
                        .trail(true)
                        .withFade(Color.RED)
                        .with(FireworkEffect.Type.BALL_LARGE)
                        .build();

                FireworkMeta meta4= firework4.getFireworkMeta();
                meta4.addEffect(effect4);
                meta4.setPower(1);

                firework.setFireworkMeta(meta4);
                firework2.setFireworkMeta(meta4);
                firework3.setFireworkMeta(meta4);
                firework4.setFireworkMeta(meta4);

                ItemStack i4 = new ItemStack(Material.DIAMOND);

                b.getWorld().dropItemNaturally(b.getLocation().add(1, 0, 0), i4);
                b.getWorld().dropItemNaturally(b.getLocation().add(-1, 0, 0), i4);
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 1), i4);
                b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, -1), i4);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        Firework firework = b.getWorld().spawn(b.getLocation().add(1, 0, 0), Firework.class);
                        Firework firework2 = b.getWorld().spawn(b.getLocation().add(-1, 0, 0), Firework.class);
                        Firework firework3 = b.getWorld().spawn(b.getLocation().add(0, 0, 1), Firework.class);
                        Firework firework4 = b.getWorld().spawn(b.getLocation().add(0, 0, -1), Firework.class);

                        FireworkEffect effect4 = FireworkEffect.builder()
                                .withColor(Color.GREEN)
                                .flicker(true)
                                .trail(true)
                                .withFade(Color.RED)
                                .with(FireworkEffect.Type.BALL_LARGE)
                                .build();

                        FireworkMeta meta4= firework4.getFireworkMeta();
                        meta4.addEffect(effect4);
                        meta4.setPower(1);

                        firework.setFireworkMeta(meta4);
                        firework2.setFireworkMeta(meta4);
                        firework3.setFireworkMeta(meta4);
                        firework4.setFireworkMeta(meta4);

                        ItemStack i4 = new ItemStack(Material.DIAMOND);

                        b.getWorld().dropItemNaturally(b.getLocation().add(1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(-1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 1), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, -1), i4);

                    }
                }, 10);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        Firework firework = b.getWorld().spawn(b.getLocation().add(1, 0, 0), Firework.class);
                        Firework firework2 = b.getWorld().spawn(b.getLocation().add(-1, 0, 0), Firework.class);
                        Firework firework3 = b.getWorld().spawn(b.getLocation().add(0, 0, 1), Firework.class);
                        Firework firework4 = b.getWorld().spawn(b.getLocation().add(0, 0, -1), Firework.class);

                        FireworkEffect effect4 = FireworkEffect.builder()
                                .withColor(Color.GREEN)
                                .flicker(true)
                                .trail(true)
                                .withFade(Color.RED)
                                .with(FireworkEffect.Type.BALL_LARGE)
                                .build();

                        FireworkMeta meta4= firework4.getFireworkMeta();
                        meta4.addEffect(effect4);
                        meta4.setPower(1);

                        firework.setFireworkMeta(meta4);
                        firework2.setFireworkMeta(meta4);
                        firework3.setFireworkMeta(meta4);
                        firework4.setFireworkMeta(meta4);

                        ItemStack i4 = new ItemStack(Material.DIAMOND);

                        b.getWorld().dropItemNaturally(b.getLocation().add(1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(-1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 1), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, -1), i4);

                    }
                }, 20);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        Firework firework = b.getWorld().spawn(b.getLocation().add(1, 0, 0), Firework.class);
                        Firework firework2 = b.getWorld().spawn(b.getLocation().add(-1, 0, 0), Firework.class);
                        Firework firework3 = b.getWorld().spawn(b.getLocation().add(0, 0, 1), Firework.class);
                        Firework firework4 = b.getWorld().spawn(b.getLocation().add(0, 0, -1), Firework.class);

                        FireworkEffect effect4 = FireworkEffect.builder()
                                .withColor(Color.GREEN)
                                .flicker(true)
                                .trail(true)
                                .withFade(Color.RED)
                                .with(FireworkEffect.Type.BALL_LARGE)
                                .build();

                        FireworkMeta meta4= firework4.getFireworkMeta();
                        meta4.addEffect(effect4);
                        meta4.setPower(1);

                        firework.setFireworkMeta(meta4);
                        firework2.setFireworkMeta(meta4);
                        firework3.setFireworkMeta(meta4);
                        firework4.setFireworkMeta(meta4);

                        ItemStack i4 = new ItemStack(Material.DIAMOND);

                        b.getWorld().dropItemNaturally(b.getLocation().add(1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(-1, 0, 0), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, 1), i4);
                        b.getWorld().dropItemNaturally(b.getLocation().add(0, 0, -1), i4);

                    }
                }, 30);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        TNTPrimed tnt = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                        tnt.setFuseTicks(60);

                        TNTPrimed tnt2 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                        tnt2.setFuseTicks(60);

                        TNTPrimed tnt3 = (TNTPrimed) w.spawnEntity(b.getLocation (), EntityType.PRIMED_TNT);
                        tnt3.setFuseTicks(60);

                        p.sendMessage("C:");

                    }
                }, 20*5);

                break;
            case 6:

                org.bukkit.util.Vector v = p.getLocation().getDirection().setY(2.5D);
                p.setVelocity(v);

                break;
            case 7:

                Integer i = 0;

                while (i < 21) {
                    Bat bat = (Bat) p.getWorld().spawnEntity(b.getLocation(), EntityType.BAT);
                    ThrownExpBottle xp = (ThrownExpBottle) p.getWorld().spawnEntity(b.getLocation(), EntityType.THROWN_EXP_BOTTLE);
                    bat.setPassenger(xp);
                    i++;
                }

                break;
            case 8:

                Integer i5 = 0;

                while (i5 < 270) {
                    i5++;
                    //Mite
                    Location pl = p.getLocation();
                    pl.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    //Unten
                    Location pl1 = p.getLocation().subtract(0, 0, 1);
                    pl1.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    //Oben
                    Location pl2 = p.getLocation().subtract(0, 0, -1);
                    pl2.subtract(0, i5, 0).getBlock().setType(Material.AIR);


                    Location pl3 = p.getLocation().subtract(1, 0, 0);
                    pl3.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    Location pl4 = p.getLocation().subtract(-1, 0, 0);
                    pl4.subtract(0, i5, 0).getBlock().setType(Material.AIR);


                    Location pl5 = p.getLocation().subtract(1, 0, 1);
                    pl5.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    Location pl6 = p.getLocation().subtract(-1, 0, -1);
                    pl6.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    Location pl7 = p.getLocation().subtract(-1, 0, 1);
                    pl7.subtract(0, i5, 0).getBlock().setType(Material.AIR);

                    Location pl8 = p.getLocation().subtract(1, 0, -1);
                    pl8.subtract(0, i5, 0).getBlock().setType(Material.AIR);
                }

                break;
            case 9:

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 10);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 20);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 30);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 40);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 50);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 60);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 70);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 80);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 90);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 100);
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 110);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 120);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 130);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 140);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 150);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 160);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 170);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 180);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 160);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        p.getLocation().getBlock().setType(Material.BEDROCK);

                    }
                }, 200);

                break;
            case 10:

                p.getLocation().getBlock().setType(Material.BEACON);

                p.sendMessage("wo kommt der jetzt her?!");

                break;
            case 11:

                p.getWorld().spawnEntity(b.getLocation(), EntityType.WITHER);

                p.sendMessage("Spamit deinem neuen Haustier! C:");

                break;
            case 12:

                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*60*10, 9));
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*60*10, 9));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*60*10, 9));
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*60*10, 9));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20*60*10, 9));
                p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*60*10, 9));

                p.sendMessage(Main.prefix + "Schmecken die Tränke überhaupt?");

                break;
            case 13:

                for (ItemStack in : p.getInventory().getContents()) {
                    if (in != null) {
                        p.getWorld().dropItemNaturally(p.getLocation(), in);
                        p.getInventory().remove(in);
                    }
                }

                for (ItemStack in : p.getInventory().getArmorContents()) {
                    if (in.getType() != Material.AIR) {
                        p.getWorld().dropItemNaturally(p.getLocation(), in);
                    }
                }

                ItemStack ii = new ItemStack(Material.AIR);

                p.getInventory().setHelmet(ii);
                p.getInventory().setChestplate(ii);
                p.getInventory().setLeggings(ii);
                p.getInventory().setBoots(ii);

                Luckyblock.byeInv.add(p);

                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

                    @Override
                    public void run() {

                        Luckyblock.byeInv.remove(p);

                    }
                }, 20*30);

                break;
            case 14:

                ItemStack istack1 = new ItemStack(Material.COOKED_BEEF);
                ItemMeta istackMeta1 = istack1.getItemMeta();
                istackMeta1.setDisplayName("Schinken");
                ArrayList<String> Lore = new ArrayList<>();
                Lore.add("Schinken");
                istackMeta1.setLore(Lore);
                istackMeta1.addEnchant(Enchantment.DAMAGE_ALL, 1000000, true);
                istackMeta1.addEnchant(Enchantment.FIRE_ASPECT, 1000000, true);
                istack1.setItemMeta(istackMeta1);

                p.getWorld().dropItemNaturally(b.getLocation(), istack1);

                break;
            case 15:

                ItemStack istack = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta istackMeta = istack.getItemMeta();
                istackMeta.spigot().setUnbreakable(true);
                istackMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                istack.setItemMeta(istackMeta);

                ItemStack istack3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta istackMeta3 = istack3.getItemMeta();
                istackMeta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                istack3.setItemMeta(istackMeta3);

                ItemStack istack4 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta istackMeta4 = istack4.getItemMeta();
                istackMeta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                istack4.setItemMeta(istackMeta4);

                ItemStack istack5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta istackMeta5 = istack5.getItemMeta();
                istackMeta5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                istack5.setItemMeta(istackMeta5);

                ItemStack istack6 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta istackMeta6 = istack6.getItemMeta();
                istackMeta6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                istack6.setItemMeta(istackMeta6);

                Zombie zom = (Zombie) p.getWorld().spawnCreature(b.getLocation(), CreatureType.ZOMBIE);
                zom.setMaxHealth(200);
                zom.setHealth(200);
                zom.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 1));
                zom.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 2));
                zom.getEquipment().setHelmet(istack3);
                zom.getEquipment().setChestplate(istack4);
                zom.getEquipment().setLeggings(istack5);
                zom.getEquipment().setBoots(istack6);
                zom.getEquipment().setItemInHand(istack);
                zom.getEquipment().setItemInHandDropChance(100);
                zom.getEquipment().setBootsDropChance(0);
                zom.getEquipment().setLeggingsDropChance(0);
                zom.getEquipment().setChestplateDropChance(0);
                zom.getEquipment().setHelmetDropChance(0);

                zom.setCustomName("§cBöser Zombie");

                break;
            case 16:

                ItemStack istack7 = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta istackMeta7 = istack7.getItemMeta();
                istackMeta7.setDisplayName("Spitzhacke");
                istackMeta7.addEnchant(Enchantment.DIG_SPEED, 5, true);
                istackMeta7.addEnchant(Enchantment.SILK_TOUCH, 5, true);
                istackMeta7.addEnchant(Enchantment.DURABILITY, 5, true);
                istack7.setItemMeta(istackMeta7);

                ItemStack istack2 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta istackMeta2 = istack2.getItemMeta();
                istackMeta2.setDisplayName("Axt");
                istackMeta2.addEnchant(Enchantment.DIG_SPEED, 5, true);
                istackMeta2.addEnchant(Enchantment.SILK_TOUCH, 5, true);
                istackMeta2.addEnchant(Enchantment.DURABILITY, 5, true);
                istack2.setItemMeta(istackMeta2);

                p.getWorld().dropItemNaturally(b.getLocation(), istack7);
                p.getWorld().dropItemNaturally(b.getLocation(), istack2);

                p.sendMessage("Weihnachtsmann kam aber früh");

                break;
            case 17:

                Creeper creep = (Creeper) p.getWorld().spawnCreature(b.getLocation(), CreatureType.CREEPER);

                creep.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 1));

                Creeper creep2 = (Creeper) p.getWorld().spawnCreature(b.getLocation(), CreatureType.CREEPER);

                creep2.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 1));

                p.getWorld().spawnEntity(b.getLocation(), EntityType.LIGHTNING);

                break;
        }
            }
    }
