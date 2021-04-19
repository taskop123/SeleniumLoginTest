package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import po.FrontPage;
import po.LoginPage;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoaded());
    }

    @Test
    public void testInvalidCredentialsLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("invalidUsername", "invalidPassword");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Userid or Password did Not Match !!");
    }

    @Test
    public void testEmptyUsernameLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("", "tasko.pavlov");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Userid or Password did Not Match !!");
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tasko.pavlov", "tasko.pavlov");
        Assert.assertTrue(new FrontPage(driver).isLoaded());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/tashko/Documents/6(VI)-Semester/SoftwareQualityAndTesting/Homeworks/Homework_3/src/main/resources/drivers/chromedriver");

        return new ChromeDriver();
    }

}
