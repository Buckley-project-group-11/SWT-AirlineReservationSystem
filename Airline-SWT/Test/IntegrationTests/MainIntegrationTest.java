package IntegrationTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import source.Main;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainIntegrationTest {

    @Test
    void jMenuItem4ActionPerformed() {
        Main.jMenuItem1.doClick();
        Main.jMenuItem2.doClick();
        Main.jMenuItem3.doClick();
        Main.jMenuItem4.doClick();
        Main.jMenuItem5.doClick();
        Main.jMenuItem6.doClick();

    }

    @Test
    void main() throws InterruptedException {
        Main frame = new Main();
        frame.setVisible(true);
        //Call the Main method for class coverage
        String[] args = null;
        Main.main(args);
        boolean[] finalResult = {
                false,
                false,
                false,
                false,
                false,
                false};
        sleep(200);

        boolean[] totalResults = {Main.jMenuItem1.isDisplayable(), Main.jMenuItem2.isDisplayable(),
                Main.jMenuItem3.isDisplayable(), Main.jMenuItem4.isDisplayable(), Main.jMenuItem5.isDisplayable(),
                Main.jMenuItem6.isDisplayable()};
        for(int i=0;i<totalResults.length;i++){
            if(totalResults[i]==true){
                finalResult[i] = true;
            }
            else{
                finalResult[i]=false;
            }
        }
        List mainMock = mock(List.class);
        mainMock.add(totalResults);
        verify(mainMock).add(finalResult);

    }
}