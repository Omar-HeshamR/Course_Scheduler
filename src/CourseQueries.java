/**
 * @author Omar
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseQueries {
    private static Connection connection;
    private static ResultSet resultSet;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement myCourse;
    
    public static ArrayList<CourseEntry> getAllCourses(String semester) {
        connection = DBconnection.getConnection();        
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
        try{
            myCourse = connection.prepareStatement("select semester, coursecode, description, seats from app.course where semester = ?");
            myCourse.setString(1, semester);
            resultSet = myCourse.executeQuery();
             while(resultSet.next())
            {
              courses.add(new CourseEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();    
        }
        return courses;
    }
    
    public static void addCourse(CourseEntry course){
        connection = DBconnection.getConnection();
         try
        {
            myCourse = connection.prepareStatement("insert into app.course (semester, coursecode, description, seats) values (?,?,?,?)");  
            myCourse.setString(1, course.getSemester());
            myCourse.setString(2, course.getCourseCode());
            myCourse.setString(3, course.getCourseDescription());
            myCourse.setInt(4, course.getSeats());
            myCourse.executeUpdate();
            
        }catch(SQLException sqlException) {
           sqlException.printStackTrace();
        }
    }
        
    public static ArrayList<String> getAllCourseCodes(String semester) {
        connection = DBconnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try {
            myCourse = connection.prepareStatement("select semester, coursecode from app.course where semester = ?");
            myCourse.setString(1, semester);
            resultSet = myCourse.executeQuery();
            while(resultSet.next()) {
                courseCodes.add(resultSet.getString(2)); //Gets courseCode
            }    
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
    
    public static int getCourseSeats(String semester, String courseCode) {
         connection = DBconnection.getConnection();        
         int seats = 0;
         try{
            myCourse = connection.prepareStatement("select seats from app.course where semester = ? and courseCode = ?");
            myCourse.setString(1, semester);
            myCourse.setString(2, courseCode);
            resultSet = myCourse.executeQuery();
            while (resultSet.next()) {
                seats = resultSet.getInt(1);
            }   
         }catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return seats;           
    }

    public static void lowerSeats(String semester,String courseCode){ // HELPER
        connection = DBconnection.getConnection();        
        int seats = getCourseSeats(semester,courseCode) ;
        try{
            myCourse = connection.prepareStatement("update app.course set seats = ? where semester = ? and coursecode = ?");
            myCourse.setInt(1, seats - 1);
            myCourse.setString(2, semester);
            myCourse.setString(3, courseCode);
            myCourse.executeUpdate();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();    
        }
    }
    
    public static void increaseSeats(String semester,String courseCode){ // HELPER
        connection = DBconnection.getConnection();        
        int seats = getCourseSeats(semester,courseCode) ;
        try{
            myCourse = connection.prepareStatement("update app.course set seats = ? where semester = ? and coursecode = ?");
            myCourse.setInt(1, seats + 1);
            myCourse.setString(2, semester);
            myCourse.setString(3, courseCode);
            myCourse.executeUpdate();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();    
        }
    }
    
    public static void dropCourse(String semester, String courseCode){
        connection = DBconnection.getConnection();        
        try{
            myCourse = connection.prepareStatement("delete from app.course where semester = ? and coursecode = ?");
            myCourse.setString(1, semester);
            myCourse.setString(2, courseCode);
            myCourse.executeUpdate();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();    
        }
    }
}
