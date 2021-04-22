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

class MainPerformanceTest {

  @Test
  public void testMainLoadTime() throws InterruptedException {
    // Make log-in instance
    Login login = new Login();
    login.setVisible(true);

    JTextField username = Login.getUsername();
    JTextField password =  Login.getPassword();

    username.setText("john");
    password.setText("123");
    sleep(2000);

    // Log into main page
    Login.jButton1.doClick();
    // Starts when main page begins loading
    Instant startTimer = login.startTimer;
    Main main = new Main();
    main.setVisible(true);
    // Ends when main page finishes loading
    Instant endTimer = main.endTimer;
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