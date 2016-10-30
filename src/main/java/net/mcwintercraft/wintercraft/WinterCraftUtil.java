package net.mcwintercraft.wintercraft;

public class WinterCraftUtil {
	public static boolean isInt(final String Int) {
        try {
            Integer.parseInt(Int);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
