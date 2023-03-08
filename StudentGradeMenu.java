import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class StudentGradeMenu {
   //Choice 1) linear search
   //choice 2) Bubble sort
   //choice 3) Average letter grade
   //choice 4) Add new student
   //choice 5) Exit
   public void menu() throws Exception {
       // menu choices loop
       int choice = menuChoice();
       do {
           if (choice == 1) {
               System.out.println("Type in the ID number that you would like to search for: ");
               Scanner search = new Scanner(System.in);
               int val = (search.nextInt());
               int LS = linearSearch(studentArr, val);
               pause();


           } else if (choice == 2) {
               System.out.println("Before bubble sort:");
               for (int l = 0; l < studentArr.length; l++) {
                   System.out.println(studentArr[l]);
               }
               bubbleSort(studentArr);
           //} else if (choice == 3) {
           } else if (choice == 4) {
               for (int q = 0; q < studentArr.length; q++) {
                   quit();
               }
               choice = menuChoice();
           }


       } while ((choice >= 1) && (choice < 6));
   }

//hi

   //menu choice
   public static int menuChoice() {
       String question =
               "\n 1) Linear search for student"
                       + "\n 2) Bubble sort ID numbers "
                       + "\n 3) Add new student"
                       + "\n 4) Quit program"
                       + "\n Enter your choice: ";


       System.out.println(question);


       Scanner input = new Scanner(System.in);
       int c = input.nextInt();
       return c;
   }
   //linear search
 

   //bubble sort
   public static void bubbleSort(StudentGrade[] studentArr) {
       for (int a = 0; a < studentArr.length - 1; a++) {
           System.out.println(studentArr[a].IDnum);
           for (int b = 0; b < studentArr.length - 1; b++) {
               if (studentArr[b].IDnum > studentArr[b + 1].IDnum) {
                   int swap = studentArr[b].IDnum;
                   studentArr[b].IDnum = studentArr[b + 1].IDnum;
                   studentArr[b + 1].IDnum = swap;
               }
           }
           System.out.println("After bubble sort: ");
           for (int k = 0; k < studentArr.length; k++) {
               System.out.println(studentArr[k].IDnum);
           }
       }
   }
//add new student
//    public static void addnew()


   //quit program
   
