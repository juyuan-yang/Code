/*
 * Merge Intervals - AC Rate: 420/2303 - My Submissions
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

package MergeIntervals;

import java.util.ArrayList;

import Helper.Interval;

// AC on 2nd try.. Just need to sort before...
public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) return res;
		
		quicksort(intervals, 0, intervals.size()-1);
		Interval pre = null;
		for(int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if(pre == null) pre = cur;
			else {
				if(pre.end < cur.start) {
					res.add(pre);
					pre = cur;
				} else {
					if(cur.end > pre.end) pre.end = cur.end;
				}
			}
		}
		res.add(pre);
		
		return res;
	}
	
	public void quicksort(ArrayList<Interval> list, int s, int t) {
		int i = s, j = t;
		Interval temp = list.get(s);
		
		while(i < j) {
			while(i < j && list.get(j).start > temp.start) j--;
			if(i < j) {
				list.set(i, list.get(j));
				i++;
			}
			while(i < j && list.get(i).start < temp.start) i++;
			if(i < j) {
				list.set(j, list.get(i));
				j--;
			}
		}
		list.set(i, temp);
		
		if(s < i-1) quicksort(list, s, i-1);
		if(i+1 < t) quicksort(list, i+1, t);
	}
}
