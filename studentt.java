package javac CourseRegistrationSystem.java;

public class studentt {
    import java.util.ArrayList;
import java.util.List;


    private String studentId;
    private String name;
    private List<String> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public List<String> getRegisteredCourses() { return registeredCourses; }

    public void addCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void removeCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    @Override
    public String toString() {
        return studentId + ": " + name + " - Registered courses: " + registeredCourses;
    }
}

    
