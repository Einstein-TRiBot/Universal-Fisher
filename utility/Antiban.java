package scripts.UniversalFisher.utility;

import org.tribot.api.General;
import org.tribot.api.util.abc.ABCUtil;

import scripts.UniversalFisher.data.Vars;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Antiban {
	
	// Instance manipulation
	private Antiban () {}
	private static Antiban antiban = new Antiban();
	public static Antiban get() {return antiban; }
	
	// Instantiating the Anti Ban Compliance utility
	private ABCUtil abcInstance = new ABCUtil();
	
	/** Prints ABC2 actions info if the user selected 'print debug' */
	private void print(String actionInfo) {
		if (Vars.get().printDebug)
			General.println("ABC2: " + actionInfo);
	}
	
		
	// 1. Timed Actions      ________________________________________________________________________________________________________________
	/**
	 *  Checks internal timers. If a timed action is required:
	 *    - prints action info
	 *    - executes ABC2 action
	 *    - resets internal timers
	 *       
	 *  Important note: this method should only be called when the bot is idle.
	 */
	public void resolveTimedActions() {
		if (abcInstance.shouldCheckTabs()) {
			print("Checking tabs.");
			abcInstance.checkTabs();
		}
		if (abcInstance.shouldCheckXP()) {
			print("Checking xp.");
			abcInstance.checkXP();
		}
		if (abcInstance.shouldExamineEntity()) {
			print("Examining entity.");
			abcInstance.examineEntity();
		}
		if (abcInstance.shouldMoveMouse()) {
			print("Moving mouse.");
			abcInstance.moveMouse();
		}
		if (abcInstance.shouldPickupMouse()) {
			print("Picking up mouse.");
			abcInstance.pickupMouse();
		}
		if (abcInstance.shouldRightClick()) {
			print("Right clicking.");
			abcInstance.rightClick();
		}
		if (abcInstance.shouldRotateCamera()) {
			print("Rotating camera.");
			abcInstance.rotateCamera();
		}
		if (abcInstance.shouldLeaveGame()) {
			print("Leaving game.");
			abcInstance.leaveGame();
		}
	}
	
	// 2. Preferences  ___________________________________________________________________________________________________________________
	/*
	 *        All preferences are either already implemented by default or they are not applicable in this script:
	 * 
	 *  - open bank preference:     already handled by the default API methods
	 *  - tab switching preference: already handled by the default API methods
	 *  - walking preference:       already handled by the default API methods
	 *  - next target preference:   there is no next target (explained below)
	 *  
	 * 
	 */
	
	/**
	 * Explained here:
	 * 
	 * Why I think 'next target' related methods are not applicable in this script.
	 * 
	 * This is a fishing script. No real player can/will chose the next fishing spot target,
	 *  because fishing spots constantly change location, and they all look the same.
	 *      
	 *  It's not like a tree that is always going to be there and the player could just say:
	 *  "Ok, after I'm done with this tree, I will cut the other one over there."
	 *  
	 *  Therefore, I strongly believe that adding 'next target' methods is pointless and/or could potentially increase the ban-rate.
	 *  
	 *  However, I will add another script to my application that implements those methods, so I can prove my ability to use them.
	 * 
	 */

	// 3. Action conditions  ___________________________________________________________________________________________________________________
	/*
	 *        All action conditions are either already implemented by default or they are not applicable in this script:
	 * 
	 *  - HP to eat at:                        the script doesn't eat any food
	 *  - energy to activate run at:           already handled by the default API methods
	 *  - moving to anticipated location:      there is no such location, explained above
	 *  - resource switching high competition: not applicable - obvious reason; this is not how fishing works
	 *  - next target hovering :               there is no next target (explained above)
	 *  - next target menu opening:            there is no next target (explained above)
	 * 
	 */
	

	
	// 4. Reaction times  ______________________________________________________________________________________________________________________
	
	/**
	 * Generates reaction time using bit flags.
	 * 
	 * @param waitingTime - the amount of time the script was waiting for (e.g. amount of time spent cutting down a tree)
	 * @return the generated reaction time in ms
	 */
	private int generateReactionTime(int waitingTime) {
		boolean menuOpen = abcInstance.shouldOpenMenu() && abcInstance.shouldHover();
		boolean hovering = abcInstance.shouldHover();
		long menuOpenOption = menuOpen ? ABCUtil.OPTION_MENU_OPEN : 0;
		long hoverOption = hovering ? ABCUtil.OPTION_HOVERING : 0;
		
		return abcInstance.generateReactionTime(abcInstance.generateBitFlags(waitingTime, menuOpenOption, hoverOption));
	}
		
	/**
	 * Generates supporting tracking information using bit flags.
	 * This method should be called right after clicking something that will require the player to wait for a while.
	 * 
	 * @param estimatedTime for the action to complete (e.g. amount of time spent cutting down a tree)
	 */
	public void generateSupportingTrackerInfo(int estimatedTime) {
		abcInstance.generateTrackers(estimatedTime);	
	}
		
	/**
	 * Calls generate() and passes waitingTime as an argument.
	 * Sleeps for the generated amount of time.
	 * 
	 * @param waitingTime the amount of time the script was waiting for (e.g. amount of time spent cutting down a tree)
	 */
	public void generateAndSleep(int waitingTime) {
		try {
			int time = generateReactionTime(waitingTime);
			print("Sleeping for: " + ((double) (time / 1000) ) + " seconds.");
			abcInstance.sleep(time);
		} catch (InterruptedException e) {
			print("The background thread interrupted the abc sleep.");
		}
	}
	
}