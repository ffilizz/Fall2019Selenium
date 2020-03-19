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

    @Test
    public void jQueryMenuTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com/jqueryui/menu");
        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement download=driver.findElement(By.id("ui-id-4"));
        WebElement pdf=driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabled).pause(1000).
                moveToElement(download).pause(1000).
                click(pdf).
                build().perform();

    }
    @Test
    public void dragAndDropTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement earth =driver.findElement(By.id("droptarget"));
        WebElement moon =driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon,earth).perform();
        String expected ="You did great!";
        String actual= earth.getText();

        Assert.assertEquals(actual,expected);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();

    }
}