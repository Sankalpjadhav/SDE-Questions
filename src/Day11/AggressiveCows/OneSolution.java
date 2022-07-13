package Day11.AggressiveCows;

import java.util.Arrays;
import java.util.Scanner;
/*
Cows don't like the barn layout and become aggressive towards each other once put into stalls. To prevent the cows from hurting each other, farmer John
wants to assign cows to the stalls, such that minimum distance between any two of them is as large as possible. You are required to find the largest
minimum distance.

Input:
Enter number of stalls: 5
Enter coordinates of stalls:
1 2 4 8 9
Enter number of cows: 3
Output:
Largest minimum distance: 3

Time complexity: O(n*logn)
where, n is number of stalls
logn : Applying binary search
n: canPlaceCow function

Space complexity: O(1) - Not using extra space
 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stalls: ");
        int numberOfStalls = sc.nextInt();
        System.out.println("Enter coordinates of stalls: ");
        int [] coordinatesOfStalls = new int[numberOfStalls];
        for(int i=0;i<numberOfStalls;i++){
            coordinatesOfStalls[i] = sc.nextInt();
        }
        System.out.print("Enter number of cows: ");
        int numberOfCows = sc.nextInt();
        System.out.println("Largest minimum distance: "+getLargestMinimumDistance(numberOfStalls, coordinatesOfStalls, numberOfCows));
    }

    private static int getLargestMinimumDistance(int numberOfStalls, int [] coordinatesOfStalls, int numberOfCows){
        if(numberOfStalls < numberOfCows){
            return -1;
        }
        int result = -1;
        Arrays.sort(coordinatesOfStalls); // Not necessary interviewer might have given the coordinate in sorted order. So make sure to sort it since we are going to apply binary search
        int low = 1;
        int high = coordinatesOfStalls[numberOfStalls-1] -  coordinatesOfStalls[0];

        while(low<=high){
            int mid = (low+high)/2;
            if(canPlaceCows(coordinatesOfStalls, numberOfStalls, numberOfCows, mid)){
                result = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return result;
    }

    private static boolean canPlaceCows(int [] coordinatesOfStalls, int numberOfStalls, int numberOfCows, int distance){
        // We will place one of the cow at first coordinate
        int coordinate = coordinatesOfStalls[0];
        int cowsPlaced = 1;
        for(int i=1;i<numberOfStalls;i++){
            if(coordinatesOfStalls[i]-coordinate >= distance){
                coordinate = coordinatesOfStalls[i];
                cowsPlaced++;
            }
            else{
               // Don't do anything
            }
            if(cowsPlaced == numberOfCows){
                return true;
            }
        }

        return false;
    }
}
