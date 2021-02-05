package ru.betboom.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginHelper {
    ChromeDriver driver;

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
//    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector(".js-alertbar-msg-flash > .icon")).click();
//    driver.findElement(By.cssSelector(".account-menu:nth-child(2) > .account-menu__item:nth-child(1) .account-menu__title")).click();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    WebDriverWait wait2 = new WebDriverWait(driver, 10);
//    wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".account-menu:nth-child(2) > .account-menu__item:nth-child(1) .account-menu__title")));
//    driver.findElement(By.cssSelector(".account-menu:nth-child(2) > .account-menu__item:nth-child(1) .account-menu__title")).click();
    driver.findElement(By.cssSelector(".js-alertbar-msg-flash > .icon")).click();
    WebElement ele = driver.findElement(By.cssSelector(".account-menu:nth-child(2) > .account-menu__item:nth-child(1) .account-menu__title"));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", ele);
  }

  public void qiwiPay(String amount) {
    driver.findElement(By.cssSelector(".tabs__content-item:nth-child(1) .payinout__control-item:nth-child(2) > .lk-ident__control-txt")).click();
    driver.findElement(By.cssSelector(".js-payin-form-qiwi #sum")).click();
    driver.findElement(By.cssSelector(".js-payin-form-qiwi #sum")).sendKeys(amount);
    driver.findElement(By.cssSelector(".js-payin-form-qiwi .btn")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
}
