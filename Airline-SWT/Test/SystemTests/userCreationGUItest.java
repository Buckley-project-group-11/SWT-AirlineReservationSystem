package SystemTests;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import source.userCreation;

public class userCreationGUItest extends TestCase {
    //Test the GUI component's functionality associated with requirement FUN-2
    @Test
    public void test_FUN2_GUI_testing(){
        // Create instance of the searchCustomer class
        userCreation cancel = new userCreation();
        cancel.setVisible(true);
        cancel.jButton2.doClick();
        Boolean isHidden =cancel.getVisibility();
        System.out.println("Button2 test should pass.");
        Assert.assertTrue(isHidden);
    }
}