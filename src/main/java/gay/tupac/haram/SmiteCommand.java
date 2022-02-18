package gay.tupac.haram;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SmiteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return false;

        if (sender.getName().equalsIgnoreCase("InbredDegenerate")) {
            Player player = (Player)sender;
            Location loc = player.getLocation();
            Block targetBlock = player.getTargetBlock(120);
            player.getWorld().strikeLightning(targetBlock.getLocation());
            Bukkit.broadcastMessage(ChatColor.BLACK + "If God wills it.");
        }
        return true;
    }
}
