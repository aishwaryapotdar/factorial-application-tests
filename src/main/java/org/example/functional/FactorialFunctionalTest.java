package org.example.functional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FactorialFunctionalTest {

    private WebDriver driver;

    private static final Logger log = LogManager.getLogger(FactorialFunctionalTest.class);

    public FactorialFunctionalTest(WebDriver driver) {
        this.driver = driver;
    }

    public void executeAll() throws InterruptedException {
        log.info("Executing Functional Test Cases...");

        /*
         * Functional Test for random positive integer
         */
        if (!checkFactorialTestFor("3", "6")) log.error("Test case failed - factorialOfThree");

        /*
         * Boundary Value Analysis inputs
         */
        if (!checkFactorialTestFor("0", "1")) log.error("Test case failed - factorialOfZero");
        if (!checkFactorialTestFor("1", "1")) log.error("Test case failed - factorialOfOne");
        if (!checkFactorialTestFor("170", "7.257415615307999e+306"))
            log.error("Test case failed - factorialOfOneHundredSeventy");
        if (!checkFactorialTestFor("171", "Infinity")) log.error("Test case failed - factorialOfOneHundredSeventyOne");

        /*
         * Negative test inputs
         */
        if (!checkFactorialTestFor("-3", "Please enter a positive integer"))
            log.error("Test case failed - factorialOfNegativeInteger");


    }

    private void setup() {
        driver.get("https://qainterview.pythonanywhere.com/");
        driver.manage().window().maximize();
    }

    private boolean checkFactorialTestFor(String input, String output) throws InterruptedException {
        log.info("Executing Test checkFactorialTestFor(Input: " + input + ", Output: " + output + ")");
        setup();
        WebElement inputElement = driver.findElement(By.id("number"));
        inputElement.click();
        inputElement.sendKeys(input);
        driver.findElement(By.id("getFactorial")).click();
        synchronized (driver) {
            driver.wait(5000);
        }
        return driver.findElement(By.id("resultDiv")).getText().contentEquals("The factorial of " + input + " is: " + output);
    }
}