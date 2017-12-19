package scripts.UniversalFisher.utility;

import static scripts.UniversalFisher.data.Constants.ANCHOVES_PRICE;
import static scripts.UniversalFisher.data.Constants.COD_PRICE;
import static scripts.UniversalFisher.data.Constants.LOBSTER_PRICE;
import static scripts.UniversalFisher.data.Constants.MACKEREL_PRICE;
import static scripts.UniversalFisher.data.Constants.MONKFISH_PRICE;
import static scripts.UniversalFisher.data.Constants.PIKE_PRICE;
import static scripts.UniversalFisher.data.Constants.SALMON_PRICE;
import static scripts.UniversalFisher.data.Constants.SARDINE_PRICE;
import static scripts.UniversalFisher.data.Constants.SHARK_PRICE;
import static scripts.UniversalFisher.data.Constants.SHRIMP_PRICE;
import static scripts.UniversalFisher.data.Constants.SWORDFISH_PRICE;
import static scripts.UniversalFisher.data.Constants.TROUT_PRICE;
import static scripts.UniversalFisher.data.Constants.TUNA_PRICE;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.tribot.api.General;
import org.tribot.api2007.Skills;

import scripts.UniversalFisher.data.Vars;
/**
 * 
 * @author Einstein
 *
 *
 */
public class DataUtil {
	
	/**
	 * Gets image from the web.
	 * 
	 * @param url of the image
	 * @return Image or null if failed.
	 */
	public static Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			General.println("Unable to load image!");
		}
		return null;
	}
	
	/**
	 * Gets the price of specified items. RSBuddy API.
	 * 
	 * @param id of item
	 * @return price of item
	 */
	public static int getPrice(int id) {
		try {
			URL url = new URL("http://api.rsbuddy.com/grandExchange?a=guidePrice&i=" + id);
			URLConnection con = url.openConnection();
			con.setUseCaches(true);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String[] data = br.readLine().replace("{", "").replace("}", "").split(",");
			return Integer.parseInt(data[0].split(":")[1]);
		} catch (Exception e) {
			General.println("Unable to load prices!");
		}
		return -1;
	}

	/**
	 * Decides what happened based on received string and updates variables accordingly.
	 * 
	 * @param string to interpret
	 */
	public static void interpretString(String string) {
		// Level
		if (string.contains("Congratulations, you've just advanced your Fishing level."))
			Vars.get().levels++;

		// Specific fish
		if (string.contains("shrimps"))   Vars.get().shrimpCount++;
		if (string.contains("anchovies")) Vars.get().anchoviesCount++;
		if (string.contains("sardine"))   Vars.get().sardineCount++;
		if (string.contains("trout"))     Vars.get().troutCount++;
		if (string.contains("salmon"))    Vars.get().salmonCount++;
		if (string.contains("pike"))      Vars.get().pikeCount++;
		if (string.contains("lobster"))   Vars.get().lobsterCount++;
		if (string.contains("tuna"))      Vars.get().tunaCount++;
		if (string.contains("swordfish")) Vars.get().swordfishCount++;
		if (string.contains("mackerel"))  Vars.get().mackerelCount++;
		if (string.contains("cod"))       Vars.get().codCount++;
		if (string.contains("monkfish"))  Vars.get().monkfishCount++;
		if (string.contains("shark"))     Vars.get().sharkCount++;

		// Any fish
		if (string.contains("You catch")) {
			updateProfit();
			updateXP();
		}
	}

	/**
	 * It calculates all fish types for two reasons:
	 *   1. Some fishing techniques will get multiple types of fish.
	 *   2. Script may support progressive fishing in the near future.
	 */
	public static void updateProfit() {
		if (Vars.get().dropFish) {
			Vars.get().profit = "Dropping";
			return;
		}
		long totalProfit = Vars.get().shrimpCount * SHRIMP_PRICE + Vars.get().anchoviesCount * ANCHOVES_PRICE
				+ Vars.get().sardineCount * SARDINE_PRICE + Vars.get().troutCount * TROUT_PRICE
				+ Vars.get().salmonCount * SALMON_PRICE + Vars.get().pikeCount * PIKE_PRICE
				+ Vars.get().lobsterCount * LOBSTER_PRICE + Vars.get().tunaCount * TUNA_PRICE
				+ Vars.get().swordfishCount * SWORDFISH_PRICE + Vars.get().mackerelCount * MACKEREL_PRICE
				+ Vars.get().codCount * COD_PRICE + Vars.get().monkfishCount * MONKFISH_PRICE
				+ Vars.get().sharkCount * SHARK_PRICE;
		Vars.get().profit = Integer.toString((int)(totalProfit / 1000)) + " k";
	}

	/**
	 * Updates xp
	 * 
	 * Called upon catching any fish
	 */
	public static void updateXP() {
		long gainedXPLong = Skills.getXP(Skills.SKILLS.FISHING) - Vars.get().startingXP;
		Vars.get().xp = Integer.toString((int) gainedXPLong / 1000) + " k";
	}

}