package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("http://www.testyou.in/Login.aspx");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ctl00$CPHContainer$txtUserLogin"))).isDisplayed();
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).clear();
        driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
        Thread.sleep(2000);
    }

    public String getErrorMessage(){
        WebElement element = driver.findElement(By.id("ctl00_CPHContainer_lblOutput"));

        return element.getText();
    }

}

