package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getEmailTextField(){
        return waits.visibilityOfElement(By.id("email"));
    }

    public WebElement getPasswordTextField(){
        return waits.visibilityOfElement(By.id("senha"));
    }

    public WebElement getNameTextField(){
        return waits.visibilityOfElement(By.id("nome"));
    }

}
