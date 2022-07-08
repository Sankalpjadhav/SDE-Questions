package Day11.NthRootOfAnInteger;

import java.util.Scanner;
/*
Input:
Enter the values of n and m:
3 27
Output:
Found out value: 2.9999998807907104
Math.pow() value: 3.0

Input:
Enter the values of n and m:
4 15
Output:
Found out value: 1.967989444732666
Math.pow() value: 1.9679896712654303

Time complexity : O(n*(log(m*(10^d))))
Lets take m = 27
You might be wondering since search space is from 1........27, time complexity would be log27. But No!!
its actually something like this:
1,1.1,1.2,....2,2.1,2.2,.........27. i.e if we consider, we're finding the answer in terms of 1 decimal place.
For every number, let say from 1 to 2, we have 10 numbers then for 27 we have 27*10 numbers.

Time complexity = log(M*10)

lets say if we want answer to 5 decimal places.

Time complexity = log(M*(10^d))

Inside Binary search we're running multiply function.

Time complexity = n * log(M*(10^d))

Space complexity : O(1) - Not using extra space
 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of n and m: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        double result = findNthRootOfAnInteger(n, m);
        System.out.println("Found out value: "+result+"\n"+"Math.pow() value: "+Math.pow(m,(1.0)/n));
    }

    private static double findNthRootOfAnInteger(int n, int m){
        double low = 1;
        double high = m;
        double epsilon = 1e-6;

        while((high-low) > epsilon){
            double mid = (low+high)/2.0;

            if(multiply(mid, n) < m){
                low = mid;
            }
            else{
                high = mid;
            }
        }

        return low; // or high
    }

    private static double multiply(double mid, int n){
        double ans = 1.0;
        for(int i=1;i<=n;i++){
            ans = ans*mid;
        }
        return ans;
    }
}
