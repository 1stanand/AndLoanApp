package com.loandesk.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginAsTeller() {
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("teller@bank.local");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("LoanDesk"));
    }
}
