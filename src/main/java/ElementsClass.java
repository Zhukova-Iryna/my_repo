import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementsClass {
    WebDriver driver = new ChromeDriver();

    //https://price.ua/
    WebElement allSalesLink = driver.findElement(By.xpath(".//a[contains(@class, 'ga_main_sales_all')]"));
    WebElement drumSetsTabInDrumsInMusicCategory = driver.findElement(By.xpath(".//div[@class = 'categories']/descendant::li[contains(@class,'cid5253')]"));
    WebElement microcreditCategory = driver.findElement(By.xpath(".//ul[starts-with(@class,'main-categories')]/descendant::a[last()]"));
    List<WebElement> popularItemsCategoryLaptopsAsusAndAcer = driver.findElements(By.xpath(".//div[contains(text(), 'HP')]/preceding::a[starts-with(@href,'/acer') or starts-with(@href,'/asus')]"));
    //https://price.ua/search/?q=Samsung+A50
    List<WebElement> searchResultsWithFourPriceOffersOrLess= driver.findElements(By.xpath(".//div[contains(@class,'top5-prices')][count(*)<=4]"));
    WebElement parameterFiltersBlock = driver.findElement(By.xpath(".//label[@for='price_min_']/ancestor::form"));
    WebElement itemsSortingLowToHighPrice = driver.findElement(By.xpath(".//div[@id='sorters-filters']/child::a[last()-1]"));
    List<WebElement> inputsForMinAndMaxPrice = driver.findElements(By.xpath(".//label[@for='price_max_']/preceding-sibling::input|.//label[@for='price_max_']/following-sibling::input"));
    //https://price.ua/avtozapchasti.html?itm_source=banner2_avtozapchasti
    List<WebElement> autopartsCategories = driver.findElements(By.xpath(".//div[contains(@class,'list-item') and count(*)>=30]"));
    WebElement literalIndexesTab = driver.findElement(By.xpath(".//ul/parent::div[contains(@class,'tab-avto-brand')]"));
    WebElement oilFiltersCategory = driver.findElement(By.xpath(".//div[contains(@class,'to-list')]/div[6 mod 7]"));
    List<WebElement> breadcrumbsWithoutArrowsBetween = driver.findElements(By.xpath(".//div[@class='breadcrumbs']/span[not(contains(@class,'crumb '))]"));
}
