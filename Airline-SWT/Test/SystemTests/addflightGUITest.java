package SystemTests;

import com.toedter.calendar.JDateChooser;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import source.addflight;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addflightGUITest extends TestCase {

    @Test
    public void testButton1() throws InterruptedException {
        addflight details = new addflight();
        details.setVisible(true);
        //Created public getters in the addFlight class to access the Swing components.
        JTextField nameTest = (JTextField) addflight.txtflightname;
        JComboBox<String> sourceTest = (JComboBox<String>) addflight.txtsource;
        JComboBox<String> departTest = (JComboBox<String>) addflight.txtdepart;
        JDateChooser dateTest = (JDateChooser) addflight.txtdate;
        JTextField departTimeTest = (JTextField) addflight.txtdtime;
        JTextField arrTimeTest = (JTextField) addflight.txtarrtime;
        JTextField chargeTest = (JTextField) addflight.txtflightcharge;
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

        //A String Array of the elements in the combo box is made to initialize the boundary.
        String[] expResult = {"India", "Srilanka", "Uk", "Usa", "Canada", "Chinna"};
        //A loop iterates through the array and adds each item to the combo box selection component.


        for (int i = 0; i < expResult.length; i++) {
            sourceTest.setSelectedItem(expResult[i]);
            departTest.setSelectedItem(expResult[i]);
            sleep(200);
        }


        //After the test value is set, the program sleeps so it can accept the value before moving on.
        sleep(2000);
        nameTest.postActionEvent();
        departTimeTest.postActionEvent();
        arrTimeTest.postActionEvent();
        chargeTest.postActionEvent();

        //The date needs to be formatted the same way as the database has dates stored.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Date = dateFormat.format(((JDateChooser) addflight.txtdate).getDate());
        details.jButton1.doClick();
        Boolean isHidden =details.getVisibility();
        System.out.println("Button1 test should pass.");

        // Integration Testing - Mock
        List addFlightMock = mock(List.class);
        addFlightMock.add(isHidden);
        verify(addFlightMock).add(false);
        Assert.assertFalse(isHidden);
    }

    @Test
    public void testButton2() {
        // Create instance of the searchCustomer class
        addflight details = new addflight();
        details.setVisible(true);
        details.jButton2.doClick();
        Boolean isHidden =details.getVisibility();
        System.out.println("Button2 test should pass.");

        // Integration Testing - Mock
        List addFlightMock = mock(List.class);
        addFlightMock.add(isHidden);
        verify(addFlightMock).add(true);
        Assert.assertTrue(isHidden);

    }

}