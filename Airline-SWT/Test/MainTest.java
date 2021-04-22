import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import source.Main;

import static java.lang.Thread.sleep;

public class MainTest extends TestCase {


    //This test is used to determine if the run is succesful after the build.
    @Test
    public void testMain() throws InterruptedException {
        Main frame = new Main();
        frame.setVisible(true);
        //Call the Main method for class coverage
        String[] args = null;
        Main.main(args);
        boolean finalResult = false;



        Main.jMenuItem1.doClick();
        Main.jMenuItem2.doClick();
        Main.jMenuItem3.doClick();
        Main.jMenuItem4.doClick();
        Main.jMenuItem5.doClick();
        Main.jMenuItem6.doClick();
        sleep(200);
        boolean[] totalResults = {Main.jMenuItem1.isDisplayable(), Main.jMenuItem2.isDisplayable(),
                Main.jMenuItem3.isDisplayable(), Main.jMenuItem4.isDisplayable(), Main.jMenuItem5.isDisplayable(),
                Main.jMenuItem6.isDisplayable()};
        for(int i=0;i<totalResults.length;i++){
            if(totalResults[i]==true){
                finalResult = true;
            }
            else{
                finalResult=false;
            }
        }
        Assert.assertTrue(finalResult);

    }
}

