package gay.tupac.haram;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Haram extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Started Haram");

        //--------------------------------------------------
        // Events
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        //--------------------------------------------------
        // Player commands
        this.getCommand("smite").setExecutor(new SmiteCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Stopped Haram");
    }


}
