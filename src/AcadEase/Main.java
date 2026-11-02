package AcadEase;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 11) {

            System.out.println("==============================================");
            System.out.println(" STUDENT ACADEMIC RECORD MANAGEMENT SYSTEM");
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
            System.out.println("Input received: " + choice);

            switch (choice) {
                case 1:
                    System.out.println("Student Management selected.");
                    break;

                case 2:
                    System.out.println("Subject Management selected.");
                    break;

                case 3:
                    System.out.println("Marks Management selected.");
                    break;

                case 4:
                    System.out.println("Calculate Student Result selected.");
                    break;

                case 5:
                    System.out.println("Student Academic Report selected.");
                    break;

                case 6:
                    System.out.println("Search and Filter selected.");
                    break;

                case 7:
                    System.out.println("Class Performance Statistics selected.");
                    break;

                case 8:
                    System.out.println("Subject Topper selected.");
                    break;

                case 9:
                    System.out.println("Semester-wise Progress Tracker selected.");
                    break;

                case 10:
                    System.out.println("Low-Marks Alert selected.");
                    break;

                case 11:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Enter a number from 1 to 11.");
            }

            System.out.println();
        }

        sc.close();
    }
}



