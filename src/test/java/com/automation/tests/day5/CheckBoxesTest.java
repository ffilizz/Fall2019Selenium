package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(4);
        List<WebElement> checkBoxes= driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test PASSED!");
        }else{
            System.out.println("Test FAILED!!");
        }
        BrowserUtils.wait(2);
        WebElement checkbox1 = checkBoxes.get(0);
        checkbox1.click();
        BrowserUtils.wait(2);
        if(checkbox1.isSelected()){
            System.out.println("Test PASSED!");
            System.out.println("checkbox #1 is selected");
        } else{
            System.out.println("Test FAILED!!");
            System.out.println("checkbox #1 is not selected");
        }
        BrowserUtils.wait(3);
        driver.quit();





    }
}
