package br.com.nectar.main;

import br.com.nectar.test.unit.CashierTest;

public class RunAllTests {

	private static final String projectLocation = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		// Apontar ao driver do Selenium
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		CashierTest objCashierTest = new CashierTest();
		objCashierTest.all();
	}

}
