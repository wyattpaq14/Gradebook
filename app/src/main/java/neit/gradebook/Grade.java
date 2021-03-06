package neit.gradebook;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by 001382793 on 5/28/2017.
 */

public class Grade {

    public double studentGrade;
    public String studentFirstName;
    public String studentLastName;
    public String assignemnt;
    public String studentID;


    public Grade(String id, String firstName, String lastName, double grade, String assign) {
        studentGrade = grade;
        studentFirstName = firstName;
        studentLastName = lastName;
        studentID = id;
        assignemnt = assign;

    }


    //https://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android

    public static String[] readFromFile(Context context) {
        String[] fileString = new String[900];
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                int iterationCcount = 0;
                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                    fileString[iterationCcount] = receiveString;
                    iterationCcount++;
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return fileString;
    }

    public void writeToFile(Context context) {
        try {
            String data = studentID + " " + studentFirstName + " " + studentLastName + " " + studentGrade + " " + assignemnt + "\n";
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();

            Log.i("NOTICE", "File Wrote");

        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

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
