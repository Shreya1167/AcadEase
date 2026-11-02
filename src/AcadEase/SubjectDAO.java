package AcadEase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {

    public boolean addSubject(Subject subject) {
        String sql = "INSERT INTO subjects (subject_id, subject_name, subject_code, credits) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subject.getSubjectId());
            ps.setString(2, subject.getSubjectName());
            ps.setString(3, subject.getSubjectCode());
            ps.setInt(4, subject.getCredits());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding subject: " + e.getMessage());
            return false;
        }
    }
    public void viewAllSubjects() {
        String sql = "SELECT * FROM subjects";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Subject ID: " + rs.getInt("subject_id"));
                System.out.println("Subject Name: " + rs.getString("subject_name"));
                System.out.println("Subject Code: " + rs.getString("subject_code"));
                System.out.println("Credits: " + rs.getInt("credits"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("No subjects found.");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing subjects: " + e.getMessage());
        }
    }
    public void searchSubject(int subjectId) {
        String sql = "SELECT * FROM subjects WHERE subject_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subjectId);

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Subject ID: " + rs.getInt("subject_id"));
                    System.out.println("Subject Name: " + rs.getString("subject_name"));
                    System.out.println("Subject Code: " + rs.getString("subject_code"));
                    System.out.println("Credits: " + rs.getInt("credits"));
                } else {
                    System.out.println("Subject not found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching subject: " + e.getMessage());
        }
    }
    public void updateSubject(int subjectId, String subjectName, String subjectCode, int credits) {
        String sql = "UPDATE subjects SET subject_name = ?, subject_code = ?, credits = ? WHERE subject_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, subjectName);
            ps.setString(2, subjectCode);
            ps.setInt(3, credits);
            ps.setInt(4, subjectId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject updated successfully!");
            } else {
                System.out.println("Subject not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating subject: " + e.getMessage());
        }
    }
    public void deleteSubject(int subjectId) {
        String sql = "DELETE FROM subjects WHERE subject_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subjectId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject deleted successfully!");
            } else {
                System.out.println("Subject not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting subject: " + e.getMessage());
            System.out.println("This subject may have marks linked to it.");
        }
    }
}

