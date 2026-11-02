package AcadEase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksDAO {

	    public boolean addMarks(Marks marks) {
	        String sql = "INSERT INTO marks (student_id, subject_id, marks, semester) VALUES (?, ?, ?, ?)";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, marks.getStudentId());
	            ps.setInt(2, marks.getSubjectId());
	            ps.setInt(3, marks.getMarks());
	            ps.setInt(4, marks.getSemester());

	            ps.executeUpdate();
	            return true;

	        } catch (SQLException e) {
	            System.out.println("Error adding marks: " + e.getMessage());
	            return false;
	        }
	    }
	    public void viewAllMarks() {
	        String sql = "SELECT * FROM marks";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             java.sql.ResultSet rs = ps.executeQuery()) {

	            boolean found = false;

	            while (rs.next()) {
	                found = true;

	                System.out.println("Mark ID: " + rs.getInt("mark_id"));
	                System.out.println("Student ID: " + rs.getInt("student_id"));
	                System.out.println("Subject ID: " + rs.getInt("subject_id"));
	                System.out.println("Marks: " + rs.getInt("marks"));
	                System.out.println("Semester: " + rs.getInt("semester"));
	                System.out.println("-------------------------");
	            }

	            if (!found) {
	                System.out.println("No marks found.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error viewing marks: " + e.getMessage());
	        }
	    }
	    public void searchMarks(int studentId) {
	        String sql = "SELECT * FROM marks WHERE student_id = ?";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, studentId);

	            try (java.sql.ResultSet rs = ps.executeQuery()) {
	                boolean found = false;

	                while (rs.next()) {
	                    found = true;

	                    System.out.println("Mark ID: " + rs.getInt("mark_id"));
	                    System.out.println("Student ID: " + rs.getInt("student_id"));
	                    System.out.println("Subject ID: " + rs.getInt("subject_id"));
	                    System.out.println("Marks: " + rs.getInt("marks"));
	                    System.out.println("Semester: " + rs.getInt("semester"));
	                    System.out.println("-------------------------");
	                }

	                if (!found) {
	                    System.out.println("No marks found for this student.");
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("Error searching marks: " + e.getMessage());
	        }
	    }
	    public void updateMarks(int studentId, int subjectId, int semester, int newMarks) {
	        String sql = "UPDATE marks SET marks = ? WHERE student_id = ? AND subject_id = ? AND semester = ?";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, newMarks);
	            ps.setInt(2, studentId);
	            ps.setInt(3, subjectId);
	            ps.setInt(4, semester);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Marks updated successfully!");
	            } else {
	                System.out.println("Marks record not found.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error updating marks: " + e.getMessage());
	        }
	    }
	    public void deleteMarks(int studentId, int subjectId, int semester) {
	        String sql = "DELETE FROM marks WHERE student_id = ? AND subject_id = ? AND semester = ?";

	        try (Connection con = DatabaseConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, studentId);
	            ps.setInt(2, subjectId);
	            ps.setInt(3, semester);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Marks deleted successfully!");
	            } else {
	                System.out.println("Marks record not found.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error deleting marks: " + e.getMessage());
	        }
	    }
	}

