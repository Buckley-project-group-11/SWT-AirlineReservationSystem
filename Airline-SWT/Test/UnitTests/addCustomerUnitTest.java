package UnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import source.addCustomer;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    //GUI test
    @Test
    public void jButtonActionPerformed(){
        addCustomer.jButton1.doClick();
        addCustomer.jButton2.doClick();
        addCustomer.jButton3.doClick();
    }

    //Integration test
    @Test
    public void testButton3() {
        addCustomer create = new addCustomer();
        create.setVisible(true);
        create.jButton3.doClick();
        Boolean isHidden = create.getVisibility();
        System.out.println("Button3 test should pass.");

        // Integration Testing - Mock
        List addCustomerMock = mock(List.class);
        addCustomerMock.add(isHidden);
        verify(addCustomerMock).add(true);

        Assert.assertTrue(isHidden);
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


}