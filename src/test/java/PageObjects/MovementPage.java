package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MovementPage {
    private WebDriver driver;
    private Waits waits;

    public MovementPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public Select getTypeSelect() {
        WebElement selectElement = driver.findElement(By.id("tipo"));
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public WebElement getTransactionDateTextField() {
        return driver.findElement(By.id("data_transacao"));
    }

    public WebElement getPaymentDateTextField() {
        return driver.findElement(By.id("data_pagamento"));
    }

    public WebElement getDescriptionTextField() {
        return driver.findElement(By.id("descricao"));
    }

    public WebElement getInterestedTextField() {
        return driver.findElement(By.id("interessado"));
    }

    public WebElement getValueTextField() {
        return driver.findElement(By.id("valor"));
    }

    public Select getAccountSelect() {
        WebElement selectElement = driver.findElement(By.id("conta"));
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public WebElement getStatusPagoRadio() {
        return waits.visibilityOfElement(By.id("status_pago"));
    }

    public WebElement getStatusPendenteRadio() {
        return waits.visibilityOfElement(By.id("status_pendente"));
    }
}
