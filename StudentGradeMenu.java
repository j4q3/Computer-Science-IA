import java.io.IOException;
import java.util.Scanner;
public class StudentGradeMenu {
   //Menu method executes the methods that correlate with the choices the user enters from the menuChoice method.
   public void menu() throws IOException {
      int choice = 0;
       StudentGradeDriver pause1 = new StudentGradeDriver();
       do {
         choice = menuChoice();
         if (choice == 1) {
            StudentGradeDriver revStudents = new StudentGradeDriver();
            revStudents.ReviewStudents();
            pause1.pause();

         } else if (choice == 2) {
            StudentGradeDriver LS = new StudentGradeDriver();
            LS.LinearSearch();
            pause1.pause();
            
         } else if (choice == 3) {
            StudentGradeDriver Sort = new StudentGradeDriver();
            Sort.BubbleSort();
            pause1.pause();
         } else if (choice == 4) {
            StudentGradeDriver AvgGrade = new StudentGradeDriver();
            AvgGrade.AverageLetterGrade();
            pause1.pause();
         } else if (choice == 5) {
            StudentGradeDriver addStudent = new StudentGradeDriver();
            addStudent.AddStudent();
            pause1.pause();
         } else if (choice == 6) {
            StudentGradeDriver quitProgram = new StudentGradeDriver();
            quitProgram.quit();
       
      }


       } while ((choice >= 1) && (choice < 7));
   }



   // Menu choice method prints the menu onto the console and takes user input.
   public static int menuChoice() {
       String question =
      " -----------------------------------------"
      +"\n|         Student Gradebook Menu          |" 
      + "\n -----------------------------------------"
      + "\n| 1) Review students                      | "            
      + "\n| 2) Linear search for student ID         |"
      + "\n| 3) Bubble sort test grades (test rank)  |"
      + "\n| 4) Average letter grade                 |"
      + "\n| 5) Add new student                      |"
      + "\n| 6) Quit program                         |" 
      + "\n-------------------------------------------"
      + "\nEnter your choice: ";
      
       System.out.println(question);
       Scanner input = new Scanner(System.in);
       int c = input.nextInt();
       StudentGradeDriver pause2 = new StudentGradeDriver();
       // Checks if choice is valid 1-6.
       if (c < 1 || c > 6){
         System.out.println("Please enter a choice between 1-6");
       }
       return c;
   }
}
