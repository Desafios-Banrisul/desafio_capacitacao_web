package Validations;

import Framework.Browser.Waits;
import Framework.Utils.User;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeValidation {
    private WebDriver driver;
    private HomePage homePage;
    private Waits waits;

    public HomeValidation(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationHomePage(){
        try {
            waits.loadElement(homePage.getSaldoDespesa());
            Assertions.assertEquals(true, homePage.getSaldoDespesa().isDisplayed(), "Não esta visível");
            Report.log(Status.PASS, "Acessou a página home com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationSaldoMovement(User user){
        try {
            waits.loadElement(homePage.getSaldoDespesa());
            Assertions.assertEquals(user.getListMovement().get(1).getValue(), homePage.getSaldoDespesa().getText(), "Valor esta diferente despesa");
            Assertions.assertEquals(user.getListMovement().get(2).getValue(), homePage.getSaldoReceita().getText(), "Valor esta diferente receita");
            Report.log(Status.PASS, "Acessou a página home com sucesso", Screenshot.captureBase64(driver));

        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
