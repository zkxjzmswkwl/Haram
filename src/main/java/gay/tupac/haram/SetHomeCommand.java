package gay.tupac.haram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import net.md_5.bungee.api.ChatColor;

public class SetHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player)sender;
        Location loc = player.getLocation();
        String locationString = String.format("x:%d\ny:%d\nz:%d\n", loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        File homeFile = new File(player.getName() + ".home");

        try {
            if (!homeFile.exists())
                homeFile.createNewFile();

            FileWriter fileWriter = new FileWriter(homeFile, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(locationString);
            writer.close();
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Home set.");
        } catch(IOException e) {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "Home not set. Tell Carter.");
        }

        return true;
    }
    
}
