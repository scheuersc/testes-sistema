package br.com.nectar.browser;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

	private static String projectLocation = System.getProperty("user.dir");
	private final static String URL = "http://172.16.186.128:10100";
	
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
