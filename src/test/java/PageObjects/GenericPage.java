package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {
    private WebDriver driver;
    private Waits waits;

    public GenericPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAlertMessage(){
        return waits.visibilityOfElement(By.cssSelector("body > div.alert.alert-success"));
    }

    public WebElement getSubmitButton(){
        return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
    }
}
