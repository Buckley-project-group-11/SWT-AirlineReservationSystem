package IntegrationTests;

import com.toedter.calendar.JDateChooser;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import source.addCustomer;
import source.addflight;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class addflightIntegrationTest extends TestCase {

    @Test
    /*
    This test was constructed to test the input of the user as it is entered in to the Swing GUI for creating a new
    flight, and stores the input into the flight table in the database by clicking the button.
     */
    public void test_FUN_5_positive_testing() throws InterruptedException {
        //Make the addFlight frame visible for the test
        addflight frame = new addflight();
        frame.setVisible(true);

        //Regex pattern made to reflect the inner boundaries of the string needed.
        Pattern namePattern = Pattern.compile("[A-Za-z]");
        Pattern datePattern = Pattern.compile("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]" +
                "|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|" +
                "([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$");
        Pattern timePattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9](.*AM|PM.*)");
        Pattern chargePattern = Pattern.compile("[0-9]+");

        //A String Array of the elements in the combo box is made to initialize the boundary.
        String[] expResult = {"India", "Srilanka", "Uk", "Usa", "Canada", "Chinna"};

        //Created public getters in the addFlight class to access the Swing components.
        JTextField nameTest = (JTextField) addflight.txtflightname;
        JComboBox<String> sourceTest = (JComboBox<String>) addflight.txtsource;
        JComboBox<String> departTest = (JComboBox<String>) addflight.txtdepart;
        JDateChooser dateTest = (JDateChooser) addflight.txtdate;
        JTextField departTimeTest = (JTextField) addflight.txtdtime;
        JTextField arrTimeTest = (JTextField) addflight.txtarrtime;
        JTextField chargeTest = (JTextField) addflight.txtflightcharge;


        //Initialize the booleans that will be used to test the Source and Departure combo boxes.
        boolean testSourceContains = false;
        boolean testDepartContains = false;


        //A loop iterates through the array and adds each item to the combo box selection component.
        for (int i = 0; i < expResult.length; i++) {
            sourceTest.setSelectedItem(expResult[i]);
            departTest.setSelectedItem(expResult[i]);
            sleep(200);
            //Once the component selects the item, it is tested to see if it exist in the combo box.
            testSourceContains = expResult[i].equals(sourceTest.getSelectedItem());
            testDepartContains = expResult[i].equals(departTest.getSelectedItem());
            //If the item is in the combobox then the selection made by the user was within bounds.
        }

        /*
        Because a Swing GUI cannot be accessed during testing, the component is set to the test value manually.
        The test value for the name of the flight is within the Regex value and is expected to pass.
         */
        nameTest.setText("yellowSky");

        //The test time being set is within the regex bounds for time, and is expected to pass
        departTimeTest.setText("11:00AM");
        arrTimeTest.setText("08:33PM");

        //The test date selected for the flight is the current date.
        dateTest.setCalendar(Calendar.getInstance());

        //The test charge for the flight is within regex bounds and is expected to pass.
        chargeTest.setText("14000");


        //After the test value is set, the program sleeps so it can accept the value before moving on.
        sleep(2000);
        nameTest.postActionEvent();
        departTimeTest.postActionEvent();
        arrTimeTest.postActionEvent();
        chargeTest.postActionEvent();

        //The date needs to be formatted the same way as the database has dates stored.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Date = dateFormat.format(((JDateChooser) addflight.txtdate).getDate());


        //Matcher objects are created for each of the fields that have Regex boundaries.
        Matcher nameMatch = namePattern.matcher(nameTest.getText());
        Matcher dateMatch = datePattern.matcher(Date);
        Matcher departTimeMatch = timePattern.matcher(departTimeTest.getText());
        Matcher arrTimeMatch = timePattern.matcher(arrTimeTest.getText());
        Matcher chargeMatch = chargePattern.matcher(chargeTest.getText());


        //The results of the test inputs against the Regex patterns are stored.
        boolean nameResult = nameMatch.find();
        boolean departTimeResult = departTimeMatch.find();
        boolean dateResult = dateMatch.find();
        boolean arrTimeResult = arrTimeMatch.find();
        boolean chargeResult = chargeMatch.find();


        //A boolean array holds all the results of the test inputs.
        boolean[] testResults = {
                nameResult,
                testSourceContains,
                testDepartContains,
                dateResult,
                departTimeResult,
                arrTimeResult,
                chargeResult};



        boolean[]  allTestPassed = {true, true, true, true, true, true, true};
        //Creates the mock object which will store the test results.
        List flightAddMock = mock(List.class);
        //Add the test results to the mock object.
        flightAddMock.add(testResults);
        //Verifies if the actual output equates the expected output.
        verify(flightAddMock).add(allTestPassed);

        //This button's action stores the newly created flight into the database.
        addflight.jButton1.doClick();

        //This button is pressed for coverage.
        addflight.jButton2.doClick();

        frame.autoID();

    }






}