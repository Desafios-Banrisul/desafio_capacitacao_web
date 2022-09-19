package Tasks;

import Enun.Menu;
import Framework.Utils.Account;
import Framework.Utils.User;
import PageObjects.AddAccountPage;
import PageObjects.GenericPage;
import PageObjects.MenuPage;
import Validations.AccountValidation;
import org.openqa.selenium.WebDriver;

public class AccountTask {
    private static WebDriver driver;
    private GenericPage genericPage;
    private AddAccountPage addAccountPage;
    private AccountValidation accountValidation;
    private MenuPage menuPage;

    public AccountTask (WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(driver);
        addAccountPage = new AddAccountPage(driver);
        accountValidation = new AccountValidation(driver);
        menuPage = new MenuPage(driver);
    }

    public void registrationNewAccount(User user, String name){
        Account account = new Account();
        account.setName(name);
        user.getListAccount().add(account);

        menuPage.getMenuByIndex(Menu.ACCOUNT).click();
        menuPage.getMenuSubItenAddAccount().click();
        accountValidation.validationAddAccountPage();
        addAccountPage.getNameTextField().sendKeys(name);
        genericPage.getSubmitButton().click();
        accountValidation.validationMessageRegistrationNewAccount();
    }
}
