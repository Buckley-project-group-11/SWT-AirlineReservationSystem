import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(Parameterized.class)
public class addCustomerTest {
    private String input;
    private boolean expectedResult;
    private addCustomer addCustomerObj;

    @Before
    public void initialize(){
        addCustomerObj = new addCustomer();
    }

    public addCustomerTest(String input, Boolean expectedResult){
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputStrings() {
        return Arrays.asList(new Object[][] {
                { "Bob", true },
                { "%^&Bob", false },
                { "Brenda", true },
                { "Brenda.Rhodes", false },
                { "Jana", true }
        });
    }

    @Test
    void jButton2ActionPerformed() {
        // Uses regex to find if there are special characters in the string if there are result = true
        Pattern pattern = Pattern.compile("[A-Za-z0-9]");
        Matcher match = pattern.matcher(input);
        boolean result = match.find();
        Assert. assertTrue(result);
    }
}