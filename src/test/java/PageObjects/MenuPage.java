package PageObjects;

import Enun.Menu;
import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private WebDriver driver;
    private Waits waits;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getMenuByIndex(Menu index){
        return waits.visibilityOfElement(By.xpath("//*[@class='navbar-collapse']/ul/li[" + index.toString() + "]"));
    }

    public WebElement getMenuSubItenAddAccount(){
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[2]/ul/li[1]/a"));
    }

    public WebElement getMenuSubItenListAccount(){
        return driver.findElement(By.xpath("//*[@id='navbar']/ul/li[2]/ul/li[2]/a"));
    }
}
