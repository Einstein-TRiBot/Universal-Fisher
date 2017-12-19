package scripts.UniversalFisher.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
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
public class WalkToBank implements AbstractTask {

	@Override
	public String info() {
		return "Walk to bank task";
	}

	@Override
	public boolean shouldExecute() {
		boolean hasToGetEquipment = !ScriptUtil.hasTools() && !Banking.isInBank();
		boolean hasToBankFish = !Vars.get().dropFish && Inventory.isFull() && !Banking.isInBank();
		return hasToGetEquipment || hasToBankFish;
	}

	@Override
	public void execute() {
		WebWalking.walkToBank();
	}

}