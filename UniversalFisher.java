package scripts.UniversalFisher;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.util.ThreadSettings;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.MessageListening07;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.UniversalFisher.data.Vars;
import scripts.UniversalFisher.framework.AbstractTask;
import scripts.UniversalFisher.graphics.GUI;
import scripts.UniversalFisher.graphics.Paint;
import scripts.UniversalFisher.tasks.BankFish;
import scripts.UniversalFisher.tasks.DropFish;
import scripts.UniversalFisher.tasks.Fish;
import scripts.UniversalFisher.tasks.WalkToBank;
import scripts.UniversalFisher.tasks.WalkToFishingArea;
import scripts.UniversalFisher.tasks.WithdrawTools;
import scripts.UniversalFisher.utility.DataUtil;

/**___________________________________________________________________*/
                          @ScriptManifest                              (
		authors = "Einstein"                                           ,
		category = "Fishing"                                           ,
		name = "Universal Fisher"                                      ,
		gameMode = 1                                                   ,
		version = 1                                                    ,
		description = "Fishes (almost) anything, (almost) anywhere."   )
/**___________________________________________________________________*/

public class UniversalFisher extends Script implements Starting, Ending, Painting, MessageListening07 {
	 
	@Override
	public void onStart() {
		new GUI().setVisible(true);	
		General.useAntiBanCompliance(true);
		ThreadSettings.get().setClickingAPIUseDynamic(true);
	}
	
	@Override
	public void run() {
		
		// Wait for user to close GUI
		while (!Vars.get().variablesInitialized)
			General.sleep(100);
		
		// Initialize the Task List
		List<AbstractTask> taskList = new ArrayList<AbstractTask>();
		Collections.addAll(taskList, new Fish(), new WithdrawTools(), new WalkToBank(), new WalkToFishingArea());
		if (Vars.get().dropFish)
			taskList.add(new DropFish());
		else
			taskList.add(new BankFish());
		
		// Concurrent time tracker
		new Thread() { public void run() { while(true) { General.sleep(1000); Vars.get().runningTime = Timing.msToString(getRunningTime());}}}.start();

		// Main loop will exit as soon as it has a reason to crash the script.
		while (Vars.get().scriptCrashReason == null)
			for (AbstractTask task : taskList) {
				General.sleep(300);
				if (task.shouldExecute()) {
					if (Vars.get().printDebug)
						General.println(task.info());
					task.execute();
				}
			}
	}
	
	@Override
	public void onEnd() {
		if (Vars.get().scriptCrashReason != null)
			General.println("Script crashed: " + Vars.get().scriptCrashReason + " Nice!");
		
        General.println("                                                              ");
		General.println("______________________________________________________________");
		General.println("Thank you for running Einstein's Universal Fisher!            ");
		General.println("        Total running time: " + Vars.get().runningTime         );
		General.println("        Total profit: "       + Vars.get().profit              );
		General.println("        XP gained: "          + Vars.get().xp                  );
		General.println("        Levels gained: "      + Vars.get().levels              );
		General.println("______________________________________________________________");
	}
	
	@Override
	public void onPaint(Graphics g) {
		Paint.get().paint(g);
	}

	@Override
	public void serverMessageReceived(String string) {
		DataUtil.interpretString(string);
	}
	
	// Not in use
	public void clanMessageReceived(String arg0, String arg1) {}
	public void duelRequestReceived(String arg0, String arg1) {}
	public void personalMessageReceived(String arg0, String arg1) {}
	public void playerMessageReceived(String arg0, String arg1) {}
	public void tradeRequestReceived(String arg0) {}

}