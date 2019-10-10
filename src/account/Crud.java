/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

/**
 *
 * @author paculananglu_sd2081
 */
public class Crud {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Connection connectToDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/paculanang", "root", "");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        } 
        return con;
     }

    public void getData() {
        try {
            String query = "select * from users";
            rs = (ResultSet) st.executeQuery(query);
            System.out.println("Records in database");
            while (rs.next()) {
                String fname = rs.getString("FirstName");
                String mname = rs.getString("MiddleName");
                String lname = rs.getString("LastName");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                System.out.println("Firstname: " + fname + " " + " Middlename: " + mname
                        + " " + "Lastname: " + lname + " " + "Email: " + email  );
            }

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

}
