import java.sql.Timestamp;

/**
 * @author Omar
 */

public class ScheduleEntry {
    public String semester;
    public String courseCode;
    public String studentID;
    public String status;
    public Timestamp timeStamp;

    public ScheduleEntry(String semester, String studentID, String courseCode, String status, Timestamp timeStamp) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.studentID = studentID;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    
}
