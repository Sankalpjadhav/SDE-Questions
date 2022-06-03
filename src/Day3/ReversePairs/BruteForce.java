package Day3.ReversePairs;

import java.util.Scanner;
/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i,j) where 0 <= i < j < num.length and nums[i] > 2 * nums[j]

Input:
5
2 4 3 5 1

Output:
Count of reverse pairs: 3

Input:
5
1 3 2 3 1

Output:
Count of reverse pairs: 2

Time complexity: O(n^2) : Using nested for loops
Space complexity: O(1) : Not using extra space

 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Count of reverse pairs: "+getCount(arr, n));
    }

    private static int getCount(int [] arr, int n){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] > 2 * (long)arr[j]){
                    count++;
                }
            }
        }

        return count;
    }
}
