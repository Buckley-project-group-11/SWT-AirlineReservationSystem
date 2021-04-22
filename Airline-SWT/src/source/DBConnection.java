package source;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBConnection {

    private Connection dbConnection;
    private PreparedStatement pst;

    public void getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
    }

    public int executeQuery(String query) throws ClassNotFoundException, SQLException {
        return dbConnection.createStatement().executeUpdate(query);
    }

    public Customer findCust() throws SQLException, ParseException {
        String id = "CS015";
        pst = dbConnection.prepareStatement("select * from customer where id = ?");
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();

            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            String nic = rs.getString("nic");
            String passport = rs.getString("passport");

            String address = rs.getString("address");
            String dob = rs.getString("dob");
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            String gender =rs.getString("gender");

            Customer temp = new Customer(fname, lname, id,nic,passport, address, dob, String.valueOf(date1), gender);

            return temp;
        }
}

