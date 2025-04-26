package org.example;

import com.codeborne.selenide.*;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    @BeforeAll
    public static void setUpUITest() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        // Configuration.browser = "firefox";
        // Configuration.timeout = 10;
    }

    // Принципы:
    // DRY = Don't repeat yourself
    // Веб элементы не ищутся в тесте, они ищутся в Page Object class
    // Автотест сам создает рандомизированные данные для себя

    // negative
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // page setup
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();
        // test data preparation
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString()).lastName(RandomData.randomString())
                .build();
        // steps
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        // все оставшиеся обязательные поля
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().should(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().should(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUserNameError().should(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().should(Condition.exactText("Password is required."));

        registerAccountPage.getRepeatedPasswordError().should(Condition.exactText("Password confirmation is required."));
    }

    // positive
    @Test
    public void userShouldBeAbleToRegisterAccount() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Eva");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Ford");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Pink Street");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("New York");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("USA");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("1234");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("123-456");

        SelenideElement userName = element(Selectors.byId("customer.username"));
        userName.sendKeys("eva96");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("7890");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("7890");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement successfulSalutation = element(Selectors.byXpath("//*[@id=\"rightPanel\"]/h1"));
        successfulSalutation.shouldHave(Condition.exactText("Welcome eva96"));

        SelenideElement successfulMessage = element(Selectors.byXpath("//*[@id=\"rightPanel\"]/p"));
        successfulMessage.shouldHave(Condition.exactText("Your account was created successfully. You are now logged in."));
    }
}
