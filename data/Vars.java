package scripts.UniversalFisher.data;

import org.tribot.api2007.types.RSArea;

public class Vars {
	
	// Instance manipulation
	private Vars() {}
	private static final Vars VARS = new Vars();
	public static Vars get() { return VARS; }
	
	// Script settings
	public String scriptCrashReason = null;
	public boolean printDebug = true;
	public boolean variablesInitialized = false;
	
	// Equipment
	public boolean usingSingleTool;
	public int fishingTool;
	public int consumables;
	
	// Fishing info
	public String fishingAction;
	public int [] fishingSpotID;
	public RSArea fishingArea;
	public boolean dropFish;

	// Account info
	public long startingXP;
	public int shrimpCount;
	public int anchoviesCount;
	public int sardineCount;
	public int troutCount;
	public int salmonCount;
	public int pikeCount;
	public int lobsterCount;
	public int tunaCount;
	public int swordfishCount;
	public int mackerelCount;
	public int codCount;
	public int monkfishCount;
	public int sharkCount;
	
	// Paint
	public String runningTime = "";
	public String profit = "";
	public String xp = "";
	public int levels;
	
}