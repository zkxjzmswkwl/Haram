package gay.tupac.haram;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();

        if (player.getName().equalsIgnoreCase("desert_biome")) {
            evt.setJoinMessage(ChatColor.BLACK + "Bismillah, " + ChatColor.RED + player.getName());
            // Strike lightning 5 blocks ahead of Naz whenever she joins.
            Player naz = evt.getPlayer();
            World nazWorld = naz.getWorld();
            Location nazLocation = naz.getLocation();
            nazLocation.setX(nazLocation.getX() + 5);
            nazWorld.strikeLightning(nazLocation);
        }

        if (player.getName().equalsIgnoreCase("InbredDegenerate")) {
            evt.setJoinMessage(ChatColor.GOLD + "Fame, not clout: " + player.getName());
        }

        if (player.getName().equalsIgnoreCase("byZenith")) {
            evt.setJoinMessage(ChatColor.RED + "San Francisco SHOCK byZenith!!!!!");
        }

        if (player.getName().equalsIgnoreCase("reyzr")) {
            evt.setJoinMessage(ChatColor.AQUA + "How's your mom doing, " + ChatColor.RED  + "Reyzr?");
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent evt) {
        String playerName = evt.getPlayer().getName();
        // If iCy or Naz try to eat pork, smite them.
        if (playerName.equalsIgnoreCase("desert_biome") || playerName.equalsIgnoreCase("icyicyicy1")) {
            if (evt.getItem().getType().toString().equalsIgnoreCase("cooked_porkchop")) {
                evt.getPlayer().getWorld().strikeLightning(evt.getPlayer().getLocation());
                evt.getPlayer().sendMessage(ChatColor.RED + "Haram." + ChatColor.DARK_PURPLE + "Don't tempt fate.");
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent evt) {
        Player player = evt.getPlayer();
        // Whenever Carter drops an item, enchant it with 69 Efficiency.
        if (player.getName().equalsIgnoreCase("InbredDegenerate")) {
            Item item = evt.getItemDrop();
            player.sendMessage(ChatColor.BLUE + "Yallah");
            ItemMeta itemMeta = item.getItemStack().getItemMeta();
            itemMeta.addEnchant(Enchantment.DIG_SPEED, 69, true);
            itemMeta.addEnchant(Enchantment.DURABILITY, 69, true);
            item.getItemStack().setItemMeta(itemMeta);
        }
    }
}
