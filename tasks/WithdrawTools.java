package scripts.UniversalFisher.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
import scripts.UniversalFisher.utility.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class WithdrawTools implements AbstractTask {

	@Override
	public String info() {
		return "Withdraw tools task";
	}

	@Override
	public boolean shouldExecute() {
		return !ScriptUtil.hasTools() && Banking.isInBank();
	}

	@Override
	public void execute() {
		if(openBank()) {
			toolsFailsafe();
			if (Vars.get().usingSingleTool)
				getSingle();
			else
				getBoth();
		}
	}
	
	private boolean openBank() {
		if (!Banking.isBankScreenOpen())
			Banking.openBank();
		return Banking.isBankScreenOpen();
	}

	private void getSingle() {
		if (Inventory.getCount(Vars.get().fishingTool) < 1)
			Banking.withdraw(1, Vars.get().fishingTool);
	}

	private void getBoth() {
		if (Inventory.getCount(Vars.get().fishingTool) < 1)
			Banking.withdraw(1, Vars.get().fishingTool);
		if (Inventory.getCount(Vars.get().consumables) < 1)
			Banking.withdraw(0, Vars.get().consumables);
	}

	private void toolsFailsafe() {
		if ((Banking.find(Vars.get().fishingTool).length == 0 && Inventory.getCount(Vars.get().fishingTool) == 0)
				|| (Banking.find(Vars.get().consumables).length == 0 && Inventory.getCount(Vars.get().consumables) == 0))
			Vars.get().scriptCrashReason = "NO FISHING EQUIPMENT AVAILABLE";	
	}

}