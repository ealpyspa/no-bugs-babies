package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Data
public class RegisterAccountPage {
    // добавить все важные веб элементы странички в ПОЛЯ
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput= element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    // errors
    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    private SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));

    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    private SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        registerButton.click();
    }
}
