package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSaldoReceita(){
        return waits.visibilityOfElement(By.xpath("//*[@id='tabelaSaldo']/tbody/tr[1]/td[2]"));
    }

    public WebElement getSaldoDespesa(){
        return waits.visibilityOfElement(By.xpath("//*[@id='tabelaSaldo']/tbody/tr[2]/td[2]"));
    }
}
