package scripts.UniversalFisher.tasks;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
import scripts.UniversalFisher.utility.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class WalkToFishingArea implements AbstractTask {

	@Override
	public String info() {
		return "Walk to fish area task";
	}

	@Override
	public boolean shouldExecute() {
		return !Inventory.isFull() && ScriptUtil.hasTools() && !Vars.get().fishingArea.contains(Player.getPosition());
	}

	@Override
	public void execute() {
		WebWalking.walkTo(Vars.get().fishingArea.getRandomTile());
	}
	
}