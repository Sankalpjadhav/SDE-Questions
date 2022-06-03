package Day3.MajorityElement2;

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

Time complexity : O(n^2) : For each element we are traversing entire array to count
Space complexity : O(1) : Not using extra space
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Pair res = getMajorityELements(arr, n);
        System.out.println("Majority element 1 = "+res.majorityElem1+"\nMajority element 2 = "+res.majorityElem2);
    }

    private static Pair getMajorityELements(int [] arr, int n){
        Pair elements = new Pair(-1, -1);

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count > n/3){
                if(elements.majorityElem1 !=-1){
                    elements.majorityElem2 = arr[i];
                    break; // this is important, because once you find out second majority element then no need to see for other elements since there can be max 2 majority elements in n/3 division.
                }
                else{
                    elements.majorityElem1 = arr[i];
                }
            }
        }

        return elements;
    }
}

class Pair{
    int majorityElem1;
    int majorityElem2;

    public Pair(int elem1, int elem2){
        majorityElem1 = elem1;
        majorityElem2 = elem2;
    }
}