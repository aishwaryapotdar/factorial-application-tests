package org.example.smoke;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FactorialSmokeTest {

    private WebDriver driver;

    private static final  Logger log = LogManager.getLogger(FactorialSmokeTest.class);

    public FactorialSmokeTest(WebDriver driver) {
        this.driver = driver;
    }

    public void executeAll(){
        log.info("Executing Smoke Test Cases...");
        setup();;
        if(!checkPageTitle()) log.error("Test case failed - checkPageTitle()");
        if(!checkHeading()) log.error("Test case failed - checkHeading()");
        if(!checkCalculateButton()) log.error("Test case failed - checkCalculateButton()");
        if(!checkPrivacyDocument()) log.error("Test Case failed - checkPrivacyDocument()");
        if(!checkTermsAndConditionsDocument()) log.error("Test Case failed - checkTermsAndConditionsDocument()");



    }

    private void setup(){
        driver.get("https://qainterview.pythonanywhere.com/");
        driver.manage().window().maximize();
    }



    private boolean checkPageTitle(){
        log.info("Testing checkPageTitle()");
        return ("Factoriall").contentEquals(driver.getTitle());
    }


    private boolean checkHeading(){
        log.info("Testing checkHeading()");
        return driver.findElement(By.tagName("h1")).getText().equals("The greatest factorial calculator!");
    }
    private boolean checkCalculateButton(){
        log.info("Testing checkCalculateButton()");
        return driver.findElement(By.id("getFactorial")).isEnabled();
    }

    private boolean checkPrivacyDocument(){
        setup();
      log.info("Testing checkPrivacyDocument()");
      driver.findElement(By.linkText("Privacy")).click();
      return driver.getCurrentUrl().contentEquals("https://qainterview.pythonanywhere.com/privacy");

    }
    private boolean checkTermsAndConditionsDocument(){
        setup();
        log.info("Testing checkTermsAndConditionsDocument()");
        driver.findElement(By.linkText("Terms and Conditions")).click();
        return driver.getCurrentUrl().contentEquals("https://qainterview.pythonanywhere.com/terms");

    }
}
