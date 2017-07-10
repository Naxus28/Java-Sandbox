import java.text.DecimalFormat;

public class Player {
	private Name name;
	private Date DOB;
	private double moneyBalance;
	final static DecimalFormat df = new DecimalFormat("#.00"); // use this variable to format two decimal points for all doubles

	// constructor
	public Player(Name name, Date birthday, double moneyBalance) {
		setName(name);
		setDOB(birthday);
		setMoneyBalance(moneyBalance);
	}
	
	// to string
	@Override
	public String toString() {
		return "Player [name=" + getName() + ", DOB=" + getDOB() + ", moneyBalance=" + getMoneyBalance() + "]";
	}
	
	// getters and setters
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	
	public String getMoneyBalance() {
		return df.format(moneyBalance);
	}

	public void setMoneyBalance(double moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

}
