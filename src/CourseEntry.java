
/**
 * @author Omar
 */

public class CourseEntry {
    private String semester;
    private String courseCode;
    private String courseDescription;
    private int seats;

    public CourseEntry(String semester, String courseCode, String courseDescription, int seats) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.seats = seats;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public int getSeats() {
        return seats;
    }
    
}
