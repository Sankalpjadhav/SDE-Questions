package Day1.PascalsTriangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Input:
5

Pascal triangle:
        [1]
      [1, 1],
    [1, 2, 1],
  [1, 3, 3, 1],
[1, 4, 6, 4, 1]


Time complexity = O(n*n) Computing every row and col by simultaneously moving downwards
Space complexity = O(n*n) storing entire Pascal triangle
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nRows = sc.nextInt();
        System.out.println("Pascal triangle: "+pascalsTriangle(nRows));
    }

    private static List<List<Integer>> pascalsTriangle(int nRows){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> previousRow, currentRow = new ArrayList<>();

        for(int i=0;i<nRows;i++){
            previousRow = currentRow;
            currentRow = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    currentRow.add(1);
                }
                else{
                    currentRow.add(previousRow.get(j) + previousRow.get(j-1));
                }
            }
            res.add(currentRow);
        }
        return res;
    }
}
