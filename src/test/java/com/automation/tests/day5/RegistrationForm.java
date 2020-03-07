package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(4);
        driver.findElement(By.name("firstname")).sendKeys("Jon");
        driver.findElement(By.name("lastname")).sendKeys("Snow");
        driver.findElement(By.name("username")).sendKeys("gameofthrones");
        driver.findElement(By.name("email")).sendKeys("jsnow@email.com");
        driver.findElement(By.name("password")).sendKeys("123456abcde");
        driver.findElement(By.name("phone")).sendKeys("571-555-5555");

        List<WebElement> genders=driver.findElements(By.name("gender"));
        genders.get(0).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("01/01/1995");
        driver.findElement(By.id("inlineCheckbox2")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);

        driver.quit();



    }


}
