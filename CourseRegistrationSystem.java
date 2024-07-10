package javac CourseRegistrationSystem.java;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private Map<String, Course> courses;
    private Map<String, Student> students;

    public CourseRegistrationSystem() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public void listCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    public void registerCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code");
            return;
        }

        if (course.getAvailableSlots() > 0) {
            student.addCourse(courseCode);
            course.setAvailableSlots(course.getAvailableSlots() - 1);
            System.out.println("Student " + student.getName() + " registered for " + course.getTitle());
        } else {
            System.out.println("No available slots for this course");
        }
    }

    public void dropCourse(String studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course code");
            return;
        }

        if (student.getRegisteredCourses().contains(courseCode)) {
            student.removeCourse(courseCode);
            course.setAvailableSlots(course.getAvailableSlots() + 1);
            System.out.println("Student " + student.getName() + " dropped " + course.getTitle());
        } else {
            System.out.println("Student " + student.getName() + " is not registered for " + course.getTitle());
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            System.out.println("Course Registration System Menu:");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. List Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.next();
                    registerCourse(studentId, courseCode);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.next();
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.next();
                    dropCourse(studentId, courseCode);
                    break;
                case 4:
                    listStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public void listStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Adding some sample courses
        system.addCourse(new Course("CS101", "Introduction to Computer Science", "Basics of CS", 30, "MWF 10-11AM"));
        system.addCourse(new Course("MATH101", "Calculus I", "Introduction to Calculus", 25, "TTh 9-10:30AM"));

        // Adding some sample students
        system.addStudent(new Student("S001", "Alice"));
        system.addStudent(new Student("S002", "Bob"));

        system.displayMenu();
    }
}


