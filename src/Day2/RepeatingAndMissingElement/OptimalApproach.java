package Day2.RepeatingAndMissingElement;
import java.util.Scanner;

/*
Input:
5
3 1 2 5 3

Output:
Repeating element: 3 , Missing element: 4

Input:
6
3 1 4 5 4 2

Output:
Repeating element: 4 , Missing element: 6

Time complexity: O(2*N) : Traversing twice
Space complexity: O(1) : Not using extra space
 */
public class OptimalApproach {
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


    public static Pair getRepeatingMissingElement(int [] arr, int n){
        Pair result = new Pair(-1, -1);

        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])-1]<0){
                result.repeatingElement = Math.abs(arr[i]);
            }
            else {
                arr[Math.abs(arr[i])-1] = - arr[Math.abs(arr[i])-1];
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                result.missingElement = i+1;
            }
        }

        return result;
    }
}
