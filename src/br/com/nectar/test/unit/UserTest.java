package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.register.Users;
import br.com.nectar.utils.Util;;

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
		String name = "TESTE AUTOMATIZADO V2.0.2.1";
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testSearch (URL, username, password, name);
		boolean booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testSearch (URL, username, password, name);
		booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void saveUsers () {
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@" + Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testSave (URL, username, password, name, email, Util.gerarCPFValido(), group, phone, disLimit);
		boolean booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testSave (URL, username, password, name, email, Util.gerarCPFValido(), group, phone, disLimit);
		booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void validateSaveUsers () throws InterruptedException {
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@" + Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		String cpf = "";//Util.gerarCPFValido();
		Boolean booResult = false;
		
		Users objUsers = new Users (new FirefoxDriver());
		booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, phone);
		Assert.assertEquals(true, booResult);
		
		objUsers = new Users(new ChromeDriver());
		booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, phone);
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