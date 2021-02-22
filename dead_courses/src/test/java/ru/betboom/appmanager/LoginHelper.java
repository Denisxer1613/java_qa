package ru.betboom.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginHelper {
    WebDriver driver;

  public void findAuthButton() {
    driver.findElement(By.cssSelector("#header > nav > div > div.nav__right > div > a.auth__btn.btn.btn--secondary.js-login-trigger.js-gtm-click-login-header")).click();
  }

  public void fillForm(String login, String password) {
    driver.findElement(By.id("login_input")).click();
    driver.findElement(By.id("login_input")).sendKeys(login);
    driver.findElement(By.id("log_pass_input")).click();
    driver.findElement(By.id("log_pass_input")).sendKeys(password);
  }

  public void sendForm() {
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .btn--primary")).click();
  }

  public void openPaymentsPage() {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    if (isElementPresent(By.cssSelector(".js-alertbar-msg-flash > .icon"))) {
      driver.findElement(By.cssSelector(".js-alertbar-msg-flash > .icon")).click();
    }
    driver.navigate().to("https://bboncyp-newapp.bb-online-stage.com/lobby/payinpayout");
//      driver.findElement(By.name("icon icon-account icon--white")).click();
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    JavascriptExecutor executor = (JavascriptExecutor)driver;
//    executor.executeScript("arguments[0].click();", ele);
//      driver.findElement(By.className("account-menu__title")).click();
  }

  public void qiwiPay(String amount) {
    driver.findElement(By.cssSelector(".tabs__content-item:nth-child(1) .payinout__control-item:nth-child(2) > .lk-ident__control-txt")).click();
    driver.findElement(By.cssSelector(".js-payin-form-qiwi #sum")).click();
    driver.findElement(By.cssSelector(".js-payin-form-qiwi #sum")).sendKeys(amount);
    driver.findElement(By.cssSelector(".js-payin-form-qiwi .btn")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public void openPayOutPage() {
    driver.findElement(By.linkText("Выплата")).click();

  }

  public void openQiwiPayOutService() {
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/ul/li[2]")).click();
  }

  public void payOutMoneyQiwi(String amount, String smsCode) {
    driver.findElement(By.cssSelector("#accountQiwiTab > form > fieldset > div")).click();
    driver.findElement(By.cssSelector(".js-payout-form-qiwi #sum")).sendKeys(amount);
    driver.findElement(By.cssSelector("#accountQiwiTab > form > div.payinout__btns > button")).click();
    driver.findElement(By.id("sms_code")).click();
    driver.findElement(By.id("sms_code")).sendKeys(smsCode);
    driver.findElement(By.cssSelector("#accountQiwiTab > form > div.payinout__btns > button")).click();
  }

  public void succesOrFail() {
    if (isElementPresent(By.id("payoutSuccessTab"))) {
      return;
  }
}

  private boolean isElementPresent(By payoutSuccessTab) {
    try {
      driver.findElement(payoutSuccessTab);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
  }
