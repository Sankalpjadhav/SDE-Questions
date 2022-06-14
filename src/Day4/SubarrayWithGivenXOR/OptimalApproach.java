package Day4.SubarrayWithGivenXOR;

import java.util.HashMap;
import java.util.Scanner;

/*
Count number of subarrays having XOR of their elements as m

Input:
5
4 2 2 6 4
m = 6

Output:
Count of subarrays with given XOR: 4

Time complexity: O(n) : Only traversing array once.
Space complexity: O(n) : Making use of HashMap.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println("Count of subarrays with given XOR: "+getCountOfSubarraysWithGivenXOR(nums, n, m));
    }

    private static int getCountOfSubarraysWithGivenXOR(int [] nums, int n, int m){
        int countOfSubarraysWithGivenXOR = 0;
        int prefixXOR = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<n;i++){
            prefixXOR = prefixXOR ^ nums[i];
            int y = prefixXOR ^ m;

            if(map.containsKey(y)){
                countOfSubarraysWithGivenXOR += map.get(y);
            }

            if(prefixXOR == m){
                countOfSubarraysWithGivenXOR += 1;
            }

            if(map.containsKey(prefixXOR)){
                map.put(prefixXOR, map.get(prefixXOR)+1);
            }
            else{
                map.put(prefixXOR, 1);
            }
        }

        return countOfSubarraysWithGivenXOR;
    }
}
