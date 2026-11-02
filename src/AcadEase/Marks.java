package AcadEase;

public class Marks {

    private int markId;
    private int studentId;
    private int subjectId;
    private int marks;
    private int semester;

    // Constructor with 5 arguments
    public Marks(int markId, int studentId, int subjectId, int marks, int semester) {
        this.markId = markId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
        this.semester = semester;
    }

    // Constructor with 4 arguments
    public Marks(int studentId, int subjectId, int marks, int semester) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.marks = marks;
        this.semester = semester;
    }

    public int getMarkId() {
        return markId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getMarks() {
        return marks;
    }

    public int getSemester() {
        return semester;
    }
}