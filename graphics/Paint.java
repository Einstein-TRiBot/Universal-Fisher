package scripts.UniversalFisher.graphics;

import static scripts.UniversalFisher.data.Constants.DROP_FISH_WARNING_IMAGE;
import static scripts.UniversalFisher.data.Constants.MAIN_PAINT_IMAGE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.tribot.api2007.Login;

import scripts.UniversalFisher.data.Vars;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Paint {
	
	// Instance manipulation
	private Paint() {}
	private static final Paint PAINT = new Paint();
	public static Paint get() { return PAINT;}
	
		
	public void paint(Graphics g) {

		// Only paint if in game
		if (Login.getLoginState() != Login.STATE.INGAME)
			return;

		// Images
		g.drawImage(MAIN_PAINT_IMAGE, 0, 0, null);
		if (Vars.get().dropFish)
			g.drawImage(DROP_FISH_WARNING_IMAGE, 392, 380, null);

		// Text
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial Black", Font.PLAIN, 15));
		g.drawString(Vars.get().runningTime, 395, 367);
		g.drawString(Vars.get().profit, 385, 412);
		g.drawString(Vars.get().xp, 425, 457);
	}

}