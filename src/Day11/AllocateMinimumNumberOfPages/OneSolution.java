package Day11.AllocateMinimumNumberOfPages;

import java.util.Scanner;
/*
Asked in Google many times.
Input:
Enter number of books:4
Enter number of pages in each book:
12 34 67 90
Enter number of students: 2
Output:
Minimum number of pages alloted to a student post allocating all the books to all numberOfStudents: 113

Time complexity: O(logn * n )
logn - For applying binary search
n - isPossibleToAllocate function

Space complexity: O(1) - Not using extra space
*/
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books:");
        int numberOfBooks = sc.nextInt();
        int [] books = new int[numberOfBooks];
        System.out.println("Enter number of pages in each book: ");
        for(int i=0;i<numberOfBooks;i++){
            books[i] = sc.nextInt();
        }
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        System.out.println("Minimum number of pages alloted to a student post allocating all the books to all numberOfStudents: "+allocateBooks(numberOfBooks, books, numberOfStudents));
    }

    private static int allocateBooks(int numberOfBooks, int [] books, int numberOfStudents){
        if(numberOfStudents > numberOfBooks){
            return -1;
        }
        if(numberOfBooks==0){
            return -1;
        }
        int result = -1;
        int low = books[0];
        int high = 0;

        for(int i=0;i<numberOfBooks;i++){
            low = Math.min(low, books[i]);
            high += books[i];
        }

        while(low<=high){
            int mid = (low+high)/2;
            if(isPossibleToAllocate(mid, numberOfBooks, numberOfStudents, books)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return result;
    }

    private static boolean isPossibleToAllocate(int barrier, int numberOfBooks, int numberOfStudents, int [] books){
        int allocateStudent = 1;
        int pages = 0;

        for(int i=0;i<numberOfBooks;i++){
            if(books[i]>barrier){
                return false;
            }

            if(pages+books[i] > barrier){
                allocateStudent++;
                pages = books[i];
            }
            else{
                pages+=books[i];
            }
        }

        if(allocateStudent > numberOfStudents){
            return false;
        }
        return true;
    }
}
