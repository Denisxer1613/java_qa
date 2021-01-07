package ru.betboom.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager extends LoginHelper {
  JavascriptExecutor js;
  private ChromeDriver driver;
  private Map<String, Object> vars;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\java_qa\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    openSite();
  }

  private void openSite() {
    driver.get("https://bboncyp-onl-1.bb-online-stage.com/");
    driver.manage().window().setSize(new Dimension(1920, 1080));
  }

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

  public void stop() {
    driver.quit();
  }
}
