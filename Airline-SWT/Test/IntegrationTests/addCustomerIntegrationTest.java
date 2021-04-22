package IntegrationTests;

import org.junit.Assert;
import org.junit.Test;
import source.addCustomer;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class addCustomerIntegrationTest {
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

}
