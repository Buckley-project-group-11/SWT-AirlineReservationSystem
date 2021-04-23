package PerformanceTests;

import static java.lang.Float.parseFloat;

import java.time.Duration;
import java.time.Instant;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import source.Main;
import source.addCustomer;

public class addCustomerPerformanceTest {

  @Test
  public void testAddCustomerLoadTime() {
    // Make main instance
    Main main = new Main();
    main.setVisible(true);

    // Go into addCustomer page
    main.jMenuItem2.doClick();
    // Starts when addCustomer page begins loading
    Instant startTimer = main.timer;
    addCustomer addCust = new addCustomer();
    addCust.setVisible(true);
    // Ends when addCustomer page finishes loading
    Instant endTimer = addCust.endTimer;
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