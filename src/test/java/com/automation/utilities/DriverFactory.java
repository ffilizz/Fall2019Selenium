package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    /**
     * This method return webdriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */

    public static WebDriver createDriver (String browserName){

       switch(browserName.toLowerCase()){
           case "chrome":
               WebDriverManager.chromedriver().version("79.0").setup();
               return new ChromeDriver();
           case "opera":
               WebDriverManager.operadriver().setup();
               return new OperaDriver();
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               return new FirefoxDriver();
           case"ie":
               WebDriverManager.iedriver().setup();
               return new InternetExplorerDriver();

       }
       return null;
    }

}
