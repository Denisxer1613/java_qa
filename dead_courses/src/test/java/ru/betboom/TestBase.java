package ru.betboom;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
  JavascriptExecutor js;
  private ChromeDriver driver;
  private Map<String, Object> vars;

  @Before
  public void setUp() {
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

  protected void sendForm() {
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > .btn--primary")).click();
  }

  protected void fillForm(String login, String password) {
    driver.findElement(By.id("login_input")).click();
    driver.findElement(By.id("login_input")).sendKeys(login);
    driver.findElement(By.id("log_pass_input")).click();
    driver.findElement(By.id("log_pass_input")).sendKeys(password);
  }

  protected void findAuthButton() {
    driver.findElement(By.cssSelector("#header > nav > div > div.nav__right > div > a.auth__btn.btn.btn--secondary.js-login-trigger.js-gtm-click-login-header")).click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
