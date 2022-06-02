package Day3.XRaiseToN;
import java.util.Scanner;
/*
Input:
x: 2
n: -2

Output:
Pow(x,n): 0.25

Input:
x: 2
n: 10

Output:
Pow(x,n): 1024.0

Time complexity: O(n) : Looping from 1 to n
Space complexity: O(1) : Not using any extra space

 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Pow(x,n): "+getValue(x, n));
    }

    private static double getValue(int x, int n){
        double ans = 1.0;
        long nn = n;
        /*
        Value of int is -2,147,483,648 to 2,147,483,647
        if n value is -ve, then while converting value to +ve, it will cause overflow.
        So for n always use long
         */
        if(n<0){
            nn = -1*nn;
        }

        for(int i=1;i<=nn;i++){
            ans = ans*x;
        }

        if(n<0){
            ans = (double)1/(double)ans;
        }
        return ans;
    }
}
