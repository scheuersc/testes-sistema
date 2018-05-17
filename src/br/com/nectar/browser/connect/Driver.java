package br.com.nectar.browser.connect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

	private static String projectLocation = System.getProperty("user.dir");
	
	public static WebDriver initSafari () {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver browser = new SafariDriver();
		return browser;
	}
	
	public static WebDriver initChrome () {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver browser = new ChromeDriver();
		return browser;
	}
	
	public static WebDriver initFirefox() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		WebDriver browser = new FirefoxDriver();
		return browser;
	}
}
