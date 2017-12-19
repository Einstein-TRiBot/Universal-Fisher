package scripts.UniversalFisher.tasks;

import org.tribot.api2007.Inventory;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
/**
 * 
 * @author Einstein
 *
 *
 */
public class DropFish implements AbstractTask {

	@Override
	public String info() {
		return "Drop fish task";
	}

	@Override
	public boolean shouldExecute() {
		return Inventory.isFull();
	}

	@Override
	public void execute() {
		Inventory.dropAllExcept(Vars.get().fishingTool, Vars.get().consumables);
	}

}