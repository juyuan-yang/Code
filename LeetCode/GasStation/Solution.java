/*
 * Gas Station - AC Rate: 79/413 - My Submissions
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */

/*
 * The straight forward solution is to use DP, f(i, j) to say whether I can go from i to j
 * 
 * Another greedy solution come to my mind is, first calculate gas-cost array,
 * then calculate the sum from end to start, note the max sum, and try start from here
 * 
 */
package GasStation;

// AC on 2nd try :) 1st try failed just because of typo...
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || gas.length == 0 || cost == null || gas.length != cost.length) 
			return -1;
		
		int max = gas[gas.length-1] - cost[gas.length-1], maxIndex = gas.length-1, sum, i;
		sum = max;
		for(i = gas.length-2; i >= 0; i--) {
			sum += gas[i] - cost[i];
			if(sum > max) {
				max = sum;
				maxIndex = i;
			}
		}
		
		i = maxIndex;
		sum = 0;
		do{
			sum += gas[i] - cost[i];
			if(sum < 0) return -1;
			i++;
			if(i == gas.length) i = 0;
		} while(i != maxIndex);
		
		return maxIndex;
	}
}
