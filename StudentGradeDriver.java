import java.io.*;
import java.util.Scanner;

public class StudentGradeDriver {
    public static void main(String[] args) throws IOException { 
        
        StudentGrade[] studentArr = new StudentGrade[10];
        StudentGrade s1 = new StudentGrade("Jackeline", "Hong", 111, 99.9, 90.1, 95.3);
        StudentGrade s2 = new StudentGrade("Donny", "Nguyen", 432, 90, 93, 98.1);
        StudentGrade s3 = new StudentGrade("Paulina", "Faithe", 353, 67, 64.5, 79.8);
        StudentGrade s4 = new StudentGrade("Joni", "Missy", 788, 95.6, 80.1, 97.6);
        StudentGrade s5 = new StudentGrade("Kristie", "Wilkie", 999, 99.1, 78.4, 70.7);
        StudentGrade s6 = new StudentGrade("Ella", "Laurena", 101, 54, 69, 75.5);
        StudentGrade s7 = new StudentGrade("Junior", "Vera", 113, 84, 90.9, 100.2);
        StudentGrade s8 = new StudentGrade("Connell", "Merton", 432, 52, 76.2, 70.6);
        StudentGrade s9 = new StudentGrade("Malcom", "Joi", 567, 99.4, 92.1, 97.5);
        StudentGrade s10 = new StudentGrade("Kayla", "Euell", 266, 90.2, 85.5, 100);
        studentArr[0] = s1;
        studentArr[1] = s2;
        studentArr[2] = s3;
        studentArr[3] = s4;
        studentArr[4] = s5;
        studentArr[5] = s6;
        studentArr[6] = s7;
        studentArr[7] = s8;
        studentArr[8] = s9;
        studentArr[9] = s10;

        StudentGradeMenu list = new StudentGradeMenu();
        writeStudents(studentArr); 
        
        try {
            list.menu();
            
        } catch (Exception e) {
            System.out.println("Error" + e);
            }
        readStudents(); 

        }
    //write method
    public static void writeStudents(StudentGrade [] studentArr) throws IOException {
        File file = new File("studentGrades.txt");
        FileWriter stream = new FileWriter(file);
        PrintWriter output = new PrintWriter(stream);
        for (int i = 0; i < studentArr.length; i++) {
            output.println((studentArr[i].state()));
            }
            output.close();
            }
   
