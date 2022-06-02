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

Time complexity: O(logn) : n is getting divided by 2 whenever it is even and whenever it is odd it is reduced by 1 which apparently makes it even number.
Space complexity: O(1) : Not using any extra space

 */
public class OptimalApproach {
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

        while(nn > 0){
            if(nn % 2 == 0){
                // Even
                x = x * x;
                nn = nn / 2;
            }
            else{
                // Odd
                ans = ans * x;
                nn = nn - 1;
            }
        }

        if(n < 0){
            ans = (double)1/ans;
        }
        return ans;
    }
}
