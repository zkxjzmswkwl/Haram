package gay.tupac.haram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import net.md_5.bungee.api.ChatColor;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return false;
        
        Player player = (Player)sender;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(player.getName() + ".home"));
            List<String> lines = reader.lines().toList();
            Location teleportLocation = new Location(player.getWorld(), 0, 0, 0);

            for (String line : lines) {
                if (!line.contains(":"))
                    continue;

                String[] keyValue = line.split(":");
                switch (keyValue[0].toLowerCase()) {
                    case "x" -> teleportLocation.setX(Double.parseDouble(keyValue[1]));
                    case "y" -> teleportLocation.setY(Double.parseDouble(keyValue[1]));
                    case "z" -> teleportLocation.setZ(Double.parseDouble(keyValue[1]));
                }
            }

            player.teleport(teleportLocation);
            player.sendMessage(ChatColor.DARK_AQUA + "Wallah");
        } catch (FileNotFoundException e) {
            player.sendMessage(ChatColor.RED + "You have yet to set a home.");
        }
        return true;
    }
    
}
