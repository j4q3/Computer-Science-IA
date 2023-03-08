import java.io.*;
import java.util.*;
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
        try {
            list.menu();
            
        } catch (Exception e) {
            System.out.println("Error" + e);
            }
    
        writeStudents(studentArr); //styudent arary paramter!!!!!!!!!!!!!!!
        readStudents(studentArr);   
        }

    public static void writeStudents(StudentGrade [] studentArr) throws IOException {
        File file = new File("studentGrades.txt");
        FileWriter stream = new FileWriter(file);
        PrintWriter output = new PrintWriter(stream);

        for (int i = 0; i < studentArr.length; i++) {
            output.println((studentArr[i].state()));
            }
            output.close();
            }
   

    public static void readStudents(StudentGrade [] studentArr) throws IOException {
        File file1 = new File("studentGrades.txt");
        FileWriter stream1 = new FileWriter(file1);
        Scanner scan = new Scanner(file1);
        int info = 0;
            while (scan.hasNext()) {
                String line = scan.nextLine();
                studentArr[info] = new StudentGrade(line);
                info = info + 1;
                }
                scan.close();
        System.out.println("File has " + info + " students");
            for(int j = 0; j < info; j++) {
                studentArr[j].state();
                }
            }

    public static int linearSearch(StudentGrade[] studentArr, int val) {
        for (int i = 0; i < studentArr.length; i++) {
            System.out.println("THis is I of the array: " + studentArr[i]);
        if (val == studentArr[i].IDnum) {
            System.out.println("Student account at index: " + i);
            return i;
            }
        }
        System.out.println("No ID number found");
        return -1;
       }

    public static void quit() {
        System.out.println("Exiting program...");
        System.exit(0);
        }
        public static void pause() {
            Scanner keyIn = new Scanner(System.in);
            System.out.println("Press to continue");
            keyIn.nextLine();
        }
    }


