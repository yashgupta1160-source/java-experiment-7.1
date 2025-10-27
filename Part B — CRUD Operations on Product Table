import java.sql.*;
import java.util.*;

public class ProductCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con.setAutoCommit(false);

            while (true) {
                System.out.println("\n1. Insert  2. Display  3. Update  4. Delete  5. Exit");
                System.out.print("Choose: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ProductID, Name, Price, Quantity: ");
                        int id = sc.nextInt();
                        String name = sc.next();
                        double price = sc.nextDouble();
                        int qty = sc.nextInt();

                        PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES(?, ?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setDouble(3, price);
                        ps.setInt(4, qty);
                        ps.executeUpdate();
                        con.commit();
                        System.out.println("Product inserted!");
                        break;

                    case 2:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM product");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " + rs.getString(2) +
                                               " " + rs.getDouble(3) + " " + rs.getInt(4));
                        }
                        break;

                    case 3:
                        System.out.print("Enter ProductID to update price: ");
                        id = sc.nextInt();
                        System.out.print("Enter new price: ");
                        price = sc.nextDouble();
                        ps = con.prepareStatement("UPDATE product SET Price=? WHERE ProductID=?");
                        ps.setDouble(1, price);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        con.commit();
                        System.out.println("Product updated!");
                        break;

                    case 4:
                        System.out.print("Enter ProductID to delete: ");
                        id = sc.nextInt();
                        ps = con.prepareStatement("DELETE FROM product WHERE ProductID=?");
                        ps.setInt(1, id);
                        ps.executeUpdate();
                        con.commit();
                        System.out.println("Product deleted!");
                        break;

                    case 5:
                        con.close();
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
