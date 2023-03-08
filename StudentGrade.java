public class StudentGrade {
   String firstName = "";
   String lastName = "";
   int IDnum = 0;
   double classworkGrade = 0.0;
   double quizGrade = 0.0;
   double testGrade = 0.0;


   public StudentGrade(String firstName, String lastName, int IDnum, double classworkGrade, double quizGrade, double testGrade) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.IDnum = IDnum;
       this.classworkGrade = classworkGrade;
       this.quizGrade = quizGrade;
       this.testGrade = testGrade;
   }


   public StudentGrade(String line) {
       String student;
       //first name
       int location = 0;
       int start = 0;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       String fName = student;
       System.out.println(firstName);


       //last name
       start = location + 1;
       location = line.indexOf(",", start);
       String lName = line.substring(start, location);
       System.out.println(lastName);


       //ID number
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       int ID = Integer.parseInt(student);
       System.out.println(IDnum);


       //Classwork Grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       double cw = Double.parseDouble(student);
       System.out.println(classworkGrade);


       //quiz grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       double qg = Double.parseDouble(student);
       System.out.println(quizGrade);


       //test grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start);
       double tg = Double.parseDouble(student);
       System.out.print(testGrade + "\n");


       //student_grade(fName, lName, ID, cw, qg, tg);
   }




   public String state() {
       String student = (firstName + "," + lastName + "," + IDnum + "," + classworkGrade + "," + quizGrade + "," + testGrade);


       return student;
   }
//    public String Label() {
//        String labels = ("Student First Name: " + firstName + "," +
//                " Last Name: " + lastName + "," +
//                " ID number: " + IDnum + "," +
//                " Classwork Grade: " + classworkGrade + "," +
//                " Quiz Grade: " + quizGrade + "," +
//                " Test Grade: " + testGrade);
//        return labels;
//    }


}
