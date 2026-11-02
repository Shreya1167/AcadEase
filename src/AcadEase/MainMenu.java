package AcadEase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        MarksDAO marksDAO = new MarksDAO();
        
        ArrayList<String> students = new ArrayList<>();
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<String> marksList = new ArrayList<>();
        int choice = 0;

        while (choice != 11) {

            System.out.println("\n==============================================");
            System.out.println("                  ACADEASE ");
            System.out.println("==============================================");
            System.out.println("1. Student Management");
            System.out.println("2. Subject Management");
            System.out.println("3. Marks Management");
            System.out.println("4. Calculate Student Result");
            System.out.println("5. View Student Academic Report");
            System.out.println("6. Search and Filter Records");
            System.out.println("7. Class Performance Statistics");
            System.out.println("8. Find Subject Topper");
            System.out.println("9. Semester-wise Progress Tracker");
            System.out.println("10. Low-Marks Alert");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    int studentChoice = 0;

                    while (studentChoice != 6) {

                        System.out.println("\n--- STUDENT MANAGEMENT ---");
                        System.out.println("1. Add Student");
                        System.out.println("2. View All Students");
                        System.out.println("3. Search Student");
                        System.out.println("4. Update Student");
                        System.out.println("5. Delete Student");
                        System.out.println("6. Back to Main Menu");

                        System.out.print("Enter your choice: ");
                        studentChoice = sc.nextInt();

                        switch (studentChoice) {
                        case 1:
                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Department: ");
                            String department = sc.nextLine();

                            System.out.print("Enter Year: ");
                            int year = sc.nextInt();

                            Student student = new Student(id, name, department, year);

                            if (studentDAO.addStudent(student)) {
                                System.out.println("\nStudent added successfully!");
                            }

                            break;

                        case 2:
                        	studentDAO.viewAllStudents();
                        	break;

                            case 3:
                            	System.out.print("Enter Student ID to search: ");
                                int searchId = sc.nextInt();

                                studentDAO.searchStudent(searchId);
                                break;
                            case 4:
                            	 System.out.print("Enter Student ID to update: ");
                            	    int updateId = sc.nextInt();
                            	    sc.nextLine();

                            	    System.out.print("Enter new Student Name: ");
                            	    String newName = sc.nextLine();

                            	    System.out.print("Enter new Department: ");
                            	    String newDepartment = sc.nextLine();

                            	    System.out.print("Enter new Year: ");
                            	    int newYear = sc.nextInt();

                            	    studentDAO.updateStudent(updateId, newName, newDepartment, newYear);

                            	    break;
                            case 5:
                            	System.out.print("Enter Student ID to delete: ");
                                int deleteId = sc.nextInt();

                                studentDAO.deleteStudent(deleteId);

                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice! Enter a number from 1 to 6.");
                        }
                    }
                    break;

                case 2:
                	int subjectChoice = 0;

                    while (subjectChoice != 6) {
                        System.out.println("\n--- Subject Management ---");
                        System.out.println("1. Add Subject");
                        System.out.println("2. View All Subjects");
                        System.out.println("3. Search Subject");
                        System.out.println("4. Update Subject");
                        System.out.println("5. Delete Subject");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        subjectChoice = sc.nextInt();
                        sc.nextLine();

                        switch (subjectChoice) {
                            case 1:
                            	System.out.print("Enter Subject ID: ");
                                int subjectId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Subject Name: ");
                                String subjectName = sc.nextLine();

                                System.out.print("Enter Subject Code: ");
                                String subjectCode = sc.nextLine();

                                System.out.print("Enter Credits: ");
                                int credits = sc.nextInt();
                                sc.nextLine();

                                Subject subject = new Subject(subjectId, subjectName, subjectCode, credits);

                                if (subjectDAO.addSubject(subject)) {
                                    System.out.println("Subject added successfully!");
                                }

                                break;
                            case 2:
                            	 subjectDAO.viewAllSubjects();
                            	    break;
                            case 3:
                            	System.out.print("Enter Subject ID to search: ");
                                int searchId = sc.nextInt();
                                sc.nextLine();

                                subjectDAO.searchSubject(searchId);

                                break;
                            case 4:
                            	System.out.print("Enter Subject ID to update: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter new Subject Name: ");
                                String newSubjectName = sc.nextLine();

                                System.out.print("Enter new Subject Code: ");
                                String newSubjectCode = sc.nextLine();

                                System.out.print("Enter new Credits: ");
                                int newCredits = sc.nextInt();
                                sc.nextLine();

                                subjectDAO.updateSubject(updateId, newSubjectName, newSubjectCode, newCredits);

                                break;
                            case 5:
                            	System.out.print("Enter Subject ID to delete: ");
                                int deleteId = sc.nextInt();
                                sc.nextLine();

                                subjectDAO.deleteSubject(deleteId);

                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 3:
                	int marksChoice = 0;

                    while (marksChoice != 6) {
                        System.out.println("\n--- Marks Management ---");
                        System.out.println("1. Add Marks");
                        System.out.println("2. View All Marks");
                        System.out.println("3. Search Marks");
                        System.out.println("4. Update Marks");
                        System.out.println("5. Delete Marks");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");

                        marksChoice = sc.nextInt();
                        sc.nextLine();

                        switch (marksChoice) {
                            case 1:
                            	System.out.print("Enter Student ID: ");
                                int marksStudentId = sc.nextInt();

                                System.out.print("Enter Subject ID: ");
                                int marksSubjectId = sc.nextInt();

                                System.out.print("Enter Semester Number: ");
                                int semester = sc.nextInt();

                                System.out.print("Enter Marks out of 100: ");
                                int score = sc.nextInt();
                                sc.nextLine();

                                if (score < 0 || score > 100) {
                                    System.out.println("Invalid marks. Enter a value from 0 to 100.");
                                    break;
                                }

                                Marks marks = new Marks(marksStudentId, marksSubjectId, score, semester);

                                if (marksDAO.addMarks(marks)) {
                                    System.out.println("Marks added successfully!");
                                }

                                break;
                            case 2:
                            	marksDAO.viewAllMarks();
                                break;
                            case 3:
                            	System.out.print("Enter Student ID to search: ");
                                int searchStudentId = sc.nextInt();

                                marksDAO.searchMarks(searchStudentId);

                                break;
                            case 4:
                            	System.out.print("Enter Student ID: ");
                                int updateStudentId = sc.nextInt();

                                System.out.print("Enter Subject ID: ");
                                int updateSubjectId = sc.nextInt();

                                System.out.print("Enter Semester: ");
                                int updateSemester = sc.nextInt();

                                System.out.print("Enter new Marks out of 100: ");
                                int newScore = sc.nextInt();

                                if (newScore < 0 || newScore > 100) {
                                    System.out.println("Invalid marks. Enter a value from 0 to 100.");
                                } else {
                                    marksDAO.updateMarks(updateStudentId, updateSubjectId, updateSemester, newScore);
                                }

                                break;
                            case 5:
                            	System.out.print("Enter Student ID: ");
                                int deleteStudentId = sc.nextInt();

                                System.out.print("Enter Subject ID: ");
                                int deleteSubjectId = sc.nextInt();

                                System.out.print("Enter Semester: ");
                                int deleteSemester = sc.nextInt();

                                marksDAO.deleteMarks(deleteStudentId, deleteSubjectId, deleteSemester);

                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 4:
                	System.out.print("Enter Student ID: ");
                	int resultStudentId = sc.nextInt();

                	int totalMarks = 0;
                	int subjectCount = 0;

                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT marks FROM marks WHERE student_id = ?";
                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ps.setInt(1, resultStudentId);

                	    ResultSet rs = ps.executeQuery();

                	    while (rs.next()) {
                	        totalMarks += rs.getInt("marks");
                	        subjectCount++;
                	    }

                	    if (subjectCount == 0) {
                	        System.out.println("No marks records found for this student.");
                	    } else {
                	        double percentage = (double) totalMarks / subjectCount;
                	        String grade;

                	        if (percentage >= 90) {
                	            grade = "A+";
                	        } else if (percentage >= 80) {
                	            grade = "A";
                	        } else if (percentage >= 70) {
                	            grade = "B";
                	        } else if (percentage >= 60) {
                	            grade = "C";
                	        } else if (percentage >= 50) {
                	            grade = "D";
                	        } else {
                	            grade = "F";
                	        }

                	        System.out.println("\n--- Student Result ---");
                	        System.out.println("Student ID: " + resultStudentId);
                	        System.out.println("Total Marks: " + totalMarks);
                	        System.out.println("Subjects Counted: " + subjectCount);
                	        System.out.printf("Percentage: %.2f%%%n", percentage);
                	        System.out.println("Grade: " + grade);
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error calculating result: " + e.getMessage());
                	}

                	break;
                case 5:
                	System.out.print("Enter Student ID: ");
                	int reportStudentId = sc.nextInt();

                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String studentSql = "SELECT * FROM students WHERE student_id = ?";
                	    PreparedStatement studentPs = con.prepareStatement(studentSql);
                	    studentPs.setInt(1, reportStudentId);

                	    ResultSet studentRs = studentPs.executeQuery();

                	    if (studentRs.next()) {
                	        System.out.println("\n--- Student Academic Report ---");
                	        System.out.println("Student ID: " + studentRs.getInt("student_id"));
                	        System.out.println("Name: " + studentRs.getString("student_name"));
                	        System.out.println("Department: " + studentRs.getString("department"));
                	        System.out.println("Year: " + studentRs.getInt("year_of_study"));

                	        int reportTotal = 0;
                	        int reportCount = 0;

                	        System.out.println("\n--- Subject-wise Marks ---");

                	        String marksSql =
                	            "SELECT s.subject_name, m.marks, m.semester " +
                	            "FROM marks m JOIN subjects s ON m.subject_id = s.subject_id " +
                	            "WHERE m.student_id = ? ORDER BY m.semester, s.subject_name";

                	        PreparedStatement marksPs = con.prepareStatement(marksSql);
                	        marksPs.setInt(1, reportStudentId);

                	        ResultSet marksRs = marksPs.executeQuery();

                	        while (marksRs.next()) {
                	            System.out.println(
                	                marksRs.getString("subject_name") +
                	                " (Semester " + marksRs.getInt("semester") + "): " +
                	                marksRs.getInt("marks")
                	            );

                	            reportTotal += marksRs.getInt("marks");
                	            reportCount++;
                	        }

                	        if (reportCount > 0) {
                	            double reportPercentage = (double) reportTotal / reportCount;
                	            String reportGrade;

                	            if (reportPercentage >= 90) {
                	                reportGrade = "A+";
                	            } else if (reportPercentage >= 80) {
                	                reportGrade = "A";
                	            } else if (reportPercentage >= 70) {
                	                reportGrade = "B";
                	            } else if (reportPercentage >= 60) {
                	                reportGrade = "C";
                	            } else if (reportPercentage >= 50) {
                	                reportGrade = "D";
                	            } else {
                	                reportGrade = "F";
                	            }

                	            System.out.println("\nTotal Marks: " + reportTotal);
                	            System.out.println("Subjects Counted: " + reportCount);
                	            System.out.printf("Percentage: %.2f%%%n", reportPercentage);
                	            System.out.println("Grade: " + reportGrade);
                	        } else {
                	            System.out.println("No marks records found for this student.");
                	        }

                	        marksRs.close();
                	        marksPs.close();

                	    } else {
                	        System.out.println("Student not found.");
                	    }

                	    studentRs.close();
                	    studentPs.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error generating report: " + e.getMessage());
                	}

                	break;

                case 6:
                	System.out.print("Enter Student ID to search: ");
                	int filterStudentId = sc.nextInt();

                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT * FROM students WHERE student_id = ?";
                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ps.setInt(1, filterStudentId);

                	    ResultSet rs = ps.executeQuery();

                	    if (rs.next()) {
                	        System.out.println("\n--- Student Found ---");
                	        System.out.println("Student ID: " + rs.getInt("student_id"));
                	        System.out.println("Name: " + rs.getString("student_name"));
                	        System.out.println("Department: " + rs.getString("department"));
                	        System.out.println("Year: " + rs.getInt("year_of_study"));
                	    } else {
                	        System.out.println("Student not found.");
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error searching student: " + e.getMessage());
                	}

                	break;

                case 7:
                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT COUNT(*) AS total_records, "
                	               + "SUM(marks) AS total_marks, "
                	               + "AVG(marks) AS average_marks FROM marks";

                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ResultSet rs = ps.executeQuery();

                	    rs.next();

                	    int totalRecords = rs.getInt("total_records");
                	    int classTotal = rs.getInt("total_marks");
                	    double classAverage = rs.getDouble("average_marks");

                	    System.out.println("\n--- Class Performance Statistics ---");

                	    if (totalRecords == 0) {
                	        System.out.println("No marks records available.");
                	    } else {
                	        System.out.println("Total Marks Records: " + totalRecords);
                	        System.out.println("Sum of Marks: " + classTotal);
                	        System.out.printf("Average Marks: %.2f%n", classAverage);
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error calculating class statistics: " + e.getMessage());
                	}

                	break;

                case 8:
                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT s.subject_id, s.subject_name, "
                	               + "m.student_id, st.student_name, m.marks "
                	               + "FROM marks m "
                	               + "JOIN subjects s ON m.subject_id = s.subject_id "
                	               + "JOIN students st ON m.student_id = st.student_id "
                	               + "WHERE m.marks = ("
                	               + "SELECT MAX(m2.marks) FROM marks m2 "
                	               + "WHERE m2.subject_id = m.subject_id) "
                	               + "ORDER BY s.subject_name";

                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ResultSet rs = ps.executeQuery();

                	    System.out.println("\n--- Subject Toppers ---");

                	    boolean found = false;
                	    int previousSubjectId = -1;

                	    while (rs.next()) {
                	        found = true;

                	        int subjectId = rs.getInt("subject_id");

                	        if (subjectId != previousSubjectId) {
                	            System.out.println("\nSubject: " + rs.getString("subject_name"));
                	            System.out.println("Highest Marks: " + rs.getInt("marks"));
                	            System.out.println("Topper(s):");
                	            previousSubjectId = subjectId;
                	        }

                	        System.out.println("Student ID: " + rs.getInt("student_id")
                	                + ", Name: " + rs.getString("student_name"));
                	    }

                	    if (!found) {
                	        System.out.println("No marks records available.");
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error finding subject toppers: " + e.getMessage());
                	}

                	break;

                case 9:
                	System.out.print("Enter Student ID: ");
                	int progressStudentId = sc.nextInt();

                	System.out.print("Enter Semester Number: ");
                	int progressSemester = sc.nextInt();
                	sc.nextLine();

                	int progressTotal = 0;
                	int progressCount = 0;

                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT s.subject_name, m.marks "
                	               + "FROM marks m "
                	               + "JOIN subjects s ON m.subject_id = s.subject_id "
                	               + "WHERE m.student_id = ? AND m.semester = ? "
                	               + "ORDER BY s.subject_name";

                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ps.setInt(1, progressStudentId);
                	    ps.setInt(2, progressSemester);

                	    ResultSet rs = ps.executeQuery();

                	    System.out.println("\nSemester Progress Report");

                	    while (rs.next()) {
                	        String subjectName = rs.getString("subject_name");
                	        int score = rs.getInt("marks");

                	        System.out.println(subjectName + " : " + score);

                	        progressTotal += score;
                	        progressCount++;
                	    }

                	    if (progressCount > 0) {
                	        double progressAverage = (double) progressTotal / progressCount;

                	        System.out.println("Total Marks: " + progressTotal);
                	        System.out.printf("Average: %.2f%n", progressAverage);

                	        if (progressAverage >= 90)
                	            System.out.println("Grade: A+");
                	        else if (progressAverage >= 80)
                	            System.out.println("Grade: A");
                	        else if (progressAverage >= 70)
                	            System.out.println("Grade: B");
                	        else if (progressAverage >= 60)
                	            System.out.println("Grade: C");
                	        else if (progressAverage >= 50)
                	            System.out.println("Grade: D");
                	        else
                	            System.out.println("Grade: F");
                	    } else {
                	        System.out.println("No marks found for this student and semester.");
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error tracking semester progress: " + e.getMessage());
                	}

                	break;

                case 10:
                	System.out.print("Enter Student ID: ");
                	int alertStudentId = sc.nextInt();
                	sc.nextLine();

                	boolean alertFound = false;

                	System.out.println("\nLOW-MARKS ALERT");

                	try {
                	    Connection con = DatabaseConnection.getConnection();

                	    String sql = "SELECT s.subject_name, m.marks "
                	               + "FROM marks m "
                	               + "JOIN subjects s ON m.subject_id = s.subject_id "
                	               + "WHERE m.student_id = ? AND m.marks < 50 "
                	               + "ORDER BY s.subject_name";

                	    PreparedStatement ps = con.prepareStatement(sql);
                	    ps.setInt(1, alertStudentId);

                	    ResultSet rs = ps.executeQuery();

                	    while (rs.next()) {
                	        String subjectName = rs.getString("subject_name");
                	        int score = rs.getInt("marks");

                	        System.out.println(subjectName + ": " + score
                	                + " - Needs Improvement");

                	        alertFound = true;
                	    }

                	    if (!alertFound) {
                	        System.out.println("No low marks found for this student.");
                	    }

                	    rs.close();
                	    ps.close();
                	    con.close();

                	} catch (Exception e) {
                	    System.out.println("Error checking low marks: " + e.getMessage());
                	}

                	break;

                case 11:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Enter a number from 1 to 11.");
            }
        }

        sc.close();
    }
}







