package Day3.MajorityElement;
import java.util.Scanner;
/*
Note : It is guarantee that there exist one majority element

Input:
3
3 2 3
Output: Majority element: 3

Input:
16
7 7 5 7 5 1 5 7 5 5 7 7 5 5 5 5
Output: Majority element: 5

Time complexity: O(n) : just traversing the array elements once using Moore voting algorithm
Space complexity: O(1)  : not using extra space

Note: Hashmap put and get operation time complexity is O(1) with assumption that key-value pairs are well distributed across the buckets.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Majority element: "+getMajorityElement(nums, n));
    }

    private static int getMajorityElement(int [] nums, int n) {
        int element = -1;
        int count = 0;

        for(int num: nums){
            if(count == 0){
                element = num;
            }

            if(element == num){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
        /*
        NOTE:
        If the question had mentioned that there is no guarantee of existence of Majority element. We can further loop array and
        count number of times element is present, otherwise return -1

        for(int elem: nums){
            if(elem==element){
                count++;
            }
        }

        if(count > n/2){
            return element;
        }
        return -1;
         */
    }
}
