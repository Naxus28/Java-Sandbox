
public class WhichRowHasMaxSum {

	public static void main(String[] args) {
		int[][] numberTable = {
			{23, 34, 45, 67},
			{98, 1, 3, 43},
			{1, 2, 67, 54}
		};
		
		int maxSumRow = 0;
		int maxSum = 0;
		int tempMaxSum = 0;
		
		for (int row = 0; row < numberTable.length; row++) {
			for (int column = 0; column < numberTable[row].length; column++) {
				
				if (row == 0) {
					maxSum += numberTable[row][column];
				} else {
					tempMaxSum += numberTable[row][column];
				}
				
				if (tempMaxSum > maxSum) {
					maxSum = tempMaxSum;
					maxSumRow = row;
				};
				
				tempMaxSum = 0; // reset tempMaxSum to start on 0 on next loop iteration 
			}
		}
		
		System.out.println("Row " + maxSumRow + " has the max sum of " + maxSum);
	}

}
