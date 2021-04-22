package UnitTests;

import junit.framework.Assert;
import org.junit.Test;
import source.searchCustomer;

public class searchCustomerUnitTest {

    @Test
    public void testVisibility(){
        // Create instance of the searchCustomer class
        searchCustomer search = new searchCustomer();
        search.setVisible(true);
        Assert.assertTrue(search.isVisible());
    }



}