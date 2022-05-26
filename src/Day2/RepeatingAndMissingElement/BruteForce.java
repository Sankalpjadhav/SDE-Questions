package Day2.RepeatingAndMissingElement;

import java.util.Scanner;
/*
Input:
5
3 1 2 5 3

Output:
Repeating element: 3 , Missing element: 4

Time complexity: O(2*N) : Traversing twice
Space complexity: O(N) : Making use of frequency array
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Pair result = getRepeatingMissingElement(arr, n);
        System.out.println("Repeating element: "+result.repeatingElement+" , Missing element: "+result.missingElement);
    }

    private static Pair getRepeatingMissingElement(int [] arr, int n){
        //Consider elements starting from 1 instead of 0
        Pair result = new Pair(-1,-1);
        int [] frequencyArray = new int[n];

        for(int i=0;i<n;i++){
            frequencyArray[arr[i]-1]++;
        }

        for(int i=0;i<n;i++){
            if(frequencyArray[i]==0){
                result.missingElement = i+1;
            }
            else if(frequencyArray[i]==2){
                result.repeatingElement = i+1;
            }
        }

        return result;
    }
}

class Pair{
    int repeatingElement;
    int missingElement;

    public Pair(int repeatingElement, int missingElement){
        this.repeatingElement = repeatingElement;
        this.missingElement = missingElement;
    }
}