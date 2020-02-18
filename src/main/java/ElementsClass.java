import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsClass {
    WebDriver driver = new ChromeDriver();

    // All sales link
    WebElement allSales = driver.findElement(By.xpath(".//a[contains(@class, 'ga_main_sales_all')]"));

    //
    // ".//ul[starts-with(@class, 'main-categories')]"
}
