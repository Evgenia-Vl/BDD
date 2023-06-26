package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

class MoneyTransferTest {
    DashboardPage dashboardPage;

    @BeforeEach
    public void setup() {
        open("http://localhost:9999");
        var LoginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Test
    public void transferFromCardToCard0() {
        int firstCardBalance = dashboardPage.getCardBalance(0);
        int secondCardBalance = dashboardPage.getCardBalance(1);
        var amount = 5_000;
        var expectedBalanceOneCard = firstCardBalance - amount;
        var expectedBalanceTwoCard = secondCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(getSecondCardNumber());
        dashboardPage = transferPages.transferMoney(5_000, getFirstCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard, actualBalanceTwoCard);
    }
}

