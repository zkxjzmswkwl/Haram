package gay.tupac.haram;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Haram extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Started Haram");
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        this.getCommand("smite").setExecutor(new SmiteCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Stopped Haram");
    }


}
