package simpleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn {
    @Test
    public void loginToConnectedIOSuccess() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qacloud.connectedio.com/login");
        Thread.sleep(3000);
        WebElement emailAddress = driver.findElement(By.xpath("//*[@type='email']"));
        emailAddress.sendKeys("dsmirnov99@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("Artemka99!");
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Device Management Portal");
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Test is passed");
    }
    @Test
    public void loginToConnectedIOWithInvalidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qacloud.connectedio.com/login");
        Thread.sleep(3000);
        WebElement emailAddress = driver.findElement(By.xpath("//*[@type='email']"));
        emailAddress.sendKeys("dsmirnov99@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("wrongPassword");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Test is passed");
    }
}
