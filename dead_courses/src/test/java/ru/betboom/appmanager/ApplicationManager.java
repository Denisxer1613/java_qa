package ru.betboom.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

  private final LoginHelper loginHelper = new LoginHelper();
  JavascriptExecutor js;
  private Map<String, Object> vars;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\d_podoinikov\\Documents\\java_qa\\chromedriver\\chromedriver.exe");
    loginHelper.driver = new ChromeDriver();
    js = (JavascriptExecutor) loginHelper.driver;
    vars = new HashMap<String, Object>();
    openSite();
  }

  private void openSite() {
    loginHelper.driver.get("https://bboncyp-newapp.bb-online-stage.com/");
    loginHelper.driver.manage().window().setSize(new Dimension(1920, 1080));
  }


  public void stop() {
    loginHelper.driver.quit();
  }

  public LoginHelper getLoginHelper() {
    return loginHelper;
  }
}
