package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);
        WebElement upload=driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        String filePath2="/Users/imac/Downloads/exceptions hierarchy.jpg";
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(5);
        System.out.println("filePath = " + filePath);
        System.out.println("filePath2 = " + filePath2);
        BrowserUtils.wait(3);
        driver.quit();


    }
}
