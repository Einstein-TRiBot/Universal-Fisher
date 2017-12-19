package scripts.UniversalFisher.utility;

import org.tribot.api2007.Inventory;

import scripts.UniversalFisher.data.Vars;
/**
 * 
 * @author Einstein
 *
 *
 */
public class ScriptUtil {
	
	/**
	 * @return true if has all the required tools, false otherwise
	 */
	public static boolean hasTools() {
		if(Vars.get().usingSingleTool)
			return Inventory.getCount(Vars.get().fishingTool) > 0;
		return Inventory.getCount(Vars.get().fishingTool) > 0 && Inventory.getCount(Vars.get().consumables) > 0;
	}
	
}