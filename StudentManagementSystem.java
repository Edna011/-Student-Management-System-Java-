
import java.util.ArrayList;
import java.util.List;

// Course Class
class Course {
    private String courseID;
    private String courseName;
    private int credits;
    private String grade; // Letter Grade (A, B, C, etc.)

    // Constructor
    public Course(String courseID, String courseName, int credits, String grade) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    // Getters
    public String getCourseID() { return courseID; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getGrade() { return grade; }

    // Convert Letter Grade to Numeric Value
    public double getGradePoints() {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0; 
        }
    }

    // Display course info
    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseID + ", Name: " + courseName + 
                           ", Credits: " + credits + ", Grade: " + grade);
    }
}

// Student Class
class Student {
    private String studentID;
    private String name;
    private int age;
    private List<Course> coursesEnrolled;
    private double GPA;

    // Constructor
    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.coursesEnrolled = new ArrayList<>();
        this.GPA = 0.0;
    }

    // Getters
    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGPA() { return GPA; }

    // Method to add a course
    public void addCourse(Course course) {
        coursesEnrolled.add(course);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    // Method to calculate GPA
    public void calculateGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : coursesEnrolled) {
            totalGradePoints += course.getGradePoints() * course.getCredits();
            totalCredits += course.getCredits();
        }

        this.GPA = (totalCredits == 0) ? 0.0 : totalGradePoints / totalCredits;
    }

    // Display Student Info
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentID + ", Name: " + name + 
                           ", Age: " + age + ", GPA: " + String.format("%.2f", GPA));
        System.out.println("Courses Enrolled:");
        for (Course course : coursesEnrolled) {
            course.displayCourseInfo();
        }
    }
}

// Main Class
public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create student
        Student student = new Student("PU/CS/2022/011", "Edna Erica Boateng", 18);

        // Create courses with grades
        Course course1 = new Course("CS102", "Java Programming", 3, "A");
        Course course2 = new Course("MATH101", "Calculus", 3, "B");
        Course course3 = new Course("BIT101, "Accounting", 3, "A");

        // Enroll student in courses
        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);

        // Calculate GPA
        student.calculateGPA();

        // Display student info
        student.displayStudentInfo();
    }
}
