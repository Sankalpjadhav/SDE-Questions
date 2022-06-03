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

Input:
5
2 1 1 3 1

Output:
Majority element 1 = 1
Majority element 2 = -1

Time complexity : O(n) : Traversing arr only once using Boyer Moore Voting Algo
Space complexity : O(1) : Not using extra space
 */
public class OptimalApproach {
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
        int element1 = -1;
        int element2 = -1;
        int count1 = 0;
        int count2 = 0;

        for(int num: arr){
            if(element1 == num){
                count1++;
            }
            else if(element2 == num){
                count2++;
            }
            else if(count1 == 0){
                element1 = num;
                count1++;
            }
            else if(count2 == 0){
                element2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num: arr){
            if(num == element1){
                count1++;
            }
            else if(num==element2){
                count2++;
            }
        }
        Pair elements = new Pair(-1, -1);
        if(count1 > n/3){
            elements.majorityElem1 = element1;
        }

        if(count2 > n/3){
            elements.majorityElem2 = element2;
        }

        return elements;
    }
}
