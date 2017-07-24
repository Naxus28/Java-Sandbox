
public class Play {
	Player player;
	SlotMachine slotMachine;
	
	public Play(Player player, SlotMachine slotMachine) {
		setPlayer(player);
		setSlotMachine(slotMachine);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public SlotMachine getSlotMachine() {
		return slotMachine;
	}

	public void setSlotMachine(SlotMachine slotMachine) {
		this.slotMachine = slotMachine;
	}
	
	public void showResult() {
		// player
		Name playerName = player.getName();
		String initialBalance = player.getMoneyBalance();
		player.setMoneyBalance(Double.parseDouble(player.getMoneyBalance()) - 1);
		String balanceAfterPlay = player.getMoneyBalance();
		
		System.out.println(playerName + ", your amount before this play was $" +  initialBalance + "\n");
		
		// machine
		slotMachine.setMachineBalance(slotMachine.getMachineBalance() + 1);
		
		if (slotMachine.isRegularWin()) {
			player.setMoneyBalance(Double.parseDouble(balanceAfterPlay) + Double.parseDouble(slotMachine.getRegularPayout()));
			slotMachine.setNoRegularWinsPaid(false);
			System.out.println("***YOU WON A REGULAR PRIZE OF $" + slotMachine.getRegularPayout() + " ***\n");
		}
		
		if (slotMachine.isJackpot()) {
			player.setMoneyBalance(Double.parseDouble(balanceAfterPlay) + Double.parseDouble(slotMachine.getJackpotPayoutAmount()));
			slotMachine.setNoJackPotsPaid(false);
			System.out.println("*****JACKPOT! YOU WON A PRIZE OF $" + slotMachine.getJackpotPayoutAmount() + " *****\n");
		}
		
		System.out.println("Your current amount is $" + player.getMoneyBalance() + "\n");
		
		System.out.println("====================\n");
		
	}

	@Override
	public String toString() {		
		return "Play [player=" + player + ", slotMachine=" + slotMachine + "]";
	}
	
}
