import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest{

    @Test
    public void checkNegativeLogin() {
        openMainPage();
        driver.findElement(By.xpath("//div[contains(@class,'link for-login')]")).click();
        driver.findElement(By.id("LoginForm_username")).sendKeys("bu9ira@gmail.com");
        driver.findElement(By.id("login_user_password")).sendKeys("test20100");
        driver.findElement(By.xpath("//div[contains(@class,'pt_20')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-text'][contains(text(),'.')]")).getText(), "Неверное имя пользователя или пароль.");
        driver.quit();
    }
}
