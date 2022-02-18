package gay.tupac.haram;

import org.bukkit.Location;

public final class Helper {
    public record IntegerLocation(int x, int y, int z){};

    public static IntegerLocation convertLocation(Location location) {
        IntegerLocation ret;
        // Might not need this, Location apparently has `getBlockX-Z()` which returns int.
        return null;
    } 
    
}
