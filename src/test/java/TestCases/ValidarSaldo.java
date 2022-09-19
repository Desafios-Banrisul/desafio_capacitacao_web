package TestCases;

import Enun.TypeMovement;
import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.Account;
import Framework.Utils.User;
import Tasks.AccountTask;
import Tasks.HomeTask;
import Tasks.MovementTask;
import Tasks.LoginTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ValidarSaldo extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(driver);
    AccountTask accountTask = new AccountTask(driver);
    MovementTask movementTask = new MovementTask(driver);
    HomeTask homeTask = new HomeTask(driver);

    @Test
    @Tag("regressao")
    public void ValidarSaldoConformeMovimentaçõesCriadas(){
        try {
            Report.creatTest("Validando saldo conforme a movimentação criada com sucesso", ReportType.SINGLE);
            User user = loginTask.creatUser();

            loginTask.registrationNewUser(user);
            loginTask.login(user);

            Account receitas =  accountTask.registrationNewAccount(user, "Receitas");
            Account despesas =  accountTask.registrationNewAccount(user, "Despesas");

            movementTask.registrationNewMovement(receitas, TypeMovement.RECEITA);

            movementTask.registrationNewMovement(despesas, TypeMovement.RECEITA);
            movementTask.registrationNewMovement(despesas, TypeMovement.DESPESA);

            homeTask.validationSaldo(user);
        }catch (Exception e){
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
