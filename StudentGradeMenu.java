import java.io.IOException;
import java.util.Scanner;
public class StudentGradeMenu {
   //Choice 1) linear search
   //choice 2) Bubble sort
   //choice 3) Average letter grade
   //choice 4) Add new student
   //choice 5) Exit

   public void menu() throws IOException {
      int choice = 0;
       StudentGradeDriver pause1 = new StudentGradeDriver();
       do {
         choice = menuChoice();
         if (choice == 1) {
            StudentGradeDriver revStudents = new StudentGradeDriver();
            revStudents.reviewStudents();
            pause1.pause();

         }
           if (choice == 2) {
            StudentGradeDriver LS = new StudentGradeDriver();
            LS.linearSearch();
            pause1.pause();
            
         } else if (choice == 3) {
            StudentGradeDriver Sort = new StudentGradeDriver();
            Sort.bubbleSort();
            pause1.pause();
         // } else if (choice == 3) {
         // }
         } else if (choice == 6) {
            StudentGradeDriver quitProgram = new StudentGradeDriver();
            quitProgram.quit();
       
      }


       } while ((choice >= 1) && (choice < 7));
   }

//hi

   //menu choice
   public static int menuChoice() {
       String question =
               "|     Student Gradebook Menu    |" 
               + "\n -------------------------------"
               + "\n 1) Review students" 
               + "\n 2) Linear search for student ID"
               + "\n 3) Bubble sort test grades (test rank)"
               + "\n 4) Average letter grade"
               + "\n 5) Add new student"
               + "\n 6) Quit program"
               + "\nEnter your choice: ";


       System.out.println(question);
       Scanner input = new Scanner(System.in);
       int c = input.nextInt();
       return c;
   }
}
