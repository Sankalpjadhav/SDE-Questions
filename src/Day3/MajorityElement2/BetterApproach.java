package Day3.MajorityElement2;

import java.util.HashMap;
import java.util.Scanner;
/*
Find all majority elements that appear more than N/3 elements

NOTE:
- Not necessary we need to have majority element, since in the question it is not mentioned.
- We need to have keep in mind that there can be max of 2 majority elements in N/3

Input:
8
1 2 4 2 4 4 1 1

Output:
Majority element 1 = 1
Majority element 2 = 4

Input:
5
2 1 1 3 1

Output:
Majority element 1 = 1
Majority element 2 = -1

Time complexity : O(n) : Making  use of hashmap to store array elements freq. Then traversing and finding out elements whose frequency is greater than n/3
Space complexity : O(n) : Using hashmap to store frequency
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Pair res = getMajorityElements(arr, n);
        System.out.println("Majority element 1 = "+res.majorityElem1+"\nMajority element 2 = "+res.majorityElem2);
    }

    private static Pair getMajorityElements(int [] arr, int n){
        Pair elements = new Pair(-1, -1);
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(freqMap.get(arr[i])!=null){
                freqMap.put(arr[i], freqMap.get(arr[i])+1);
            }
            else{
                freqMap.put(arr[i], 1);
            }
        }

        for(int elem: freqMap.keySet()){
            if(freqMap.get(elem) > n/3){
                if(elements.majorityElem1 != -1){
                    elements.majorityElem2 = elem;
                }
                else{
                    elements.majorityElem1 = elem;
                }
            }
        }

        return elements;
    }
}
