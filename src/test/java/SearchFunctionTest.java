import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchFunctionTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        openMainPage();
    }

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

    @Test
    public void sortingFunctionTest(){
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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
