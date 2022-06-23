package Day8.MinimumPlatforms;

import java.util.Arrays;
import java.util.Scanner;
/*
We need to find minimum number of platforms required for the railway station so that no train is kept waiting.

Consider that all the train arrive on the same day and leave on same day. Arrival and Departure time cannot be same for any single train.
At any instance of time, same platform cannot be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

Input:
Enter number of trains:
6
Enter arrival and departure time:
50 500
200 600
120 550
550 700
700 900
850 1000
Output:
Minimum number of platforms required for the railway station so that no train is kept waiting: 3

Time complexity: O(nlogn) + O(nlogn) + O(2n)
O(nlogn) - For sorting arrival time
O(nlogn) - For sorting departure time
O(2n) - For traversing both arrival and departure array

Space complexity: O(1) - Not using extra space.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of trains: ");
        int numberOfTrains = sc.nextInt();
        System.out.println("Enter arrival and departure time: ");
        int [] arrivalTime = new int[numberOfTrains];
        int [] departureTime = new int[numberOfTrains];
        for(int i=0;i<numberOfTrains;i++){
            arrivalTime[i] = sc.nextInt();
            departureTime[i] = sc.nextInt();
        }
        System.out.println("Minimum number of platforms required for the railway station so that no train is kept waiting: "+getNumberOfPlatforms(arrivalTime, departureTime, numberOfTrains));
    }

    private static int getNumberOfPlatforms(int [] arrivalTime, int [] departureTime, int numberOfTrains){
        if(numberOfTrains <= 1){
            return numberOfTrains;
        }
        int numberOfPlatformsNeeded = 1;
        int platforms = 1;
        Arrays.sort(arrivalTime);
        Arrays.sort(departureTime);

        int arrivalTimePointer = 1; // started with index 1 because for the first train we have already considered platform as 1
        int departureTimePointer = 0;

        while(arrivalTimePointer < numberOfTrains && departureTimePointer < numberOfTrains){
            if(arrivalTime[arrivalTimePointer] <= departureTime[departureTimePointer]){
                platforms++;
                arrivalTimePointer++;
            }
            else{
                platforms--;
                departureTimePointer++;
            }
            numberOfPlatformsNeeded = Math.max(numberOfPlatformsNeeded, platforms);
        }

        return numberOfPlatformsNeeded;
    }
}
