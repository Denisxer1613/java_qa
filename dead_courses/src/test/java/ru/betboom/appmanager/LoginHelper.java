package ru.betboom.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHelper {
    ChromeDriver driver;

  public void sendForm() {
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .btn--primary")).click();
  }

  public void fillForm(String login, String password) {
    driver.findElement(By.id("login_input")).click();
    driver.findElement(By.id("login_input")).sendKeys(login);
    driver.findElement(By.id("log_pass_input")).click();
    driver.findElement(By.id("log_pass_input")).sendKeys(password);
  }

  public void findAuthButton() {
    driver.findElement(By.cssSelector("#header > nav > div > div.nav__right > div > a.auth__btn.btn.btn--secondary.js-login-trigger.js-gtm-click-login-header")).click();
  }
}
