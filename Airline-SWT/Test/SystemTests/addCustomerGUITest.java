package SystemTests;

import org.junit.Before;
import org.junit.Test;
import source.addCustomer;

public class addCustomerGUITest {
    private addCustomer addCustomerObj;

    @Before
    public void initialize(){
        addCustomerObj = new addCustomer();
    }

    //GUI test
    @Test
    public void jButtonActionPerformed(){
        addCustomer.jButton1.doClick();
        addCustomer.jButton2.doClick();
        addCustomer.jButton3.doClick();
    }
}
