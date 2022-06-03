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

Time complexity: O(nlogn) : Using merge sort
Space complexity: O(n) : Merge sort uses extra space (temp array)
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int [] temp = new int[n];
        System.out.println("Count of reverse pairs: "+getCount(arr,0, n-1, temp));
    }

    private static int getCount(int [] arr, int start, int end, int [] temp){
        int countOfReversePairs = 0;

        if(start < end){
            int mid = (start+end)/2;
            countOfReversePairs += getCount(arr, start, mid, temp);
            countOfReversePairs += getCount(arr, mid+1, end, temp);

            countOfReversePairs += merge(arr, start, mid+1, end, temp );
        }

        return countOfReversePairs;
    }

    private static int merge(int [] arr, int start, int mid, int end, int [] temp){
        int i = start;
        int j = mid;
        int k = start;
        int countOfReversePairs = 0;
        while((i<=mid-1) && (j<=end)){
            if(arr[i] > 2 * (long)arr[j]){
                countOfReversePairs += mid - i;
                j++;
            }
            else{ // <=
                i++;
            }
        }
        i = start;
        j = mid;
        while((i<=mid-1) && (j<=end)){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid-1){
            temp[k++] = arr[i++];
        }

        while(j<=end){
            temp[k++] = arr[j++];
        }

        for(int copy=start;copy<=end;copy++){
            arr[copy] = temp[copy];
        }

        return countOfReversePairs;
    }
}
