package AcadEase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, student_name, department, year_of_study) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getYearOfStudy());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    public void viewAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Year: " + rs.getInt("year_of_study"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("No students found.");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing students: " + e.getMessage());
        }
    }

    public void searchStudent(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Student ID: " + rs.getInt("student_id"));
                    System.out.println("Name: " + rs.getString("student_name"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Year: " + rs.getInt("year_of_study"));
                } else {
                    System.out.println("Student not found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

    public void updateStudent(int studentId, String studentName, String department, int yearOfStudy) {
        String sql = "UPDATE students SET student_name = ?, department = ?, year_of_study = ? WHERE student_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentName);
            ps.setString(2, department);
            ps.setInt(3, yearOfStudy);
            ps.setInt(4, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            System.out.println("The student may have marks linked to their record.");
        }
    }

}
