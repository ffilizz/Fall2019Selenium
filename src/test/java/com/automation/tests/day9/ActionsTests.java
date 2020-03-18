package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp() {
        driver= DriverFactory.createDriver("chrome");
        actions= new Actions(driver);
    }

    @Test
    public void hoverOnImage(){
        driver.get("https://practice-cybertekschool.herokuapp.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1= driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2= driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3= driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions
        //always end with perform
        //moveToElement returns instance of action class that's why we can chain them
        //builder pattern == chaining methods
//what is build?
//if you have multiple actions you have to put build
//to combine a couple of actions.
//build() is needed when you have couple of actions
//build combines the action; perform; starts the action
//in this example; first we move to one image then second so we used build
//always end with perform
//perform does not click, it starts the action, execute the event
//you can perform click, drag and drop etc
//actions class has different implementations
//moveToElement returns instance of action class that's why we can chain them



        actions.moveToElement(img1).pause(1000).
                moveToElement(img2).pause(1000).
                moveToElement(img3).
                build().perform();

        BrowserUtils.wait(3);
        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();

    }
}
