package scripts.UniversalFisher.data;

import java.awt.Image;

import scripts.UniversalFisher.utility.DataUtil;

public interface Constants {
	
	// Fishing equipment
	int SMALL_FISHING_NET = 303;
	int FISHING_ROD = 307;
	int FISHING_BAIT = 313;
	int FLY_FISHING_ROD = 309;
	int FEATHER = 314;
	int BIG_FISHING_NET = 305;
	int LOBSTER_POT = 301;
	int HARPOON = 311;

	// Fishing actions
	String NET_ACTION = "Net";
	String BAIT_ACTION = "Bait";
	String LURE_ACTION = "Lure";
	String CAGE_ACTION = "Cage";
	String HARPOON_ACTION = "Harpoon";
	String USE_ROD_ACTION = "Use-rod";

	// Fishing spot IDs
	int [] NET_BAIT_FISHING_SPOT = { 1544, 1525, 1530, 1521, 1518, 1517 };
	int [] NET_HARPOON_FISHING_SPOT = { 1520 };
	int [] LURE_BAIT_FISHING_SPOT = { 1526 , 1527, 1507 , 1508, 1506, 1513, 1516};
	int [] CAGE_HARPOON_FISHING_SPOT = { 1522, 1519, 2146};
	int [] LEAPING_FISHING_SPOT = {1542};

	// Raw fish
	int RAW_SHRIMP = 317;
	int RAW_ANCHOVES = 321;
	int RAW_SARDINE = 327;
	int RAW_TROUT = 335;
	int RAW_SALMON = 331;
	int RAW_PIKE = 349;
	int RAW_LOBSTER = 377;
	int RAW_TUNA = 359;
	int RAW_SWORDFISH = 371;
	int RAW_LEAPING_TROUT = 11328;
	int RAW_LEAPING_SALMON = 11330;
	int RAW_LEAPING_STURGEON = 11332;
	int RAW_MACKEREL = 353;
	int RAW_COD = 341;
	int RAW_MONKFISH = 7944;
	int RAW_SHARK = 383;

	// Prices
	int SHRIMP_PRICE = DataUtil.getPrice(RAW_SHRIMP);
	int ANCHOVES_PRICE = DataUtil.getPrice(RAW_ANCHOVES);
	int SARDINE_PRICE = DataUtil.getPrice(RAW_SARDINE);
	int TROUT_PRICE = DataUtil.getPrice(RAW_TROUT);
	int SALMON_PRICE = DataUtil.getPrice(RAW_SALMON);
	int PIKE_PRICE = DataUtil.getPrice(RAW_PIKE);
	int LOBSTER_PRICE = DataUtil.getPrice(RAW_PIKE);
	int TUNA_PRICE = DataUtil.getPrice(RAW_TUNA);
	int SWORDFISH_PRICE = DataUtil.getPrice(RAW_SWORDFISH);
	int LEAPING_TROUT_PRICE = DataUtil.getPrice(RAW_LEAPING_TROUT);
	int LEAPING_SALMON_PRICE = DataUtil.getPrice(RAW_LEAPING_SALMON);
	int LEAPING_STURGEON_PRICE = DataUtil.getPrice(RAW_LEAPING_STURGEON);
	int MACKEREL_PRICE = DataUtil.getPrice(RAW_MACKEREL);
	int COD_PRICE = DataUtil.getPrice(RAW_COD);
	int MONKFISH_PRICE = DataUtil.getPrice(RAW_MONKFISH);
	int SHARK_PRICE = DataUtil.getPrice(RAW_SHARK);
	
	// Paint images
	Image MAIN_PAINT_IMAGE = DataUtil.getImage("https://i.imgur.com/618cA6H.png");
	Image DROP_FISH_WARNING_IMAGE = DataUtil.getImage("https://i.imgur.com/umLCqO9.png");
	
}