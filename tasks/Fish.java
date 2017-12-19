package scripts.UniversalFisher.tasks;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSNPC;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
import scripts.UniversalFisher.utility.Antiban;
import scripts.UniversalFisher.utility.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Fish implements AbstractTask {
	
	// Fishing statistics; used in ABC2
	private long startedFishingTimestamp;
	private long lastFishingWaitTime;
	private long averageFishingWaitTime;
	private long totalFishingWaitTime;
	private long totalFishingInstances;

	/**
	 * Updates the variables used in ABC2
	 * 
	 * Prints them to the console if the user selected 'print debug'
	 */
	private void updateFishingStatistics() {
		lastFishingWaitTime = System.currentTimeMillis() - startedFishingTimestamp;
		totalFishingInstances++;
		totalFishingWaitTime+=lastFishingWaitTime;
		averageFishingWaitTime = totalFishingWaitTime / totalFishingInstances;

		if(!Vars.get().printDebug) return;
		General.println("Player stopped fishing!___________________________________________________");
		General.println("Last fishing wait time: "    + lastFishingWaitTime    / 1000 + " seconds");
		General.println("Total fishing instances: "   + totalFishingInstances                     );
		General.println("Total fishing wait time: "   + totalFishingWaitTime   / 1000 + " seconds");
		General.println("Average fishing wait time: " + averageFishingWaitTime / 1000 + " seconds");
	}
	
	@Override
	public String info() {
		return "Fish task";
	}

	@Override
	public boolean shouldExecute() {
		return !Inventory.isFull() && ScriptUtil.hasTools() && Vars.get().fishingArea.contains(Player.getPosition());
	}

	@Override
	public void execute() {
		
		// If the player is fishing
		if (Player.getAnimation() != -1) {
			
			startedFishingTimestamp = System.currentTimeMillis();
			
			// While the player is fishing
			while (Player.getAnimation() != -1) {
				// Do the following:
				General.sleep(300);
				Antiban.get().resolveTimedActions();
			}
			
			// The player has just stopped fishing. Do the following:
			updateFishingStatistics();
			Antiban.get().generateAndSleep((int)lastFishingWaitTime);
		} // end IF fishing

		// Else if the player is not busy fishing:
		
		// If bot successfully clicked a fishing spot:
		if (findAndClickFishingSpot()) {
			//Do the following:
			Antiban.get().generateSupportingTrackerInfo((int)averageFishingWaitTime);
			waitToStartAnimating();
		}
	}
	
	private boolean findAndClickFishingSpot() {
		
		RSNPC [] fishingSpot = NPCs.findNearest(Vars.get().fishingSpotID);
		
		// If no fishing spot found
		if (fishingSpot.length == 0) {
			// Do the following:
			General.println("No fishing spot found");
			if (!Player.isMoving())
				Antiban.get().resolveTimedActions(); 
			return false;
		}

		// If fishing spot is not on screen: move closer, rotate camera
		if (!fishingSpot[0].isOnScreen()) {
			General.println("Fishing spot not on screen");
			Walking.blindWalkTo(fishingSpot[0].getPosition());
			Camera.turnToTile(fishingSpot[0].getPosition());
		}
		// If successfully clicked fishing spot: return true
		if (Clicking.click(Vars.get().fishingAction, fishingSpot[0]))
			return true;
		
		return false;
	}

	private void waitToStartAnimating() {	
		// Wait to stop walking
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				General.sleep(300);
				return !Player.isMoving();
			}
		}, General.random(4000, 6000));
		
		//Wait to start animating
		Timing.waitCondition(new Condition() {
			@Override
			public boolean active() {
				General.sleep(300);
				return Player.getAnimation() != -1;
			}
		}, General.random(2000, 4000));
	}

}