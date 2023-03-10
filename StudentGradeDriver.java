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
            System.out.println(reviewArray[r].firstName + " " + reviewArray[r].lastName + " " + reviewArray[r].IDnum);
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

        System.out.println("\nAfter sort: ");
        for(int after = 0; after < testGradesArr.length; after ++){
            System.out.println(testGradesArr[after].firstName
             + " " + testGradesArr[after].lastName + ": "
             + testGradesArr[after].testGrade);
        }
        return testGradesArr;
        
    } 

    public static AddStudent() {
        
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


