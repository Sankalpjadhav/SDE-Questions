package Day2.MergeOverlappingSubintervals;
import java.util.ArrayList;
import java.util.Collections;
/*
Input:
Before merging intervals:
[1,3][2,6][8,10][8,9][9,11][15,18][2,4][16,17]

Merged intervals:
[1,6][8,11][15,18]

Time complexity: O(nlogn) + O(n)
O(nlogn): For sorting
O(n): Traversing through the intervals only once

Space complexity: O(1) (Sorting takes O(n) space).
 */
public class OptimalApproach {
    public static void main(String[] args) {
        ArrayList<Pair> intervals = new ArrayList<Pair>();
        intervals.add(new Pair(1,3));
        intervals.add(new Pair(2,6));
        intervals.add(new Pair(8,10));
        intervals.add(new Pair(8,9));
        intervals.add(new Pair(9,11));
        intervals.add(new Pair(15,18));
        intervals.add(new Pair(2,4));
        intervals.add(new Pair(16,17));
        System.out.println("Before merging intervals:");
        for(Pair p:intervals){
            System.out.print("["+p.x+","+p.y+"]" );
        }
        System.out.println();
        ArrayList<Pair> res = mergeIntervals(intervals);
        System.out.println("Merged intervals:");
        for(Pair p:res){
            System.out.print("["+p.x+","+p.y+"]" );
        }
    }

    private static ArrayList<Pair> mergeIntervals(ArrayList<Pair> intervals){
        int n = intervals.size();
        ArrayList<Pair> res = new ArrayList<Pair>();
        Collections.sort(intervals, (a,b)-> a.x - b.x);
        Pair pair = new Pair(intervals.get(0).x, intervals.get(0).y);
        for(int i=0;i<n;i++){
            int start = intervals.get(i).x;
            int end = intervals.get(i).y;
            if(start<= pair.y){
                pair.y = Math.max(pair.y,end);
            }
            else{
                res.add(new Pair(pair.x, pair.y));
                pair.x = start;
                pair.y = end;
            }
        }
        res.add(pair);
        return res;
    }
}
