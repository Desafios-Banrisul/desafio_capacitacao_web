package Tasks;

import Enun.Menu;
import Framework.Utils.FakersGeneration;
import Framework.Utils.User;
import PageObjects.GenericPage;
import PageObjects.MenuPage;
import PageObjects.LoginPage;
import Validations.LoginValidation;
import org.openqa.selenium.WebDriver;


public class LoginTask {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static LoginValidation loginValidation;
    private static FakersGeneration fakersGeneration;
    private static MenuPage headerPage;
    private static GenericPage genericPage;

    public LoginTask (WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(driver);
        fakersGeneration = new FakersGeneration(driver);
        headerPage = new MenuPage(driver);
        genericPage = new GenericPage(driver);
    }

    public User creatUser(){
        User user = new User();
        user.setName(fakersGeneration.getFirstName());
        user.setEmail(fakersGeneration.getEmail());
        user.setPassword(fakersGeneration.getPassword());
        return user;
    }

    public void login(User user){
        loginValidation.validationLoginPage();
        loginPage.getEmailTextField().sendKeys(user.getEmail());
        loginPage.getPasswordTextField().sendKeys(user.getPassword());
        genericPage.getSubmitButton().click();
        loginValidation.validationMessageLoginSuccess(user);
    }

    public void registrationNewUser(User user){
        loginValidation.validationLoginPage();
        headerPage.getMenuByIndex(Menu.NEW_USER).click();
        loginValidation.validationNewUserPage();
        loginPage.getNameTextField().sendKeys(user.getName());
        loginPage.getEmailTextField().sendKeys(user.getEmail());
        loginPage.getPasswordTextField().sendKeys(user.getPassword());
        genericPage.getSubmitButton().click();
        loginValidation.validationMessageRegistrationNewUser();
    }
}
