package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleUITest {
    private RegisterAccountPage registerAccountPage;

    // Принципы:
    // DRY = Don't repeat yourself
    // Веб элементы не ищутся в тесте, они ищутся в Page Object class
    // Автотест сам создает рандомизированные данные для себя

    @BeforeAll
    public static void setUpUITest() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        // Configuration.browser = "firefox";
        // Configuration.timeout = 10;
    }

    @BeforeEach
    public void setUpPage() {
        registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();
    }

    // negative
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // test data preparation
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString()).lastName(RandomData.randomString())
                .build();
        // steps
        registerAccountPage.unsuccessfulRegister(bankAccount);

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
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomString())
                .ssn(RandomData.randomString())
                .userName(RandomData.randomString())
                .password(RandomData.randomString())
                .build();

        registerAccountPage.successfulRegister(bankAccount);

        registerAccountPage.getSuccessfulSalutation().shouldHave(Condition.exactText("Welcome " + bankAccount.getUserName()));

        registerAccountPage.getSuccessfulMessage().shouldHave(Condition.exactText("Your account was created successfully. You are now logged in."));
    }
}
