package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.financial.Cashier;

public class CashierTest {

	private static final String projectLocation = System.getProperty("user.dir");
	private String URL = "http://172.16.101.128:10100";
	private String username = "suporte@marconsoft.com.br";
	private String password = "!efacil#rul3z";
	
	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
	}
	
	@Test
	public void testSave() {
		String description = "Descrição de teste";
		String code = "2";
		String cpfCnpj = "13036276203";
		
		Cashier objCashier = new Cashier (new ChromeDriver());
		String result = objCashier.testSave(URL, username, password, description, code, cpfCnpj);
		boolean booResult = false;
		if (result.contains("Caixa, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void testSearch() {
		String description = "caixa loia";
		
		Cashier objCashier = new Cashier (new ChromeDriver());
		Boolean booResult = objCashier.testSearch(URL, username, password, description);
		Assert.assertEquals(booResult, true);
	}
	
	@Test
	public void testValidateSave() {
		String description = "";
		String code = "2";
		String cpfCnpj = "13036276203";
		
		Cashier objCashier = new Cashier (new ChromeDriver());
		boolean booResult = objCashier.testValidadeSave(URL, username, password, description, code, cpfCnpj);
		
		Assert.assertEquals(booResult, true);
	}
}
