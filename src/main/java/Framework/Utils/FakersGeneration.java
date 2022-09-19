package Framework.Utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String firstName;
    private String email;
    private String password;
    private int type;
    private String transactionDate;
    private String paymentDate;
    private String description;
    private String interested;
    private double value;

    public FakersGeneration(WebDriver driver){
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getFirstName(){
        firstName = faker.name().firstName();
        return firstName;
    }

    public String getEmail(){
        email = faker.internet().emailAddress();
        return email;
    }

    public String getPassword(){
        password = faker.internet().password();
        return password;
    }

    public int getType() {
        type = faker.number().numberBetween(1, 2);
        return type;
    }

    public String getTransactionDate() {
        transactionDate = DateTime.formatSimpleDateFormat(faker.date().birthday(0, 12));
        return transactionDate;
    }

    public String getPaymentDate() {
        paymentDate = DateTime.formatSimpleDateFormat(faker.date().birthday(0, 12));
        return paymentDate;
    }

    public String getDescription() {
        description = faker.lorem().characters(10, 30);
        return description;
    }

    public String getInterested() {
        interested = faker.name().firstName();
        return interested;
    }

    public double getValue() {
        value = faker.number().randomDouble(2, 100,1000);
        return value;
    }
}
