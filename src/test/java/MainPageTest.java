import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private String baseUrl;
    private String email;
    private String password;
    private String regEmail;
    private String regPassword;
    private String empty = "";
    private String searchRequest;

    @BeforeClass
    public void setUp() {
        String commonProperties = "src/main/resources/test-properties.properties";
        Properties properties = new Properties();

        if (commonProperties != null) {
            try {
                properties.load(new FileReader(commonProperties));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        baseUrl = properties.getProperty("baseurl");
        email = properties.getProperty("validemail");
        password = properties.getProperty("validpassword");
        regEmail = properties.getProperty("regemail");
        regPassword = properties.getProperty("regpassword");
        searchRequest = properties.getProperty("searchrequest");
        driver.get(baseUrl);
        mainPage = new MainPage(driver);
    }


    @Test
    public void checkPositiveLoginScenario() {
        mainPage.fillLoginForm(email, password);
        Assert.assertNotEquals(mainPage.getAccountName(), "Вход", "Text doesn't change in authentication block");
    }

    @Test
    public void checkNegativeLoginScenario() {
        mainPage.fillLoginForm(email, regPassword);
        Assert.assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    public void checkPositiveRegistrationScenario() {
        mainPage.fillRegistrationForm(regEmail, regPassword);
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class = 'reg-success-text']")).isDisplayed(), "Successful registration message doesn't appear");
    }

    @Test
    public void checkNegativeRegistrationScenario() {
        mainPage.fillRegistrationForm(email, regPassword);
        Assert.assertTrue(mainPage.checkErrorLoginMessageAppears(), "Error message doesn't appears");
    }

    @Test
    public void searchStartsTest() {
        mainPage.runSearch(searchRequest);
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='page-breadcrumbs']")));
        Assert.assertTrue(driver.getTitle().contains("Поиск"), "Search page doesn't open");
    }

}
