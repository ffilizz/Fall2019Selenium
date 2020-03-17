package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class PracticeTests {

    private WebDriver driver;

    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual,expected,"Sub-header message is not matching!!!");

    }
@Test
public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.id("form_submit")).click();
    String expected="Your e-mail's been sent!";
    String actual=driver.findElement(By.name("confirmation_message")).getText();
    Assert.assertEquals(actual,expected,"Sub-header message is not matching!!!");


}
@Test
public void checkBoxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
    List<WebElement> checkboxes=driver.findElements(By.tagName("input"));
    BrowserUtils.wait(3);
    checkboxes.get(0).click();
    Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected!");


}

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
}
