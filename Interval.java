/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i=0;
        while (i<intervals.size()){
            if (newInterval.end<intervals.get(i).start){ //no overlap case 1
                intervals.add(i, newInterval); //before cur
                return intervals;
            }else if (newInterval.start>intervals.get(i).end){//no overlap case 2
                i++;
            }else{ //overlap=>merge cur into new interval, guarantee still no overlaps before cur
                newInterval.start=Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end=Math.max(intervals.get(i).end, newInterval.end);
                intervals.remove(i);
            }
        }
        intervals.add(intervals.size(), newInterval); //last round if didn't return from while!
        return intervals;
    }
}
