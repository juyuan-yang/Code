/*
 * 3Sum - AC Rate: 1582/9405 My Submissions
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

// AC on 1st try :) Could also use Arrays.sort()
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0) return res;
//		Arrays.sort(num);
		quicksort(num, 0, num.length-1);
		for(int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while(j < k) {
				if(num[i] + num[j] + num[k] == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					res.add(list);
					while(j < k && num[k] == num[k-1]) k--;
					k--;
					while(j < k && num[j] == num[j+1]) j++;
					j++;
				} else if(num[i] + num[j] + num[k] > 0) {
					while(j < k && num[k] == num[k-1]) k--;
					k--;
				} else {
					while(j < k && num[j] == num[j+1]) j++;
					j++;
				}
			}
			while(i+1 < num.length && num[i] == num[i+1]) i++;
		}
		return res;
	}
	
	public void quicksort(int[] num, int s, int t) {
		int i = s, j = t;
		int temp = num[i];
		
		while(i < j) {
			while(i < j && num[j] > temp) j--;
			if(i < j) {
				num[i] = num[j];
				i++;
			}
			while(i < j && num[i] < temp) i++;
			if(i < j) {
				num[j] = num[i];
				j--;
			}
		}
		num[i] = temp;
		
		if(s < i-1) quicksort(num, s, i-1);
		if(i+1 < t) quicksort(num, i+1, t);
	}
}
