

import com.mysql.cj.util.TestUtils;
import com.toedter.calendar.JDateChooser;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class addflightTest{



    @Test
    public void testcase1() throws InterruptedException {
        Pattern pattern = Pattern.compile("[A-Za-z]");
        addflight frame = new addflight();
        frame.setVisible(true);
        JTextField iTest = (JTextField) addflight.getTxtName();
        iTest.setText("yellowSky");
        sleep(2000);
        iTest.postActionEvent();
        Matcher match = pattern.matcher(iTest.getText());
        boolean result = match.find();
        Assert.assertTrue(result);
    }

    @Test
    public void testcase2() throws InterruptedException {
        addflight frame = new addflight();
        frame.setVisible(true);
        boolean iTestcontains = false;
        JComboBox<String> iTest = (JComboBox<String>) addflight.getTxtsource();
        String[] expResult = {"India", "Srilanka", "Uk", "Usa", "Canada", "Chinna"};
        for(int i = 0; i<expResult.length;i++){
            iTest.setSelectedItem(expResult[i]);
            sleep(200);
            iTestcontains = expResult[i].equals(iTest.getSelectedItem());
        }
        Assert.assertTrue(iTestcontains);

    }
    @Test
    public void testcase3() throws InterruptedException {
        addflight frame = new addflight();
        frame.setVisible(true);
        boolean iTestcontains = false;
        JComboBox<String> iTest = (JComboBox<String>) addflight.getTxtdepart();
        String[] expResult = {"India", "Srilanka", "Uk", "Usa", "Canada", "Chinna"};
        for(int i = 0; i<expResult.length;i++){
            iTest.setSelectedItem(expResult[i]);
            sleep(200);
            iTestcontains = expResult[i].equals(iTest.getSelectedItem());
        }
        Assert.assertTrue(iTestcontains);

    }

    @Test
    public void testcase4() throws InterruptedException, ParseException {
        Pattern pattern = Pattern.compile("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$");
        addflight frame = new addflight();
        frame.setVisible(true);
        JDateChooser iTest = (JDateChooser) addflight.getTxtdate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        iTest.setDate(Date.valueOf("2021-06-12"));
        sleep(2000);
        String Date = dateFormat.format(((JDateChooser) addflight.getTxtdate()).getDate());
        Matcher match = pattern.matcher(Date);
        boolean result = match.find();
        Assert.assertTrue(result);
    }

    @Test
    public void testcase5() throws InterruptedException {
        Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9](.*AM|PM.*)");
        addflight frame = new addflight();
        frame.setVisible(true);
        JTextField iTest = (JTextField) addflight.getTxtdtime();
        String expResult;
        iTest.setText("11:00AM");
        sleep(2000);
        iTest.postActionEvent();
        Matcher match = pattern.matcher(iTest.getText());
        boolean result = match.find();
        Assert.assertTrue(result);
    }

    @Test
    public void testcase6() throws InterruptedException {
        Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9](.*AM|PM.*)");
        addflight frame = new addflight();
        frame.setVisible(true);
        JTextField iTest = (JTextField) addflight.getTxtarrtime();
        String expResult;
        iTest.setText("08:33PM");
        sleep(2000);
        iTest.postActionEvent();
        Matcher match = pattern.matcher(iTest.getText());
        boolean result = match.find();
        Assert.assertTrue(result);

    }
    @Test
    public void testcase7() throws InterruptedException {
        Pattern pattern = Pattern.compile("[0-9]+");
        addflight frame = new addflight();
        frame.setVisible(true);
        JTextField iTest = (JTextField) addflight.getTxtflightcharge();
        String expResult;
        iTest.setText("14000");
        sleep(2000);
        iTest.postActionEvent();
        Matcher match = pattern.matcher(iTest.getText());
        boolean result = match.find();
        Assert.assertTrue(result);
    }
}










