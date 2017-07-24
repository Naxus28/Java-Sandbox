import java.util.Arrays;

public class Baseballer extends Athlete {
	private String battingPosition;
	
	public Baseballer(String firstName, String lastName, int age, String battingPosition) {
		super(firstName, lastName, age);
		setBattingPosition(battingPosition);
	}
	

	public String getBattingPosition() {
		return battingPosition;
	}
	
	public void setBattingPosition(String battingPosition) {
		String [] acceptedbattingPositions = {"left", "right", "left and right", "right and left"};
		
		if (!Arrays.asList(acceptedbattingPositions).contains(battingPosition)) {
			System.out.println("Please pass one of these values to Baseballer : " + Arrays.toString(acceptedbattingPositions));
			return;
		}
		
		this.battingPosition = battingPosition;
	}
	
	// overload parent method
	public void doThis(String action) {
		System.out.println(action);
	}


	@Override
	public String toString() {
		return "Baseballer  getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", battingPosition=" + battingPosition + "]";
	}

}
