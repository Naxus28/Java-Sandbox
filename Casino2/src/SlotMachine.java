import java.text.DecimalFormat;

public class SlotMachine {
	String machineName;
	int machineBalance;
	
	Boolean noJackPotsPaid = true;
	int jackpotPayoutOdds;
	double jackpotPayoutAmount;
	
	Boolean noRegularWinsPaid = true; 
	int regularPayoutOdds; 
	double regularPayout;
	
	// use this variable to format two decimal points for all doubles
	final static DecimalFormat df2 = new DecimalFormat("#.00"); 

	// constructor
	public SlotMachine(String machineName, int machineBalance, int jackpotPayoutOdds, double jackpotPayoutAmount, int regularPayoutOdds, double regularPayout) {
		setMachineName(machineName);
		setMachineBalance(machineBalance);
		
		setJackpotPayoutOdds(jackpotPayoutOdds);
		setJackpotPayoutAmount(jackpotPayoutAmount);
		
		setRegularPayoutOdds(regularPayoutOdds);
		setRegularPayout(regularPayout);
	}
	

	@Override
	public String toString() {
		/*return "SlotMachine [machineName=" + machineName + ", machineBalance=$" + machineBalance + ", noJackPotsPaid="
				+ noJackPotsPaid + ", jackpotPayoutOdds=1/" + jackpotPayoutOdds + ", jackpotPayoutAmount=$"
				+ df2.format(jackpotPayoutAmount) + ", noRegularWinsPaid=" + noRegularWinsPaid + ", regularPayoutOdds=1/"
				+ regularPayoutOdds + ", regularPayout=$" + df2.format(regularPayout) + "]";*/
		return machineName;
				
	}
	

	public Boolean isRegularWin() {
		return machineBalance % regularPayoutOdds == 0;
	}
	
	public Boolean isJackpot() {
		return machineBalance % jackpotPayoutOdds == 0;
	}

	// getters and setters
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	
	public int getMachineBalance() {
		return machineBalance;
	}
	public void setMachineBalance(int machineBalance) {
		this.machineBalance = machineBalance;
	}
	
	public Boolean getNoJackPotsPaid() {
		return noJackPotsPaid;
	}
	public void setNoJackPotsPaid(Boolean noJackPotsPaid) {
		this.noJackPotsPaid = noJackPotsPaid;
	}
	
	public Boolean getNoRegularWinsPaid() {
		return noRegularWinsPaid;
	}
	public void setNoRegularWinsPaid(Boolean noRegularWinsPaid) {
		this.noRegularWinsPaid = noRegularWinsPaid;
	}
	
	public int getJackpotPayoutOdds() {
		return jackpotPayoutOdds;
	}
	public void setJackpotPayoutOdds(int jackpotPayoutOdds) {
		this.jackpotPayoutOdds = jackpotPayoutOdds;
	}
	
	public String getJackpotPayoutAmount() {
		return df2.format(jackpotPayoutAmount);
	}
	public void setJackpotPayoutAmount(double jackpotPayoutAmount) {
		this.jackpotPayoutAmount = jackpotPayoutAmount;
	}
	
	public int getRegularPayoutOdds() {
		return regularPayoutOdds;
	}
	public void setRegularPayoutOdds(int regularPayoutOdds) {
		this.regularPayoutOdds = regularPayoutOdds;
	}

	public String getRegularPayout() {
		return df2.format(regularPayout);
	}
	public void setRegularPayout(double regularPayout) {
		this.regularPayout = regularPayout;
	}
	
}