    //read method
    public static StudentGrade[] readStudents() throws IOException {
        File readFile = new File("studentGrades.txt");
        Scanner scan = new Scanner(readFile);

        int info = 0;
        StudentGrade[] studentArr = new StudentGrade[10];
        while (scan.hasNext()) {
            String line = scan.nextLine();
            StudentGrade student = new StudentGrade("", "", 0, 0, 0, 0);
            studentArr[info] = student.parseStudentGrade(line);
            info = info + 1;
            }
            scan.close();
            return studentArr;
        }
    public void reviewStudents() throws IOException {
        StudentGrade [] reviewArray = readStudents();
        for (int r = 0; r < reviewArray.length; r ++){
            System.out.println(reviewArray[r].firstName + " " + reviewArray[r].lastName + "\nID number: " + reviewArray[r].IDnum);
        }
    }
    //linear Search
    public int linearSearch() throws IOException {
        StudentGrade [] studentArr = readStudents();
        System.out.println("Type in the ID number that you would like to search for: ");
        Scanner search = new Scanner(System.in);
        int val = (search.nextInt());

        for (int i = 0; i < studentArr.length; i++) {
            if (val == studentArr[i].IDnum) {
                System.out.print("Student ID number is at index " + i + ",");
                System.out.println(" Student is " + studentArr[i].firstName + " " + studentArr[i].lastName + " " + "(ID number " + studentArr[i].IDnum + ")");
               
                return i;
                }
            }
        System.out.println("No ID number found");
        return -1;
       }
    //bubble sort
    public StudentGrade[] bubbleSort() throws IOException {
        StudentGrade [] testGradesArr = readStudents();
        System.out.println("\nTest grades before sort: ");
        for (int q = 0; q < testGradesArr.length; q ++){
            System.out.println(testGradesArr[q].firstName + " " + testGradesArr[q].lastName + ": " + testGradesArr[q].testGrade);
        }

        for (int a = 0; a < (testGradesArr.length - 1); a++) {
            for(int b = 0; b < (testGradesArr.length - 1); b++) { 
                if (testGradesArr[b].testGrade > testGradesArr[b + 1].testGrade){
                    double swap = testGradesArr[b].testGrade;
                    testGradesArr[b].testGrade = testGradesArr[b + 1].testGrade;
                    testGradesArr[b + 1].testGrade = swap;
                }
            }
        }

        System.out.println("\nTest grades after sort: ");
        for(int after = 0; after < testGradesArr.length; after ++){
            System.out.println(testGradesArr[after].firstName
             + " " + testGradesArr[after].lastName + ": "
             + testGradesArr[after].testGrade);
        }
        return testGradesArr;
        
    } 
    public void AverageLetterGrade() throws IOException{
        StudentGrade [] avgGradeArr = readStudents();
        int length = 3;
        double sumGrade = 0;
        double average = 0;

        for (int avg = 0; avg < avgGradeArr.length; avg ++) {
            sumGrade = avgGradeArr[avg].classworkGrade += avgGradeArr[avg].quizGrade += avgGradeArr[avg].testGrade;
            average = sumGrade / length;
            if (average > 93){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "A" );
            } else if (average > 90){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "A-");
            } else if (average > 87){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "B+");
            } else if (average > 83){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "B");
            } else if (average > 80){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "B-");
            } else if (average > 77){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "C+");
                System.out.println(" - This student qualifies for a retake.");
            } else if (average > 73){
               System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "C");
               System.out.println(" - This student qualifies for a retake.");
            } else if (average > 70){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "C-");
                System.out.println(" - This student qualifies for a retake.");
            } else if (average > 67) {
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "D+");
                System.out.println(" - This student qualifies for a retake.");
            } else if (average > 64) {
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "D");
                System.out.println(" - This student qualifies for a retake.");
            } else if (average >= 64){
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "F");
                System.out.println(" - This student qualifies for a retake.");
            } else if (average < 64) {
                System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName + "'s letter grade is: " + "F");
                System.out.println(" - This student qualifies for a retake.");
            }
        
        }

    }
    public void AddStudent() throws IOException{
        StudentGrade [] addStudentArr = readStudents();
        StudentGrade[] addArray = new StudentGrade[addStudentArr.length + 1];
        Scanner userInput = new Scanner(System.in);
        for(int c = 0; c < addStudentArr.length; c++) {
            addArray[c] = addStudentArr[c];
        }

        for (int add = 0; add < 1; add ++) {
            System.out.println("What is the students first name?: ");
            String firstName = userInput.nextLine();

            System.out.println("What is the students last name?: ");
            String lastName = userInput.nextLine();

            System.out.println("What is the students ID number? (3 digits): ");
            int IDnum = userInput.nextInt();
            userInput.nextLine();

            System.out.println("What is the students overall classwork grade? (60-100): ");
            double classworkGrade = userInput.nextDouble();
            userInput.nextLine();

            System.out.println("What is the students overall quiz grade? (50-100): ");
            double quizGrade = userInput.nextDouble();
            userInput.nextLine();

            System.out.println("What is the students overall testGrade? (50-100): ");
            double testGrade = userInput.nextDouble();
            userInput.nextLine();
            addArray[addStudentArr.length] = new StudentGrade(firstName, lastName, IDnum, classworkGrade, quizGrade, testGrade);

        }
            for(int pp = 0; pp < addArray.length; pp++){
                System.out.println(addArray[pp]);
            }
            writeStudents(addArray);
    
        }
    
    // quit
    public void quit() {
        System.out.println("Exiting program...");
        System.exit(0);
        }

     public void pause() {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("\nPress enter continue");
        keyIn.nextLine();
        }
    }


