import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class Casino2Test {
	static int playsCount = 0;
	
	// player names array
	static String [][] playerNames = {
			{"Vera", "", "Smith"}, {"John", "", "Doe"}, {"Josh", "Fargo", "Dundler"}, {"Michal", "", "Scott"}, {"Jim", "", "Halpert"},
			{"Pam", "", "Besley"}, {"Michelle", "", "Mitchel"}, {"Lina", "", "Smith"}, {"Joseph", "", "Maalouf"}, {"Toni", "", "Tornado"},
			{"Elaine", "", "Park"}, {"John", "", "Douglas"}, {"Paul", "", "Smith"},{"John", "", "Lennon"}, {"Ringo", "", "Star"}, {"George", "", "Harrison"},
			{"Adele", "", "Marcus"}, {"Vladimir", "", "Horowits"}, {"Geza", "", "Anda"}, {"Marcela", "Paula", "Ferraz"}, {"Fabi", "", "Ferraz"},{"Paulo", "Celso", "Ferraz"},
			{"Chris", "", "Ferraz"}, {"Andre", "", "Luis"}, {"Bia", "", "Ferraz"}, {"Nahyr", "", "Bolinelli"}, {"Helena", "", "D'Angelo"},
			{"Maha", "", "Matta"}, {"Sergio", "", "Ferraz"}, {"Silvio", "", "Santos"}, {"José", "", "Luis"}, {"Matha", "", "Kauffman"},
			{"Johannes", "", "Brahms"}, {"Johann", "Sebastian", "Bach"}, {"Wolfgang", "Amadeus", "Mozart"}, {"François", "", "Couperin"}, {"Frederic", "", "Chopin"}, {"Franz", "", "Lizst"},
			{"Gioachinno", "", "Rossini"}, {"Ludwig", "van", "Beethoven"}, {"Arnold", "", "Schoenberg"}, {"Alban", "", "Berg"}, {"Anton", "", "Webern"}, {"Geroge", "Friedrich", "Handel"},
			{"Michael", "", "Jordan"}, {"Scott", "", "Pippen"}, {"Tiger", "", "Woods"}, {"Pete", "", "Sampras"}, {"Rafael", "", "Nadau"}	
	};
	
	
	// players
	static Date DOB = new Date(11, 11, 1946);
	static Name vera = new Name(playerNames[0][0], playerNames[0][1], playerNames[0][2]);
	static Player veraSmith = new Player(vera, DOB, 3000);

	static Date DOB1 = new Date(1, 1, 1981);
	static Name john = new Name(playerNames[1][0], playerNames[1][1], playerNames[1][2]);
	static Player joshSmith = new Player(john, DOB1, 5000);
	
	static Date DOB2 = new Date(2, 2, 1982);
	static Name josh = new Name(playerNames[2][0], playerNames[2][1], playerNames[2][2]);
	static Player JoshDundler = new Player(josh, DOB2, 4000);
	
	static Date DOB3 = new Date(3, 3, 1983);
	static Name michal = new Name(playerNames[3][0], playerNames[3][1], playerNames[3][2]);
	static Player michalScott = new Player(michal, DOB3, 500);
	
	static Date DOB4 = new Date(4, 4, 1984);
	static Name jim = new Name(playerNames[4][0], playerNames[4][1], playerNames[4][2]);
	static Player jimHalpert = new Player(jim, DOB4, 350);
	
	static Date DOB5 = new Date(5, 5, 1985);
	static Name pam = new Name(playerNames[5][0], playerNames[5][1], playerNames[5][2]);
	static Player pamBesly = new Player(pam, DOB5, 2000);
	
	static Date DOB6 = new Date(6, 6, 1986);
	static Name michelle = new Name(playerNames[6][0], playerNames[6][1], playerNames[6][2]);
	static Player michelleMitchel= new Player(michelle, DOB6, 3000);
	
	static Date DOB7 = new Date(7, 7, 1987);
	static Name lina = new Name(playerNames[7][0], playerNames[7][1], playerNames[7][2]);
	static Player linaSmith = new Player(lina, DOB7, 1000);
	
	static Date DOB8 = new Date(8, 8, 1988);
	static Name joseph = new Name(playerNames[8][0], playerNames[8][1], playerNames[8][2]);
	static Player josephMaalouf = new Player(joseph, DOB8, 900);
	
	static Date DOB9 = new Date(9, 9, 1989);
	static Name toni = new Name(playerNames[9][0], playerNames[9][1], playerNames[9][2]);
	static Player toniTornado = new Player(toni, DOB9, 800);
	
	static Date DOB10 = new Date(10, 10, 1990);
	static Name elaine = new Name(playerNames[10][0], playerNames[10][1], playerNames[10][2]);
	static Player elainePark = new Player(elaine, DOB10, 6000);
	
	static Player [] players = { veraSmith, joshSmith,  JoshDundler, michalScott,  jimHalpert, pamBesly, michelleMitchel, linaSmith, josephMaalouf, toniTornado,  elainePark};

	// machines
	static SlotMachine lucky777 = new SlotMachine("Lucky 777", 5000, 10000, 5000, 10, 5);
	static SlotMachine luckyLotto = new SlotMachine("Lucky Lotto", 55000, 100000, 75000, 50, 25);
	static SlotMachine purplePeopleEater = new SlotMachine("Purple People Eater", 1000, 50, 40, 5, 20);
	
	static SlotMachine [] slotMachines = { lucky777, luckyLotto, purplePeopleEater};

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "This casino game will re-iterate 50 times automatically. If you want to exit the game, just hit cancel on the menu options. Good luck!");
		play();
	}
	
	
	private static void play() {
		Player player = getPlayer();
		SlotMachine machine = getMachine();
		if (player != null && machine != null) {
			Play play = new Play(player, machine);
			play.showResult();
			if (playsCount < players.length * 5){
				play();
			} else {
				JOptionPane.showMessageDialog(null, "YOU PLAYED 50 TIMES! THANK YOU AND GOODBYE.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "THANK YOU FOR PLAYING! GOODBYE");
		}
		
		
		playsCount++;
	}
	
	private static Player getPlayer() {
		 Player player = (Player) JOptionPane.showInputDialog(null, "Players", "Choose a player",
					JOptionPane.INFORMATION_MESSAGE, null,
					players, players[0]);
		 
		 return player;
	}
	
	private static SlotMachine getMachine() {
		SlotMachine machine = (SlotMachine) JOptionPane.showInputDialog(null, "Slot Machines", "Choose a machine",
					JOptionPane.INFORMATION_MESSAGE, null,
					slotMachines, slotMachines[0]);
		 
		 return machine;
	}
}
