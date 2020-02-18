import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ErrorMessageTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        openMainPage();
        driver.findElement(By.xpath("//div[contains(@class,'link for-login')]")).click();
    }

    @Test
    public void blankEmailErrorMessageTest() {
        driver.findElement(By.id("login_user_password")).sendKeys("test20100");
        driver.findElement(By.xpath("//div[contains(@class,'pt_20')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'«')]")).getText(), "Необходимо заполнить поле «Адрес электронной почты».");
    }

    @Test
    public void blankPasswordErrorMessageTest() {
        driver.findElement(By.id("LoginForm_username")).sendKeys("bu9ira@gmail.com");
        driver.findElement(By.xpath("//div[contains(@class,'pt_20')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-text'][contains(text(),'.')]")).getText(), "Необходимо заполнить поле «Пароль».");
    }

    @Test
    public void spellEmailErrorMessageTest() {
        driver.findElement(By.id("go-tab-userregister")).click();
        driver.findElement(By.id("RegisterUserFirmForm_user_email")).sendKeys("bu9ira-gmail.com");
        driver.findElement(By.id("user_user_password")).sendKeys("test20100");
        driver.findElement(By.xpath("//div[contains(@class,'mt_10')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-M')]")).getText(), "Адрес электронной почты не является правильным E-Mail адресом.");
    }

    @Test
    public void spellPasswordErrorMessageTest() {
        driver.findElement(By.id("go-tab-userregister")).click();
        driver.findElement(By.id("RegisterUserFirmForm_user_email")).sendKeys("MyName@gmail.com");
        driver.findElement(By.id("user_user_password")).sendKeys(";test2010");
        driver.findElement(By.xpath("//div[contains(@class,'mt_10')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='form-line required-star clearer-block with-black-error']//div[@class='error-text']")).getText(), "Пароль содержит неверные символы");
    }

    @Test
    public void existedEmailRegistrationErrorMessageTest() {
        driver.findElement(By.id("go-tab-userregister")).click();
        driver.findElement(By.id("RegisterUserFirmForm_user_email")).sendKeys("bu9ira@gmail.com");
        driver.findElement(By.id("user_user_password")).sendKeys("test2010");
        driver.findElement(By.xpath("//div[contains(@class,'mt_10')]")).click();
        Assert.assertTrue(driver.findElement(By.className("error-text")).isDisplayed(), "Error message appears");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'email')]")).getText(), "Такой email уже существует.");
    }

    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
