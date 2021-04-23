package SystemTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.searchCustomer;
import source.ticketreport;

public class ticketreportGUITest extends TestCase {
    @Test
    public void test_jbutton1(){
        ticketreport ticket_test = new ticketreport();
        ticket_test.setVisible(true);
        searchCustomer.jButton1.doClick();
        Assert.assertTrue(ticket_test.isVisible());
    }

}