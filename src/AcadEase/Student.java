package AcadEase;

public class Student {
    private int studentId;
    private String studentName;
    private String department;
    private int yearOfStudy;

    public Student(int studentId, String studentName, String department, int yearOfStudy) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
}
