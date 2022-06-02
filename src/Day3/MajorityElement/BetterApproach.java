package Day3.MajorityElement;
import java.util.HashMap;
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

Time complexity: O(n) : Using hashmap to store key and count and then traversing to find out the majority element
Space complexity: O(n)  : Using hashmap to store

Note: Hashmap put and get operation time complexity is O(1) with assumption that key-value pairs are well distributed across the buckets.
 */
public class BetterApproach {
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
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }
            else{
                freqMap.put(num, 1);
            }
        }

        for(int key : freqMap.keySet()){
            if(freqMap.get(key) > n/2){
                element = key;
                break;
            }
        }

        return element;
    }
}
