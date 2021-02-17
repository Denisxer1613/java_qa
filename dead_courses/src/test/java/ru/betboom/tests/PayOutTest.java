package ru.betboom.tests;

import org.junit.Test;

public class PayOutTest extends TestBase {

    @Test
    public void payOutTest() {
        app.getLoginHelper().findAuthButton();
        app.getLoginHelper().fillForm("9061112233", "12345678");
        app.getLoginHelper().sendForm();
        app.getLoginHelper().openPaymentsPage();
        app.getLoginHelper().openPayOutPage();
        app.getLoginHelper().openQiwiPayOutService();
        app.getLoginHelper().payOutMoneyQiwi("100", "111111");
        app.getLoginHelper().succesOrFail();

    }

}
