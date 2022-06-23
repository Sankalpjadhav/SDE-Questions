package Day8.NMeetingsInOneRoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
There is one meeting room in a firm. There are N meetings in the form of (startTime[i], endTime[i]).
We need to find out maximum number of meetings that can be accommodated in the meeting room, when only one meeting can be held in the meeting room at a particular time.

NOTE: Start time of one chosen meeting cant be equal to the end time of the other chosen meeting.

Input:
Enter number of meetings:
6
Enter start time and end time of N meetings:
1 2
3 4
0 6
5 7
8 9
5 9
Meetings: [[1, 2, 1], [3, 4, 2], [0, 6, 3], [5, 7, 4], [8, 9, 5], [5, 9, 6]]

Output:
Meeting which can be accommodated:
Meeting 1 can be accommodated.
Meeting 2 can be accommodated.
Meeting 4 can be accommodated.
Meeting 5 can be accommodated.
Maximum number of meetings that can be accommodated in a single meeting room: 4

Input:
Enter number of meetings:
6
Enter start time and end time of N meetings:
1 2
0 6
3 4
8 9
5 7
8 9
Meetings: [[1, 2, 1], [3, 4, 3], [0, 6, 2], [5, 7, 5], [8, 9, 4], [8, 9, 6]]

Output:
Meeting which can be accommodated:
Meeting 1 can be accommodated.
Meeting 3 can be accommodated.
Meeting 5 can be accommodated.
Meeting 4 can be accommodated.
Maximum number of meetings that can be accommodated in a single meeting room: 4

Time complexity: O(n) + O(nlogn) + O(n)
O(n) - To create meetings
O(nlogn) - To sort meetings based on endTime
O(n) - Again traverse all meetings to find out which meeting can be accommodated.

Space complexity: O(n) - To store meeting information
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of meetings: ");
        int numberOfMeetings = sc.nextInt();
        int [] startTime = new int[numberOfMeetings];
        int [] endTime = new int[numberOfMeetings];
        System.out.println("Enter start time and end time of N meetings: ");
        for(int i=0;i<numberOfMeetings;i++){
            startTime[i] = sc.nextInt();
            endTime[i] = sc.nextInt();
        }
        System.out.println("Maximum number of meetings that can be accommodated in a single meeting room: "+getMaxMeeting(startTime, endTime, numberOfMeetings));
    }

    private static int getMaxMeeting(int [] startTime, int [] endTime, int numberOfMeetings){
        if(numberOfMeetings<=1){
            return numberOfMeetings;
        }

        ArrayList<ArrayList<Integer>> meetings = new ArrayList<>();
        ArrayList<Integer> meeting = null;
        for(int i=0;i<numberOfMeetings;i++){
            meeting = new ArrayList<>();
            meeting.add(startTime[i]);
            meeting.add(endTime[i]);
            meeting.add(i+1); // Meeting index : Which uniquely identifies a meeting
            meetings.add(meeting);
        }

        Collections.sort(meetings, (a,b)->a.get(1)-b.get(1));
        System.out.println("Meetings: "+meetings);
        System.out.println("Meeting which can be accommodated: ");
        int endTimeOfMeeting = -1;
        int maxNumberOfMeetings = 0;

        for(ArrayList<Integer> meet : meetings){
            if(endTimeOfMeeting < meet.get(0)){
                maxNumberOfMeetings++;
                endTimeOfMeeting = meet.get(1);
                System.out.println("Meeting "+meet.get(2)+" can be accommodated.");
            }
        }
        return maxNumberOfMeetings;
    }
}
