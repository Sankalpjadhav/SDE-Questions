package Day7.ThreeSum;

import java.util.*;
/*
Input:
Enter number of elements:
6
Enter array elements:
-1 0 1 2 -1 -4

Output:
Triplets with sum equal to 0:
[[-1, 2, -1], [0, 1, -1], [-1, 0, 1]]

Input:
Enter number of elements:
3
Enter array elements:
-1 0 1

Output:
Triplets with sum equal to 0:
[[-1, 0, 1]]

Input:
Enter number of elements:
2
Enter array elements:
1 -1

Output:
Triplets with sum equal to 0:
[]

Time complexity: O(n^3) - Using 3 nested for loops
Space complexity: O(n) - Storing less than n triplets.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements: ");
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> triplets = getTriplets(nums, n);
        System.out.println("Triplets with sum equal to 0: ");
        System.out.println(triplets);
    }

    private static List<List<Integer>> getTriplets(int [] nums, int n){
        if(n < 3){
            return new ArrayList<>();
        }

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
