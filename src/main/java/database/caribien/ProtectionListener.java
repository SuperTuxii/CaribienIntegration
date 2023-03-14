package database.caribien;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.Objects;

public class ProtectionListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.getPlayer().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getWhoClicked().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getEntity().getWorld().equals(Bukkit.getWorlds().get(0))) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if(event.getPlayer().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player) && !event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            event.setCancelled(true);
        }else if (!event.getCause().equals(EntityDamageEvent.DamageCause.VOID) && event.getEntity().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent event) {
        if (event.getEntity().getWorld().equals(Bukkit.getWorlds().get(0))) {
            event.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        Block block = event.getBlock();
        if(block.getType() == Material.FARMLAND) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.PHYSICAL) {
            if(Objects.requireNonNull(event.getClickedBlock()).getType() == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }
    }
}
