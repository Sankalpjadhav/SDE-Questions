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
[[-1, -1, 2], [-1, 0, 1]]

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

Time complexity: O(nlogn) + O(n*n) - Sorting + traversing through nums only once with two pointers approach.
Space complexity: O(1) - Not using extra space.
 */
public class OptimalApproach {
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
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int low = i+1;
            int high = n-1;
            int sum = 0 - nums[i];

            while(low < high){
                if(nums[low] + nums[high] == sum){
                    triplets.add(Arrays.asList(nums[i], nums[low], nums[high]));
                }

                while(low < high && nums[low] == nums[low+1]){
                    low++;
                }
                while(low < high && nums[high] == nums[high-1]){
                    high--;
                }
                low++;
                high--;
            }
        }

        return triplets;
    }
}
