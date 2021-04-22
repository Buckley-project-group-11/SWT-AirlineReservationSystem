package PerformanceTests;

import static java.lang.Float.parseFloat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import javax.swing.JTextField;
import org.junit.Assert;
import org.junit.Test;
import source.Login;
import source.Main;
import source.searchCustomer;

class searchCustomerPerformanceTest {

  @Test
  public void testSearchCustomerLoadTime() {
    // Make main instance
    Main main = new Main();
    main.setVisible(true);

    // Go into search customer page
    main.jMenuItem2.doClick();
    // Starts when search customer page begins loading
    Instant startTimer = main.timer;
    searchCustomer search = new searchCustomer();
    search.setVisible(true);
    // Ends when search customer page finishes loading
    Instant endTimer = searchCustomer.endTimer;
    // Calculates duration and parses into float
    float loadTime = parseFloat(Duration
        .between(startTimer, endTimer).toString().substring(2)
        .replaceAll("S", "").replaceAll("M", ""));
    System.out.println("Load time: " + loadTime + " seconds");
    Boolean isLessThan3;
    // Requirement states it should take no longer than 3 seconds to load
    if (loadTime < 3){
      System.out.println("It's less than 3s, so should pass");
      isLessThan3 = true;
    }
    else {
      System.out.println("It's more than 3s, so should fail");
      isLessThan3 = false;
    }
    Assert.assertTrue(isLessThan3);
  }

}