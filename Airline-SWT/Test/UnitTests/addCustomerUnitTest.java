package UnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import source.Customer;
import source.addCustomer;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

@RunWith(Parameterized.class)
public class addCustomerUnitTest {

    private String customerFirstName;
    private String customerLastName;
    private String passportId;
    private String contact;
    private String nic;
    private String address;
    private boolean expectedResult;
    private addCustomer addCustomerObj;
    Connection con;
    PreparedStatement pst;

    String path=null;
    byte[] userimage=null;

    @Before
    public void initialize(){
        addCustomerObj = new addCustomer();
    }

    public addCustomerUnitTest(String customerFirstName, String customerLastName, String passportId, String contact, String nic, String address, boolean expectedResult) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.passportId = passportId;
        this.contact = contact;
        this.nic = nic;
        this.address = address;
        this.expectedResult = expectedResult;
    }

    @Test
    //First test case will test the flight name being entered into the field.
    public void addCustUnitTest() throws InterruptedException {
        //Regex pattern made to reflect the inner boundaries of the string needed
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        addCustomer frame = new addCustomer();
        frame.setVisible(true);
        //Created public getters in the addFlight class to access the components
        JTextField firstNameTest = (JTextField) addCustomer.getTxtfirstname();
        JTextField lastNameTest = (JTextField) addCustomer.getTxtlastname();
        JTextField passPortIdTest = (JTextField) addCustomer.getTxtpassport();
        JTextField nicTest = (JTextField) addCustomer.getTxtnic();
        JTextArea addressTest = (JTextArea) addCustomer.getTxtaddress();
        JTextField contactTest = (JTextField) addCustomer.getTxtcontact();
        //This sets the string to the correct sting in the list
        firstNameTest.setText(customerFirstName);
        lastNameTest.setText(customerLastName);
        passPortIdTest.setText(passportId);
        contactTest.setText(contact);
        nicTest.setText(nic);
        addressTest.setText(address);
        //Allow the program to accept the text set to the component
        sleep(2000);
        firstNameTest.postActionEvent();
        lastNameTest.postActionEvent();
        passPortIdTest.postActionEvent();
        contactTest.postActionEvent();
        nicTest.postActionEvent();
        //Test the Regex against the test case to see if its within the boundaries.
        Matcher match = pattern.matcher(firstNameTest.getText());
        boolean firstNameResult = match.find();
        Assert.assertTrue(expectedResult);
    }

    @Test
    public void add_first_customer_test() throws InterruptedException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            pst = con.prepareStatement("DELETE from customer where id = ?");
            pst.setString(1, "CS001");
            pst.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Regex pattern made to reflect the inner boundaries of the string needed
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        addCustomer frame = new addCustomer();
        frame.setVisible(true);
        //Created public getters in the addFlight class to access the components
        JTextField firstNameTest = (JTextField) addCustomer.getTxtfirstname();
        JTextField lastNameTest = (JTextField) addCustomer.getTxtlastname();
        JTextField passPortIdTest = (JTextField) addCustomer.getTxtpassport();
        JTextField nicTest = (JTextField) addCustomer.getTxtnic();
        JTextArea addressTest = (JTextArea) addCustomer.getTxtaddress();
        JTextField contactTest = (JTextField) addCustomer.getTxtcontact();
        //This sets the string to the correct sting in the list
        firstNameTest.setText(customerFirstName);
        lastNameTest.setText(customerLastName);
        passPortIdTest.setText(passportId);
        contactTest.setText(contact);
        nicTest.setText(nic);
        addressTest.setText(address);
        //Allow the program to accept the text set to the component
        sleep(2000);
        firstNameTest.postActionEvent();
        lastNameTest.postActionEvent();
        passPortIdTest.postActionEvent();
        contactTest.postActionEvent();
        nicTest.postActionEvent();
        //Test the Regex against the test case to see if its within the boundaries.
        Matcher match = pattern.matcher(firstNameTest.getText());
        boolean firstNameResult = match.find();
        Assert.assertTrue(expectedResult);

        //Add customer back in
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            pst = con.prepareStatement("insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, "CS001");
            pst.setString(2, firstNameTest.getText());
            pst.setString(3, lastNameTest.getText());
            pst.setString(4, nicTest.getText());
            pst.setString(5, passPortIdTest.getText());
            pst.setString(6, addressTest.getText());
            pst.setString(7, "12-6-1990");
            pst.setString(8, "male");
            pst.setString(9, contactTest.getText());
            pst.setBytes(10, userimage);
            pst.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Parameterized.Parameters
    //This creates the different fields need to create a new customer and automates the the inputs into the method above
    public static Collection inputStrings() {
        return Arrays.asList(new Object[][] {
                { "Brenda" ,"Rhodes","123s5", "2395901000", "4072sad","10501 FGCU Blvd S" , true },
//                { "%^&Bob","Builder","123s5", "2395901000", "4072sad","10501 FGCU Blvd S" , false },
//                { "Brenda", "Rhodes","^5", "2395901000", "4072sad","10501 FGCU Blvd S" , false },
//                { "Brenda", "Rhodes","545", "2395901&000", "4072sad","10501 FGCU Blvd S" , false},
//                { "Brenda", "Rhodes","5", "2395901000", "4072!sad","10501 FGCU Blvd S" , false},
//                {"Brenda", "Rhodes","^5", "2395901000", "4072sad","10501 FG*CU Blvd S" , false},
//                {"", "","", "", "","", false},
        });
    }

    Customer cust_test = new Customer("Jef", "Free", "CS002", "jf101", "099","123 Jeff ln", "1-1-1999","Male", "1");


    @Test
    public void getFirstName() {
        cust_test.getFirstName();
    }

    @Test
    public void setFirstName() {
        cust_test.setFirstName("Gary");
    }

    @Test
    public void getLastName() {
        cust_test.getLastName();
    }

    @Test
    public void setLastName() {
        cust_test.setLastName("Berry");
    }

    @Test
    public void getId() {
        cust_test.getId();
    }

    @Test
    public void setId() {
        cust_test.setId("3");
    }

    @Test
    public void getNic() {
        cust_test.getNic();
    }

    @Test
    public void setNic() {
        cust_test.setNic("090");
    }

    @Test
    public void getPassport() {
        cust_test.getPassport();
    }

    @Test
    public void setPassport() {
        cust_test.setPassport("444");
    }

    @Test
    public void getAddress() {
        cust_test.getAddress();
    }

    @Test
    public void setAddress() {
        cust_test.setAddress("123 Bear St");
    }

    @Test
    public void getDob() {
        cust_test.getDob();
    }

    @Test
    public void setDob() {
        cust_test.setDob("12-12-1990");
    }

    @Test
    public void getGender() {
        cust_test.getGender();
    }

    @Test
    public void setGender() {
        cust_test.setGender("Female");
    }

    @Test
    public void getContact() {
        cust_test.getContact();
    }

    @Test
    public void setContact() {
        cust_test.setContact("222");
    }
}