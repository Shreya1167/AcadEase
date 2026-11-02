package AcadEase;


public class Subject {
    private int subjectId;
    private String subjectName;
    private String subjectCode;
    private int credits;

    public Subject(int subjectId, String subjectName, String subjectCode, int credits) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.credits = credits;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public int getCredits() {
        return credits;
    }
}
