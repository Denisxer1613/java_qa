package ru.betboom.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
  WebDriver driver;

  private final LoginHelper loginHelper = new LoginHelper();
  JavascriptExecutor js;
  private Map<String, Object> vars;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\d_podoinikov\\Documents\\java_qa\\chromedriver\\chromedriver.exe");
    System.setProperty("webdriver.gecko.driver","C:\\Users\\d_podoinikov\\Documents\\java_qa\\geckodriver\\geckodriver.exe");
    System.setProperty("webdriver.edge.driver","C:\\Users\\d_podoinikov\\Documents\\java_qa\\edgedriver_win64\\msedgedriver.exe");

    if (browser.equals(BrowserType.CHROME)) {
      loginHelper.driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX)) {
      loginHelper.driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      loginHelper.driver = new EdgeDriver();
    }
    loginHelper.driver = new ChromeDriver();
    js = (JavascriptExecutor) loginHelper.driver;
    vars = new HashMap<String, Object>();
    openSite();
  }

  private void openSite() {
    loginHelper.driver.get("https://bboncyp-newapp.bb-online-stage.com/");
    loginHelper.driver.manage().window().maximize();
  }


  public void stop() {
    loginHelper.driver.quit();
  }

  public LoginHelper getLoginHelper() {
    return loginHelper;
  }
}
