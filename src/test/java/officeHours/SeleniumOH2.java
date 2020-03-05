package officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumOH2 {

    /*
            1. Go to http://automationpractice.com
            2. Search for 'tshirt' in a searchbox + click enter OR click search button
            3. validate you got 'no results' message on UI
            4. Search for 't-shirt'
            5. Validate there was 1 result found
         */
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://automationpractice.com/index.php");
      WebElement search= driver.findElement(By.id("search_query_top"));
      search.sendKeys("tshirt");
      Thread.sleep(3000);
      search.findElement(By.xpath("//*[@id='searchbox']/button")).click();
     System.out.println(search.findElement(By.className("alert alert-warning")).getText());
        search.sendKeys("t-shirt");
        System.out.println(search.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());




    }
}
