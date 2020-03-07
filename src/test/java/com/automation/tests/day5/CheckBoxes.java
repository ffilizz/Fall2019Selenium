package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        List<WebElement> checkBoxes= driver.findElements(By.tagName("input"));
       // checkBoxes.get(0).click();
        BrowserUtils.wait(2);
        for (int i=0;i<checkBoxes.size();i++) {
            if (checkBoxes.get(i).isDisplayed()&&checkBoxes.get(i).isEnabled()&&!checkBoxes.get(i).isSelected()) {
                checkBoxes.get(i).click();
                System.out.println("check box "+(i+1)+" is clicked");
                BrowserUtils.wait(2);
            }else{
                System.out.println("check box "+(i+1)+" is not clicked");
            }
        }
        BrowserUtils.wait(2);

        driver.quit();


    }
}
