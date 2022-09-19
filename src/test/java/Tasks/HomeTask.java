package Tasks;

import Enun.Menu;
import Framework.Utils.User;
import PageObjects.HomePage;
import PageObjects.MenuPage;
import Validations.HomeValidation;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private static WebDriver driver;
    private static MenuPage menu;
    private static HomePage homePage;
    private static HomeValidation homeValidation;

    public HomeTask (WebDriver driver) {
        this.driver = driver;
        menu = new MenuPage(driver);
        homePage = new HomePage(driver);
        homeValidation = new HomeValidation(driver);
    }

    public void validationSaldo(User user){
        menu.getMenuByIndex(Menu.HOME).click();
        homeValidation.validationHomePage();
        homeValidation.validationSaldoMovement(user);
    }
}
