import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class SearchFunctionTest extends BaseTest {

    @Test
    public void searchStartsTest(){
        driver.findElement(By.id("SearchForm_searchPhrase")).sendKeys("Samsung A50" + Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "▶Поиск по сайту Price.ua");
    }

    @Test
    public void relevantSearchTest(){
        driver.findElement(By.id("SearchForm_searchPhrase")).sendKeys("Samsung A50" + Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//div[starts-with(@class, 'product-block type2 ga_container')]"));
        System.out.println(elements.size());
        int counter = 0;
        for (WebElement we: elements) {
            if(we.getText().contains("Samsung A50")) {
                counter++;
            }
        }
        System.out.println(counter);
        Assert.assertTrue(counter > 0 );
    }

   /* @Test
    public void sortingFunctionTest(){
        driver.findElement(By.id("SearchForm_searchPhrase")).sendKeys("Samsung A50" + Keys.ENTER);
        driver.findElement(By.linkText("Сравнить цены")).click();
        driver.findElement(By.xpath("//li[@class='block-wrapper simple3 prices active']")).click();
        driver.findElement(By.xpath("//a[@class='ga_cat_sort link active']")).click();
        driver.findElement(By.xpath("//div[@class='sort-buttons active']//div//a[1]//span[1]")).click();
        List<WebElement> elements = driver.findElements(By.className("priceline-item priceline-split ga_container clearer-block no-phone is-notbid"));
        System.out.println(elements.size());
        int counter = 0;
        for (WebElement we: elements) {
            if(we.getText().contains("Samsung A50")) {
                counter++;
            }
        }
        System.out.println(counter);
        Assert.assertTrue(counter > 0 );
    }*/


}
