import java.util.*;

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            StudentDAO dao = new StudentDAO();

            while (true) {
                System.out.println("\n1. Add  2. View  3. Update  4. Delete  5. Exit");
                System.out.print("Choose: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ID, Name, Dept, Marks: ");
                        int id = sc.nextInt();
                        String name = sc.next();
                        String dept = sc.next();
                        double marks = sc.nextDouble();
                        dao.addStudent(new Student(id, name, dept, marks));
                        System.out.println("Student added!");
                        break;

                    case 2:
                        for (Student s : dao.getAllStudents()) {
                            System.out.println(s.getId() + " " + s.getName() + " " +
                                               s.getDept() + " " + s.getMarks());
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID and new Marks: ");
                        id = sc.nextInt();
                        marks = sc.nextDouble();
                        dao.updateMarks(id, marks);
                        System.out.println("Updated!");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        id = sc.nextInt();
                        dao.deleteStudent(id);
                        System.out.println("Deleted!");
                        break;

                    case 5:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
