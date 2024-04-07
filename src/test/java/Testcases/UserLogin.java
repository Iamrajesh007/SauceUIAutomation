package Testcases;

import Utils.Apputils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserLogin extends Apputils
{
    @Test(priority = 1)
    public void userLogin()
    {
    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    }
    @Test(priority = 2)
    public void addTocart()
    {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();

    }
    @Test(priority = 3)
    public void Checkout()  {

      driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Thomas");
      driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Shelby");
      driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("500038");

      driver.findElement(By.id("continue")).click();
      driver.findElement(By.id("finish")).click();
      String status=driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(status,"Thank you for your order!");
    }
}
