package UnitTests;

import org.junit.Assert;
import org.junit.Test;
import source.Main;

import static org.junit.jupiter.api.Assertions.*;

class MainUnitTest {

    @Test
    public void screen_visibility_test(){
        Main visible_screen = new Main();
        visible_screen.isVisible();
        Main.jMenuItem1.doClick();
        Main.jMenuItem2.doClick();
        Main.jMenuItem3.doClick();
        Main.jMenuItem4.doClick();
        Main.jMenuItem5.doClick();
        Main.jMenuItem6.doClick();
        Assert.assertTrue(visible_screen.isVisible());
    }


}