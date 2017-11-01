
public class TestAthletes {

	public static void main(String[] args) {
		Baseballer Barry = new Baseballer("Barry", "Blank", 24, "let");
		Baseballer Hank = new Baseballer("Hank", "Smith", 27, "right");

	    Footballer Payton = new Footballer("Payton", "Manning", 29,"offense");
	    Footballer Terry = new Footballer("Terry", "Smith", 27,"defense");

	    HockeyPlayer  Mario = new HockeyPlayer("Mario", "Lanza", 30, "Bauer Vapor 1X");
	    HockeyPlayer Wayne = new HockeyPlayer("Wayne", "Marsola", 32, "Easton Stealth CX");

	    Golfer Tiger = new Golfer("Tiger", "Woods", 34, "Nike");
	    Golfer Phil = new Golfer("Phil", "Collins", 38, "Adidas");
	    
	    Athlete [] athletes = {Barry, Hank, Payton, Terry, Mario, Wayne, Tiger, Phil};
	    
	    for(Athlete athlete: athletes) {
	    	athlete.doThis();
	    	
	    	if (athlete instanceof Baseballer) {
	    		Baseballer b = (Baseballer)athlete;
	    		b.doThis("I swing my bat.");
	    	} else if (athlete instanceof Footballer) {
	    		Footballer f = (Footballer)athlete;
	    		f.doThis("I throw footballs.");
	    	} else if (athlete instanceof HockeyPlayer) {
	    		HockeyPlayer h = (HockeyPlayer)athlete;
	    		h.doThis("I wear heavy gear when I play.");
	    	} else {
	    		Golfer g = (Golfer)athlete;
	    		g.doThis("I have a caddie, who assists me during my matches.");
	    	}
	    	
	    	System.out.println(athlete);
	    	System.out.println("==============\n");
	    }

	}

}
