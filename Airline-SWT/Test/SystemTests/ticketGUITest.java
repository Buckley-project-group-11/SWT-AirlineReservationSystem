package SystemTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.searchCustomer;
import source.ticket;

public class ticketGUITest extends TestCase {

    @Test
    public void test_jbutton1(){
        ticket ticket_test = new ticket();
        ticket_test.setVisible(true);
        searchCustomer.jButton1.doClick();
        Assert.assertTrue(ticket_test.isVisible());
    }
    @Test
    public void test_jbutton2(){
        ticket ticket_test = new ticket();
        ticket_test.setVisible(true);
        searchCustomer.jButton2.doClick();
        Assert.assertTrue(ticket_test.isVisible());
    }
    @Test
    public void test_jbutton3(){
        ticket ticket_test = new ticket();
        ticket_test.setVisible(true);
        searchCustomer.jButton3.doClick();
        Assert.assertTrue(ticket_test.isVisible());
    }
    @Test
    public void test_jbutton4(){
        ticket ticket_test = new ticket();
        ticket_test.setVisible(true);
        searchCustomer.jButton4.doClick();
        Assert.assertTrue(ticket_test.isVisible());
    }


}