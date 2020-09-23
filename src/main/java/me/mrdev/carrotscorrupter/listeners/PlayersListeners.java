package me.mrdev.carrotscorrupter.listeners;


import me.mrdev.carrotscorrupter.CarrotsCorrupter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class PlayersListeners implements Listener {

    private CarrotsCorrupter plugin;

    public PlayersListeners(CarrotsCorrupter plugin) {
        plugin.getServer().getPluginManager().registerEvents(this , plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDamage(EntityDamageByEntityEvent event) {
        if(event.getEntity().getType() == EntityType.PLAYER && event.getDamager().getType() == EntityType.PLAYER) {
            //or event.getEntity() instanceof Player && event.getDamager() instanceof Player
            Player damager = (Player)event.getDamager();
            Player damaged = (Player)event.getEntity();
            ItemStack item = damager.getItemInHand();
            if(item.isSimilar(getCarrotCorrupter())) {
                for(ItemStack items : damaged.getInventory().getContents()) {
                                byte defaultData = 0;
                                if (items != null && items.getType() != Material.CARROT_ITEM) {
                                    if(items.getData().getData() != defaultData) {
                                        MaterialData data = items.getData();
                                        data.setData(defaultData);
                                        items.setData(data);
                                    }
                                    List<ItemStack> Itemslist = new ArrayList<>();
                                    Itemslist.add(items);
                                    int randomNumber = ThreadLocalRandom.current().nextInt(Itemslist.size());
                                    ItemStack randomItem = Itemslist.get(randomNumber);
                                    randomItem.setType(Material.CARROT_ITEM);
                                    break;
                                }
                    }
                }
        }
    }

    public static ItemStack getCarrotCorrupter() {
        ItemStack CC = new ItemStack(Material.CARROT_STICK);
        ItemMeta CCMeta = CC.getItemMeta();
        CCMeta.setDisplayName(ChatColor.GOLD + "Carrot " + ChatColor.GREEN + "Corrupter");
        CC.setItemMeta(CCMeta);
        return CC;
    }

}
