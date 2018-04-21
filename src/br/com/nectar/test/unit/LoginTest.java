package br.com.nectar.test.unit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.autentication.Login;

public class LoginTest {
	
	private static String projectLocation = System.getProperty("user.dir");
	private String URL = "http://172.16.101.128:10100";
	
	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
	}
	
	@Test
	public void loginIvalid() {
		Login objLogin = new Login(new FirefoxDriver());
		String result = objLogin.testInvalidLogin(URL, "suporte@marconsoft.com.br", "erro");
		System.out.println("Result: " + result);
		Assert.assertEquals(result, "Usuário ou senha invalidos!");
		
		objLogin = new Login(new ChromeDriver());
		result = objLogin.testInvalidLogin(URL, "suporte@marconsoft.com.br", "!efacil#rul3z11");
		Assert.assertEquals(result, "Usuário ou senha invalidos!");
	}
	
	@Test
	public void loginCorrect() {
		Login objLogin = new Login(new FirefoxDriver());
		String result = objLogin.testCorrectLogin(URL, "suporte@marconsoft.com.br", "!efacil#rul3z");
		Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		
		objLogin = new Login(new ChromeDriver());
		result = objLogin.testCorrectLogin(URL, "suporte@marconsoft.com.br", "!efacil#rul3z");
		Assert.assertEquals(result, "Clique na banca que deseja acessar:");
	}

	@Test
	public void formSqlInjectionLogin() {
		Login objLogin = new Login(new FirefoxDriver());
		String result = objLogin.testFormSqlInjectLogin(URL, "suport@marconsoft.com.br", "!efacil#rul3z'");
		Assert.assertEquals(result, "Usuário ou senha invalidos!");
		
		objLogin = new Login(new ChromeDriver());
		result = objLogin.testFormSqlInjectLogin(URL, "suport@marconsoft.com.br", "!efacil#rul3z'");
		Assert.assertEquals(result, "Usuário ou senha invalidos!");
	}
	
	@Test
	public void bruteForce() {
		Login objLogin = new Login(new ChromeDriver());
		String result = objLogin.testBruteForce(URL, "suporte@marconsoft.com.br", "!efacil#rul3z");
		Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		
		objLogin = new Login(new FirefoxDriver());
		result = objLogin.testBruteForce(URL, "suporte@marconsoft.com.br", "!efacil#rul3z");
		Assert.assertEquals(result, "Clique na banca que deseja acessar:");
	}

}