package ru.betboom.tests;

import org.junit.Test;

public class PromocodeTest extends TestBase {

   @Test
  public  void testPromocode() {
     app.getLoginHelper().findAuthButton();
     app.getLoginHelper().fillForm("9991111111", "11111111");
     app.getLoginHelper().sendForm();
     app.getLoginHelper().initProfile();
     app.getLoginHelper().enterPromocode("PROMO");
   }
}
