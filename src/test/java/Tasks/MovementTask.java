package Tasks;

import Enun.Menu;
import Enun.TypeAccount;
import Enun.TypeMovement;
import Framework.Utils.CreateFolder;
import Framework.Utils.FakersGeneration;
import Framework.Utils.User;
import PageObjects.MovementPage;
import PageObjects.GenericPage;
import PageObjects.MenuPage;
import Validations.MovementValidation;
import org.openqa.selenium.WebDriver;

public class MovementTask {
    private static WebDriver driver;
    private static MovementPage createMovementPage;
    private static MovementValidation createMovementValidation;
    private static FakersGeneration fakersGeneration;
    private static MenuPage headerPage;
    private static GenericPage genericPage;

    public MovementTask(WebDriver driver){
        this.driver = driver;
        createMovementPage = new MovementPage(driver);
        createMovementValidation = new MovementValidation(driver);
        fakersGeneration = new FakersGeneration(driver);
        headerPage = new MenuPage(driver);
        genericPage = new GenericPage(driver);
    }

    public void registrationNewMovement(User user, TypeMovement type, TypeAccount typeAccount){
        CreateFolder.Movement movement = new CreateFolder.Movement();
        movement.setType(type.toString());
        movement.setTransactionDate(fakersGeneration.getTransactionDate());
        movement.setPaymentDate(fakersGeneration.getPaymentDate());
        movement.setDescription(fakersGeneration.getDescription());
        movement.setInterested(fakersGeneration.getInterested());
        movement.setValue(String.valueOf(fakersGeneration.getValue()));
        movement.setAccountSelect(typeAccount.toString());
        user.getListMovement().add(movement);

        headerPage.getMenuByIndex(Menu.CREATE_MOVEMENT).click();
        createMovementValidation.validationCreateMovementPage();
        createMovementPage.getTypeSelect().selectByValue(type.toString());
        createMovementPage.getTransactionDateTextField().sendKeys(movement.getTransactionDate());
        createMovementPage.getPaymentDateTextField().sendKeys(movement.getPaymentDate());
        createMovementPage.getDescriptionTextField().sendKeys(movement.getDescription());
        createMovementPage.getInterestedTextField().sendKeys(movement.getInterested());
        createMovementPage.getValueTextField().sendKeys(movement.getValue());
        createMovementPage.getAccountSelect().selectByVisibleText(movement.getAccountSelect());
        createMovementPage.getStatusPagoRadio().click();
        genericPage.getSubmitButton().click();
        createMovementValidation.validationMessageRegistrationNewMovement();
    }
}
