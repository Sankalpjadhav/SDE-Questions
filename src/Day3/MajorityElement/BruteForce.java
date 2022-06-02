package Day3.MajorityElement;
import java.util.Scanner;
/*
Note : It is guarantee that there exist one majority element
Input:
3
3 2 3
Output: Majority element: 3

Input:
3
1 2 3
Output: Majority element: -1

Time complexity: O(n^2) : for each element traversing entire array
Space complexity: O(1)  : Not using extra space
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Majority element: "+getMajorityElement(nums, n));
    }

    private static int getMajorityElement(int [] nums, int n){
        int element = -1;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count>n/2){
                element = nums[i];
                break;
            }
        }

        return element;
    }
}
