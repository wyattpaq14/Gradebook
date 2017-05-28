package neit.gradebook;

/**
 * Created by 001382793 on 5/28/2017.
 */

public class Grade {

    public double studentGrade;
    public String studentFirstName;
    public String studentLastName;
    public String studentID;


    public Grade(String id, String firstName, String lastName, double grade) {
        studentGrade = grade;
        studentFirstName = firstName;
        studentLastName = lastName;
        studentID = id;

    }


    //https://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android


    public void print() {


        try {
            File file = new File("C:/file.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.println("Grade: " + studentGrade);
            writer.println("First Name: " + studentFirstName);
            writer.println("Last Name: " + studentLastName);
            writer.println("Student ID: " + studentID);
            writer.println(" ");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }


    }


}
