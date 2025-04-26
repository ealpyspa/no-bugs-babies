package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    // negative
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // Подготовка
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        // Шаги
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Eva");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Ford");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        // Проверка ожидаемого результата
        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        // все оставшиеся обязательные поля
        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.should(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.should(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.should(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.should(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.should(Condition.exactText("Password confirmation is required."));
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
