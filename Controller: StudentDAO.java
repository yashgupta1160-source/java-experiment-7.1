import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
    }

    public void addStudent(Student s) throws SQLException {
        String q = "INSERT INTO student VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getDept());
        ps.setDouble(4, s.getMarks());
        ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM student");
        while (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2),
                                 rs.getString(3), rs.getDouble(4)));
        }
        return list;
    }

    public void updateMarks(int id, double marks) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE student SET Marks=? WHERE StudentID=?");
        ps.setDouble(1, marks);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE StudentID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
