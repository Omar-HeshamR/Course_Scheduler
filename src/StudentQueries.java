/**
 * @author Omar
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {
    private static Connection connection;
    private static ResultSet resultSet;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement theStudent;
    
    public static void addStudent(StudentEntry student){
        connection = DBconnection.getConnection();           
        try{
            theStudent = connection.prepareStatement("insert into app.student (studentid, firstname, lastname) values (?,?,?)");
            theStudent.setString(1, student.getStudentID());
            theStudent.setString(2, student.getFirstName());
            theStudent.setString(3, student.getLastName());
            theStudent.executeUpdate();
            
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<StudentEntry> getAllStudents() {
        connection = DBconnection.getConnection();           
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        try{
            theStudent = connection.prepareStatement("select studentid, firstname, lastname from app.student ");      
            resultSet = theStudent.executeQuery();
         
            while(resultSet.next())
            {
                students.add(new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3))); 
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static StudentEntry getStudent(String studentID) {
    connection = DBconnection.getConnection();    
    StudentEntry studententry = new StudentEntry("","","");
    try{
       theStudent = connection.prepareStatement("select firstname, lastname from app.student where studentID = ? "); 
       theStudent.setString(1, studentID);
       resultSet = theStudent.executeQuery();
       studententry = new StudentEntry(studentID, resultSet.getString(1), resultSet.getString(2));
    }catch(SQLException sqlException){
       sqlException.printStackTrace();   
    }
    return studententry;
    } 
      
     public static void dropStudent(String studentID) {
        connection = DBconnection.getConnection();           
        try{
            theStudent = connection.prepareStatement("delete from app.student where studentid=?");
            theStudent.setString(1, studentID);            
            theStudent.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}

