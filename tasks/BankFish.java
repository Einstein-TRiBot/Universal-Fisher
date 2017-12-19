package scripts.UniversalFisher.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
/**
 * 
 * @author Einstein
 *
 *
 */
public class BankFish implements AbstractTask {

	@Override
	public String info() {
		return "Bank fish task";
	}

	@Override
	public boolean shouldExecute() {
		return Inventory.isFull() && Banking.isInBank();
	}

	@Override
	public void execute() {
		if (!Banking.isBankScreenOpen())
			Banking.openBank();
		else
			Banking.depositAllExcept(Vars.get().fishingTool, Vars.get().consumables);
	}

}