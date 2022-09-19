package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.MovementPage;
import PageObjects.GenericPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MovementValidation {
    private WebDriver driver;
    private GenericPage genericPage;
    private MovementPage createMovementPage;
    private Waits waits;

    public MovementValidation(WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(driver);
        createMovementPage = new MovementPage(driver);
        waits = new Waits(this.driver);
    }

    public void validationCreateMovementPage(){
        try {
            waits.loadElement(createMovementPage.getDescriptionTextField());
            Assertions.assertEquals(true, createMovementPage.getDescriptionTextField().isDisplayed(), "Não esta visível");
            Report.log(Status.PASS, "Acessou a página criar movimentação com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMessageRegistrationNewMovement(){
        try {
            waits.loadElement(genericPage.getAlertMessage());
            Assertions.assertEquals(true, genericPage.getAlertMessage().isDisplayed(), "Não esta visível");
            Assertions.assertEquals("Movimentação adicionada com sucesso!", genericPage.getAlertMessage().getText(), "Mensagem esta incoreta");
            Report.log(Status.PASS, "Reaizou o cadastro de uma nova movimentação com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
