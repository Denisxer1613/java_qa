package ru.betboom.tests;

import org.junit.Test;

public class PaymentsTest extends TestBase {

    @Test
    public void paymentsTest() {
        app.getLoginHelper().findAuthButton();
        app.getLoginHelper().fillForm("9061112233", "12345678");
        app.getLoginHelper().sendForm();
        app.getLoginHelper().openPaymentsPage();
        app.getLoginHelper().qiwiPay("100");

    }

}
