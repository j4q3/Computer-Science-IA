import java.io.*;
import java.util.Scanner;

public class StudentGradeDriver {
    public static void main(String[] args) throws IOException {
        // Creating and initializing first 10 arrays of objects (students)
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
        // calls the writeStudents method

        writeStudents(studentArr);
        // calls the menu method
        StudentGradeMenu list = new StudentGradeMenu();
        try {
            list.menu();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        // calls the readStudents method
        readStudents();
    }

    // This method writes students in the arrays of objects into the text file
    // "studentGrades.txt"
    public static void writeStudents(StudentGrade[] studentArr) throws IOException {
        File file = new File("studentGrades.txt");
        FileWriter stream = new FileWriter(file);
        PrintWriter output = new PrintWriter(stream);
        for (int i = 0; i < studentArr.length; i++) {
            if (studentArr[i] != null) { // if the element in the arrays are not null, then it will be printed to the
                                         // file.
                output.println((studentArr[i].state()));
            }
        }
        output.close();
    }

    // Read method reads all of the elements in the text file, and runs it through
    // the parsing method.
    public static StudentGrade[] readStudents() throws IOException {
        File readFile = new File("studentGrades.txt");
        Scanner scan = new Scanner(readFile);

        int info = 0;

        // 30 is the max number of students in a class.
        StudentGrade[] studentArr = new StudentGrade[30];
        while (scan.hasNext()) {
            String line = scan.nextLine();
            StudentGrade student = new StudentGrade("", "", 0, 0, 0, 0);
            studentArr[info] = student.parseStudentGrade(line);
            info = info + 1;
        }
        scan.close();
        return studentArr;
    }

    // ReviewStudents method reviews students in the array and provides the ID
    // number. The ID number is later utilized for other methods.
    public void ReviewStudents() throws IOException {
        StudentGrade[] reviewArray = readStudents();
        for (int r = 0; r < reviewArray.length; r++) {
            if (reviewArray[r] != null) { //
                System.out.println("Student " + r + ": " + reviewArray[r].firstName + " " + reviewArray[r].lastName
                        + "\nID number: " + reviewArray[r].IDnum);
            }
        }
    }

    // LinearSearch method allows the user to enter an ID number to search into the
    // array.
    public int LinearSearch() throws IOException {
        StudentGrade[] studentArr = readStudents();
        System.out.println("Type in the ID number that you would like to find: ");
        Scanner search = new Scanner(System.in);
        int val = (search.nextInt());

        for (int i = 0; i < studentArr.length; i++) {
            if (studentArr[i] != null) {
                if (val == studentArr[i].IDnum) {
                    System.out.print("Student ID number is at index " + i + ",");
                    System.out.println(" Student is " + studentArr[i].firstName + " " + studentArr[i].lastName + " "
                            + "(ID number " + studentArr[i].IDnum + ")");

                    return i;
                }
            }
        }
        System.out.println("No ID number found");
        return -1;
    }

    // BubbleSort method sorts through the test grades of all of the students and returns the numerical order.
    public StudentGrade[] BubbleSort() throws IOException {
        StudentGrade[] testGradesArr = readStudents();
        System.out.println("\nTest grades before sort: ");
        for (int q = 0; q < testGradesArr.length; q++) {
            if (testGradesArr[q] != null) {
                System.out.println(testGradesArr[q].firstName + " " + testGradesArr[q].lastName + ": "
                        + testGradesArr[q].testGrade);
            }
        }
        //Swaps out indexes with elements that are larger than the other.
        for (int a = 0; a < (testGradesArr.length - 1); a++) {

            for (int b = 0; b < (testGradesArr.length - 1); b++) {
                if (testGradesArr[b] != null && testGradesArr[b + 1] != null && testGradesArr[b].testGrade > testGradesArr[b + 1].testGrade) {
                    double swap = testGradesArr[b].testGrade;
                    testGradesArr[b].testGrade = testGradesArr[b + 1].testGrade;
                    testGradesArr[b + 1].testGrade = swap;
                    writeStudents(testGradesArr);
                }
            }
        }

        System.out.println("\nTest grades after sort: ");

        for (int after = 0; after < testGradesArr.length; after++) {
            if (testGradesArr[after] != null) {
                System.out.println(testGradesArr[after].firstName + " " + testGradesArr[after].lastName + ": " + testGradesArr[after].testGrade);
            }
        }
        return testGradesArr;
    }
    // AverageLetterGrade calculates the letter grade from the average classwork, quiz, and test grade.
    public void AverageLetterGrade() throws IOException {
        StudentGrade[] avgGradeArr = readStudents();
        System.out.println("Who's grade would you like to find?" + "\nEnter ID number of student: ");
        Scanner load = new Scanner(System.in);
        int amount = (load.nextInt());

        int length = 3;
        double sumGrade = 0;
        double average = 0;
        //100-93 = A, 92-90 = A-, 89-87 = B+, 86-83 = B, 82-80 = B-, 79-77 = C+, 76-73 = C, 72-70 = C-, 69-64 = D, below 64 = F
        // all of these grades are based off of the StudentVue gradebook.
        for (int avg = 0; avg < avgGradeArr.length; avg++) {
            if (avgGradeArr[avg] != null) {
                //calculating average grades of students 
                if (amount == avgGradeArr[avg].IDnum) {
                    sumGrade = avgGradeArr[avg].classworkGrade += avgGradeArr[avg].quizGrade += avgGradeArr[avg].testGrade;
                    average = sumGrade / length;
                    if (average > 93) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "A");
                    } else if (average > 90) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "A-");
                    } else if (average > 87) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "B+");
                    } else if (average > 83) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "B");
                    } else if (average > 80) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "B-");
                    } else if (average > 77) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "C+");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average > 73) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "C");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average > 70) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "C-");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average > 67) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "D+");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average > 64) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "D");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average >= 64) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "F");
                        System.out.println(" - This student qualifies for a retake.");
                    } else if (average < 64) {
                        System.out.println(avgGradeArr[avg].firstName + " " + avgGradeArr[avg].lastName
                                + "'s letter grade is: " + "F");
                        System.out.println(" - This student qualifies for a retake.");
                    }
                }
            }
        }
    }
    // AddStudent method allows the user to add another student to the array.
    // The maximum amount of students in a class is 30.
    public void AddStudent() throws IOException {
        StudentGrade[] addStudentArr = readStudents();
        StudentGrade[] addArray = new StudentGrade[addStudentArr.length + 1];
        Scanner userInput = new Scanner(System.in);

        for (int c = 0; c < addStudentArr.length; c++) {
            addArray[c] = addStudentArr[c];
        }

        System.out.println("What is the students first name?: ");
        String firstName = userInput.nextLine();

        System.out.println("What is the students last name?: ");
        String lastName = userInput.nextLine();

        System.out.println("What is the students ID number? (3 digits): ");
        int IDnum = userInput.nextInt();
        userInput.nextLine();
        //Checks if the ID number is in between 100-999
        for (int add = 0; add < addArray.length; add++) {
            if (addArray[add] != null) {
                if (IDnum > 999 || IDnum < 99 || IDnum == -1) {
                    System.out.println("Please enter a number with 3 digits.");
                    return;
                }
        // Checks if the student the user entered is already in the class
                if (IDnum == addArray[add].IDnum) {
                    System.out.println("You already have that student in the class.");
                    return;
                }
            }
        }

        System.out.println("What is the students overall classwork grade? (50-100): ");
        double classworkGrade = userInput.nextDouble();
        userInput.nextLine();
        //Checks if the grade that is entered is through 50-100
        for (int g = 0; g < addArray.length; g++) {
            if (addArray[g] != null) {
                if (classworkGrade > 100 || classworkGrade < 50 || classworkGrade < -1) {
                    System.out.println("Please enter valid grades.");
                    return;
                }
            }
        }

        System.out.println("What is the students overall quiz grade? (50-100): ");
        double quizGrade = userInput.nextDouble();
        userInput.nextLine();
        //Checks if the grade that is entered is through 50-100
        for (int qg = 0; qg < addArray.length; qg++) {
            if (addArray[qg] != null) {
                if (quizGrade > 100 || quizGrade < 50 || quizGrade < -1) {
                    System.out.println("Please enter valid grades.");
                    return;
                }
            }
        }

        System.out.println("What is the students overall testGrade? (50-100): ");
        double testGrade = userInput.nextDouble();
        userInput.nextLine();
        //Checks if the grade that is entered is through 50-100
        for (int tg = 0; tg < addArray.length; tg++) {
            if (addArray[tg] != null) {
                if (testGrade > 100 || testGrade < 50 || testGrade < -1) {
                    System.out.println("Please enter valid grades.");
                    return;
                }
            }
        }
        // Adds the new student to the array.
        addArray[addStudentArr.length] = new StudentGrade(firstName, lastName, IDnum, classworkGrade, quizGrade,
                testGrade);
        writeStudents(addArray);

    }

    // Quits the program.
    public void quit() {
        System.out.println("Exiting program...");
        System.exit(0);
    }
    // Allows the user to continue back to the menu.
    public void pause() {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("\nPress enter continue");
        keyIn.nextLine();
    }
}
