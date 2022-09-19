package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.User;
import PageObjects.GenericPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidation {
    private WebDriver driver;
    private LoginPage loginPage;
    private  GenericPage genericPage;
    private Waits waits;

    public LoginValidation(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationLoginPage(){
        try {
            waits.loadElement(loginPage.getEmailTextField());
            Assertions.assertEquals(true, loginPage.getEmailTextField().isDisplayed(), "Não esta visível");
            Report.log(Status.PASS, "Acessou a página de login com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationNewUserPage(){
        try {
            waits.loadElement(loginPage.getNameTextField());
            Assertions.assertEquals(true, loginPage.getNameTextField().isDisplayed(), "Não esta visível");
            Report.log(Status.PASS, "Acessou a página cadastro Novo Usuário com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMessageRegistrationNewUser(){
        try {
            waits.loadElement(genericPage.getAlertMessage());
            Assertions.assertEquals(true, genericPage.getAlertMessage().isDisplayed(), "Não esta visível");
            Assertions.assertEquals("Usuário inserido com sucesso", genericPage.getAlertMessage().getText(), "Mensagem esta incoreta");
            Report.log(Status.PASS, "Reaizou o cadastro de um novo usuário com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMessageLoginSuccess(User user){
        try {
            waits.loadElement(genericPage.getAlertMessage());
            Assertions.assertEquals(true, genericPage.getAlertMessage().isDisplayed(), "Não esta visível");
            Assertions.assertEquals("Bem vindo, " + user.getName() + "!", genericPage.getAlertMessage().getText(), "Mensagem esta incoreta");
            Report.log(Status.PASS, "Reaizou o login com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
