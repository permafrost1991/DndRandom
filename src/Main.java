import java.util.Scanner;
import java.util.Random;

/*James Hood 
// Welcome to my integration project! This is a randomly generated Dungeons & Dragons program that
will give you scenarios/encounters/chests and more to spicy up you campaign.*/
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // create scanner object
		System.out.println(
				"~~~~~~~~~~~~~~Welcome to my randomly generated dungeons and dragons scenario program!~~~~~~~~~~~~~~~~~~~~~~"); // Display
																																// Intro
																																// to
																																// my
																																// program
		System.out.println(
				"Have you ever been bored as DM? Have you ever thought to yourself,\"Hmmm I need to make this more spicy\" Well now you can! ");
		System.out.println(
				"In this program you will be able to have randomly generated scenarios that will help you to make your campaign more spicy!");
		Party party1 = new Party(); // create object for the class Party
		System.out.println("Please input you party size. (2-10 players only)"); // Prompts the user to input the
																				// partysize from the class party
		int partysize = scan.nextInt();
		while (partysize < 1 || partysize > 10) { // while loop to make sure the input of the user was within the
													// requested range
			System.out.println("\tInvalid Selection"); // Display error message if the input of the user wasn't within
														// range
			System.out.println("Please pick a number between 1-10 for you party size");
			partysize = scan.nextInt(); // Scan next Integer and set it to partysize
		}

		System.out.println("Please input your parties level. (Level: 1-20)");
		int partylevel = scan.nextInt();
		while (partylevel < 1 || partylevel > 20) {//Or condition operator 
			System.out.println("\tInvalid Selection");
			System.out.println("Please input your parties level.(Level: 1-20)");
			partylevel = scan.nextInt();
		}
		System.out.println("\n|Parties size| \t|Parties Level|");
		System.out.println("|      " + partysize + "     |\t|\t" + partylevel + "     |");
		party1.setPartyLevel(partylevel);
		party1.setPartySize(partysize);
		party1.getPartySize();
		party1.getPartyLevel();
		int choiceentry = 0;
		while (choiceentry != 4) {
			System.out.println();
			System.out.println("\t|Main Menu|");
			System.out.println("Please make a selection of the main menu");
			System.out.println("\nEnter 1- For chest/loot");
			System.out.println("Enter 2- For an encounter");
			System.out.println("Enter 3- For Random event");
			System.out.println("Enter 4- To Exit");
			choiceentry = scan.nextInt();
			if (choiceentry == 1) {
				Random rand = new Random(); // Random method
				int j = rand.nextInt(10 + 1); // set a random value for j from the range of (1-10)
				if (j <= 6) { // if statement that will only activate if j is less then or equal to 6
					System.out.println("\nYour party has found a chest! \nIt looks like there was "
							+ (chests1() * partysize) + " Gold inside of that chest!");
					// pulls the module chests1() and outputs the loot they have received from it
				}
				if (j >= 7) {
					System.out.println("\nYour party has found a chest! It looks like there was "
							+ (chests1() * partylevel) + " Gold inside of that chest!");
					System.out.println("You also find " + chests2(partylevel, partysize) + "!");
				}
			} else if (choiceentry == 2) { // if user inputs 2 then this calls wolfEncounter method
				wolfEncounter(partysize, scan);// pulls arguement partysize, scan
			} else if (choiceentry == 3) { //
			}
		}
		;
		scan.close();
	}

	public static int chests1() {
		Random rand = new Random();
		int foundGold = rand.nextInt(10) + 1;
		int pickedNum = foundGold;
		return pickedNum;
	}

	public static String chests2(int partylevel, int partysize) { // Chest2 Method with partylevel and partysize as parameters
		// created 2 String Arrays chestTier1 and chestTier2
		String[] chestTier1 = { "Healing potion (1d6 heal)", "Vial of Poison (1d6 dmg)", "Vial of oil", "Shortsword",
				"Longsword", "Misc. Junk (well that sucks)", "BattleStaff", "Scroll of Wind", "Scroll of fireball",
				"Lockpick", "Arrows x 5", "The chest is alive! (combat)" };
		String[] chestTier2 = { "Potion of greater healing (1d10)", "Vial of greater Poison (1d8 dmg)",
				"Vial of something white and murky (Potion of Instant Comfort, int/arcane check required)",
				"a blue vial (Potion of Solace int/arcane check required)", "Gold amulet" };
		Random random = new Random();
		int i = random.nextInt(10) + 1;
		if (i <= 8) {
			int index = random.nextInt(chestTier1.length);
			if (index == 11) {
				System.out.println("Big Reveal!\t This is an enchanted chest with " + ((13 * partylevel) + partysize)
						+ " health points. It has a ranged attack of (2d6 Bludgeoning) where it spits out gold.");
				System.out.println(
						"It also has a melee ranged attack (5 feet) where it clamped down on an enemy (1d12 Piercing)");
				System.out.println("");
				System.out.println(
						"If a player tried to open the chest, the chest will have a sneak attack on its first turn before combat and will add (1d6) to its first attack");
				System.out.println("");
			}
			return chestTier1[index];
		} else {
			int index = random.nextInt(chestTier2.length); // takes the length of the array chestTier2 and takes a
															// random integer
			System.out.print("Rare find!:");
			return chestTier2[index];
		}
	}

	public static void wolfEncounter(int partysize, Scanner scan) { // method wolfEncounter uses parameters partysize
																	// and Scanner scan
		System.out.println();
		System.out.println("A pack of " + (partysize) + " wolve(s) appear from the shadows!"); // takes the partysize
																								// variable and uses
																								// that to give value to
																								// the number of wolves
																								// the party encounters
		System.out.println("\n If you need the stats and abilities of the Wolf please Enter:1");// outputs the option to
																								// the user to have the
																								// stats and abilities
																								// of the wolves
																								// displayed
		int wolfInfo = scan.nextInt(); // Takes in the next input from the user and sets it equal to wolfInfo
		if (wolfInfo == 1) { // If statement that checks to see if wolfInfo is 1
			wolfStats(); // If wolfInfo is one it then calls the method wolfStats
		}
	}

	public static void wolfStats() {
		// Created a String array to hold all of the stats of a wolf
		String[] wolfStats = { "\t\t|Wolf stats| \n\t\t|AC:\t13|", "\n\t\t|CHA:\t6|", "\n\t\t|CON:\t12|",
				"\n\t\t|DEX:\t15|", "\n\t\t|HP:\t11 or (2d8+2)|", "\n\t\t|STR:\t12|", "\n\t\t|Speed:\t40|",
				"\n\t\t|WIS:\t12|" };
		// Created two Strings variables to hold the abilities of the wolves
		String wolfBite = "\n\t|Bite|\n21d20+4 + 2d4+2 piercing damage. \nIf the target is a creature, it must succeed on a DC (11) STR saving throw or be knocked prone";
		String wolfPackTact = "\t|Pack Tactics|\nThe wolf has advantage on attack rolls against a creature if at least one of the wolf's allies is within 5 feet of the creature and the ally isn't incapacitated.";
		// For loop to display all of the wolfStats array
		for (int index = 0; index < wolfStats.length; index++) { // sets the variable index to zero and then loops
																	// through till the Index is equal to the array
																	// length
			if (index > 0) {
				System.out.print(" ");
			}
			System.out.print(wolfStats[index]); // Displays each element of the array of wolfStats
		}
		System.out.println();
		System.out.println(wolfBite); // Display the String wolfBite
		System.out.println();
		System.out.println(wolfPackTact); // Display the String wolfPackTact
	}
}