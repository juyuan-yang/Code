/*
 * Insert Interval - AC Rate: 367/1853 - My Submissions
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

package InsertInterval;

import java.util.ArrayList;

import Helper.Interval;

// AC on 1st try :)
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if(newInterval == null) return intervals;
		ArrayList<Interval> res = new ArrayList<Interval>();
		if(intervals == null) res.add(newInterval);
		else {
			boolean added = false;
			for(int i = 0; i < intervals.size(); i++) {
				Interval cur = intervals.get(i);
				if(cur.end < newInterval.start) res.add(cur);
				else if(cur.start > newInterval.end){
					if(!added) {
						added = true;
						res.add(newInterval);
					}
					res.add(cur);
				} else {
					if(cur.start < newInterval.start) newInterval.start = cur.start;
					if(cur.end > newInterval.end) newInterval.end = cur.end;
				}
			}
			if(!added) res.add(newInterval);
		}
		return res;
	}
}
