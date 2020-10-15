package org.example;

import org.example.functional.FactorialFunctionalTest;
import org.example.smoke.FactorialSmokeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        FactorialSmokeTest smokeTest = new FactorialSmokeTest(driver);
        smokeTest.executeAll();

        FactorialFunctionalTest functionalTest = new FactorialFunctionalTest(driver);
        functionalTest.executeAll();

        driver.close();

    }
}
