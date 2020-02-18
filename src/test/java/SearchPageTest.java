import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchPageTest extends BaseTest {

    /*@Test
    public void relevantSearchTest() {
        //mainPage.runSearch(searchRequest);
        List<WebElement> elements = driver.getSearchElements();
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
