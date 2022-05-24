package Day2.MergeOverlappingSubintervals;

import java.util.ArrayList;
import java.util.Collections;
/*
Input:
Before merging intervals:
[1,3][8,10][2,6][9,9][15,18]

Merged intervals:
[1,6][8,10][15,18]

Time complexity: O(nlogn) + O(n^2)
O(nlogn): For sorting
O(n^2): Making use of nested for loop

Space complexity: O(1) (Sorting takes O(n) space).
 */
public class BruteForce {
    public static void main(String[] args) {
        ArrayList<Pair> intervals = new ArrayList<Pair>();
        intervals.add(new Pair(1,3));
        intervals.add(new Pair(8,10));
        intervals.add(new Pair(2,6));
        intervals.add(new Pair(9,9));
        intervals.add(new Pair(15,18));
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
        Collections.sort(intervals,(a,b)->(a.x-b.x));
        for(int i=0;i<n;i++){
            int start = intervals.get(i).x;
            int end = intervals.get(i).y;

            if(!res.isEmpty()){
                if(start <= res.get(res.size()-1).y){
                    continue;
                }
            }

            for(int j=i+1;j<n;j++){
                if(intervals.get(j).x <= end){
                    end = Math.max(end, intervals.get(j).y);
                }
            }
            res.add(new Pair(start, end));
        }
        return res;
    }
}

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
