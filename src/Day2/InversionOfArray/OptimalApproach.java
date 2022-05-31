package Day2.InversionOfArray;
import java.util.Scanner;
/*
Input:
4
8 4 2 1

Output:
Inversion count: 6

Time complexity: O(nlogn) : Merge sort
Space complexity: O(n) : Use of temp array
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Inversion count: "+getInversionCount(arr, 0, n-1, new int[n]));
    }

    private static int getInversionCount(int [] arr, int left, int right, int [] temp){
        int count = 0;

        if(left < right){
            int mid = (left+right)/2;
            count += getInversionCount(arr, left, mid, temp);
            count += getInversionCount(arr, mid+1, right, temp);
            count += merge(arr, temp, left, mid+1, right);
        }

        return count;
    }

    private static int merge(int [] arr, int [] temp, int left, int mid, int right){
        int countInversions = 0;
        int i = left;
        int j = mid;
        int k = left;

        while((i<=mid-1)&&(j<=right)){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{ // arr[i] > arr[j]
                temp[k++] = arr[j++];
                countInversions += mid-i;
            }
        }

        while(i<=mid-1){
            temp[k++] = arr[i++];
        }

        while(j<=right){
            temp[k++] = arr[j++];
        }

        for(int copy=left;copy<=right;copy++){
            arr[copy] = temp[copy];
        }

        return countInversions;
    }
}
