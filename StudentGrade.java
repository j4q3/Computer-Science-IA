//StudentGrade class 
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

//parseStudentGrades parses values from the text file and turns them from strings back into what they originally were, in this case integers and doubles.
   public StudentGrade parseStudentGrade(String line) {
       String student;
       //first name
       int location = 0;
       int start = 0;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       String fName = student;



       //last name
       start = location + 1;
       location = line.indexOf(",", start);
       String lName = line.substring(start, location);
  


       //ID number
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       int ID = Integer.parseInt(student);
      


       //Classwork Grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       double cw = Double.parseDouble(student);
       


       //quiz grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start, location);
       double qg = Double.parseDouble(student);
    


       //test grade
       start = location + 1;
       location = line.indexOf(",", start);
       student = line.substring(start);
       double tg = Double.parseDouble(student);

       
       StudentGrade object = new StudentGrade(fName, lName, ID, cw, qg, tg);
       return object;
   }
   
   // State method combines all of the elements into a variable.
   public String state() {
       String student = (firstName + "," + lastName + "," + IDnum + "," + classworkGrade + "," + quizGrade + "," + testGrade);
       return student;
   }

}
