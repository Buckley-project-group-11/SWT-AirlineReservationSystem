package SystemTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.searchCustomer;

public class searchCustomerGUITest extends TestCase {

    @Test
    public void test_jbutton1(){
        searchCustomer search_customer_test = new searchCustomer();
        search_customer_test.setVisible(true);
        searchCustomer.jButton1.doClick();
        Assert.assertTrue(search_customer_test.isVisible());
    }
    @Test
    public void test_jbutton2(){
        searchCustomer search_customer_test = new searchCustomer();
        search_customer_test.setVisible(true);
        searchCustomer.jButton2.doClick();
        Assert.assertTrue(search_customer_test.isVisible());
    }
    @Test
    public void test_jbutton3(){
        searchCustomer search_customer_test = new searchCustomer();
        search_customer_test.setVisible(true);
        searchCustomer.jButton3.doClick();
        Assert.assertTrue(search_customer_test.isVisible());
    }
    @Test
    public void test_jbutton4(){
        searchCustomer search_customer_test = new searchCustomer();
        search_customer_test.setVisible(true);
        searchCustomer.jButton4.doClick();
        Assert.assertTrue(search_customer_test.isVisible());
    }



}