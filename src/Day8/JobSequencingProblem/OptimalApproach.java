package Day8.JobSequencingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*

Input:
Enter number of jobs:
4
Enter deadline and profit associated with each job:
4 20
1 10
1 40
1 30

Output:
Number of jobs that can be performed: 2, Maximum profit that can be achieved: 60

Input:
Enter number of jobs:
8
Enter deadline and profit associated with each job:
4 20
5 60
6 70
6 65
4 25
2 80
2 10
2 22

Output:
Number of jobs that can be performed: 6, Maximum profit that can be achieved: 322

Time complexity: O(nlogn) + O(n) + O(n*m)
O(nlogn) - For sorting
O(n) - To find max deadline, let us say m
O(n*m) - Iterating over all the job ID's and making sure for every job ID, checking from the last deadline(for that job id) till the first deadline which day is empty
whichever day is empty, job is performed on that day

Space complexity: O(n) + O(m)
O(n) - N jobs we are storing
O(m) - Deadline array
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs: ");
        int numberOfJobs = sc.nextInt();
        int [] deadline = new int[numberOfJobs];
        int [] profit = new int[numberOfJobs];
        System.out.println("Enter deadline and profit associated with each job: ");
        for(int i=0;i<numberOfJobs;i++){
            deadline[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }
        Pair pair = getNumberOfJobsAndMaximumProfit(deadline, profit, numberOfJobs);
        System.out.println("Number of jobs that can be performed: "+pair.numberOfJobs+", Maximum profit that can be achieved: "+pair.maxProfit);
    }

    private static Pair getNumberOfJobsAndMaximumProfit(int [] deadline, int [] profit, int numberOfJobs){
        Pair result = new Pair();
        if(numberOfJobs == 1){
            result.numberOfJobs = 1;
            result.maxProfit = profit[numberOfJobs];
            return result;
        }
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();
        ArrayList<Integer> job = null;
        for(int i=0;i<numberOfJobs;i++){
            job = new ArrayList<>();
            job.add(i+1); // Uniquely identifies particular job
            job.add(deadline[i]);
            job.add(profit[i]);
            jobs.add(job);
        }

        Collections.sort(jobs, (a,b) -> b.get(2) - a.get(2));

        int maxDeadLine = 0;
        for(ArrayList<Integer> list : jobs){
            maxDeadLine = Math.max(maxDeadLine, list.get(1));
        }

        int [] Deadlines = new int[maxDeadLine+1];
        Arrays.fill(Deadlines, -1);

        for(ArrayList<Integer> list : jobs){
            for(int j=list.get(1);j>0;j--){
                //Free slot found
                if(Deadlines[j]==-1){
                    Deadlines[j] = list.get(0);
                    result.numberOfJobs++;
                    result.maxProfit += list.get(2);
                    break;
                }
            }
        }

        return result;
    }
}


class Pair{
    int numberOfJobs;
    int maxProfit;

    public Pair(){
        numberOfJobs = 0;
        maxProfit = 0;
    }
}