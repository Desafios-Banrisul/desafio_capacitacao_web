package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccountPage {
    private WebDriver driver;
    private Waits waits;

    public AddAccountPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNameTextField(){
        return waits.visibilityOfElement(By.id("nome"));
    }
}
