package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AddAccountPage;
import PageObjects.GenericPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountValidation {
    private WebDriver driver;
    private GenericPage genericPage;
    private AddAccountPage addAccountPage;
    private Waits waits;

    public AccountValidation(WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(driver);
        addAccountPage = new AddAccountPage(driver);
        waits = new Waits(this.driver);
    }

    public void validationAddAccountPage(){
        try {
            waits.loadElement(addAccountPage.getNameTextField());
            Assertions.assertEquals(true, addAccountPage.getNameTextField().isDisplayed(), "Não esta visível");
            Report.log(Status.PASS, "Acessou a página cadastro de contas com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMessageRegistrationNewAccount(){
        try {
            waits.loadElement(genericPage.getAlertMessage());
            Assertions.assertEquals(true, genericPage.getAlertMessage().isDisplayed(), "Não esta visível");
            Assertions.assertEquals("Conta adicionada com sucesso!", genericPage.getAlertMessage().getText(), "Mensagem esta incoreta");
            Report.log(Status.PASS, "Reaizou o cadastro de uma nova conta com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
