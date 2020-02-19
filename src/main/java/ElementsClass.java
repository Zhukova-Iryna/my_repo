import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsClass {
    WebDriver driver = new ChromeDriver();

    WebElement allSalesLink = driver.findElement(By.xpath(".//a[contains(@class, 'ga_main_sales_all')]"));
    WebElement DrumSetsCategoriesTab = driver.findElement(By.xpath(".//div[@class = 'categories']/descendant::li[contains(@class,'cid5253')]"));

}
