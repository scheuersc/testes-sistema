package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.register.Users;;

public class UserTest {
		
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
	public void searchUsers() {
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testSearch (URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "TESTE AUTOMATIZADO V2.0.2.1");
		boolean booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testSearch (URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "TESTE AUTOMATIZADO V2.0.2.1");
		booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void saveUsers () {
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testSave (URL, username, password, "Teste Automatizado v2.0.2.1", "01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		boolean booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testSave (URL, username, password, "Teste Automatizado v2.0.2.1", "01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void validateSaveUsers () throws InterruptedException {
		String name = "";//Teste Automatizado v2.0.2.22";
		String email = "";//'2teste@teste.com";
		String cpf = "";//49737740653";
		String group = "CAIXA";
		String disLimit = "48999999999";
		String cel = "48996307564";
		Boolean booResult = false;
		
		Users objUsers = new Users (new FirefoxDriver());
		booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, cel);
		Assert.assertEquals(true, booResult);
		
		objUsers = new Users(new ChromeDriver());
		booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, cel);
		Assert.assertEquals(true, booResult);
	}

	@Test
	public void alertTest() throws InterruptedException {
		Users objUsers = new Users(new FirefoxDriver());
		Assert.assertEquals("Please enter a valid user name", objUsers.testesAlert());
		
		objUsers = new Users(new ChromeDriver());
		Assert.assertEquals("Please enter a valid user name", objUsers.testesAlert());
	}
}