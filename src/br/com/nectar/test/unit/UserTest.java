package br.com.nectar.test.unit;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.autentication.Login;
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
		String result = objUsers.testSearchUserRegistry(URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "TESTE AUTOMATIZADO V2.0.2.1");
		boolean booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testSearchUserRegistry(URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "TESTE AUTOMATIZADO V2.0.2.1");
		booResult = false;
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void usersRegistry() {
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testUserRegistry(URL, username, password, "Teste Automatizado v2.0.2.1", "01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		boolean booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		objUsers = new Users (new FirefoxDriver());
		result = objUsers.testUserRegistry(URL, username, password, "Teste Automatizado v2.0.2.1", "01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
	}

	@Test
	public void usersRegistryValidateEmail() throws InterruptedException {
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testUserRegistryValidateEmail(URL, username, password, "Teste Automatizado v2.0.2.1", "'011teste@teste.com", "52359241001", "CAIXA", "48999999999", "48996307564");
		
		boolean booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		
		
		/*
		objUsers = new Users (new ChromeDriver());
		result = objUsers.testUserRegistryValidateEmail(URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "Teste Automatizado v2.0.2.1", "'01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		*/
		
	}
	
	@Test
	public void userAlertRegistryValidate () throws InterruptedException {
		String name = "Teste Automatizado v2.0.2";
		String email = "'011teste@teste.com";
		String cpf = "73627138430";
		String group = "CAIXA";
		String disLimit = "48999999999";
		String cel = "48996307564";
		Login objLogin = new Login(new ChromeDriver());
		WebDriver browser = objLogin.autentication(URL, username, password);
		
		/*
		 * Teste do formulário de cadastro de usuário
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys(name);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_email")).sendKeys(email);
		//browser.findElement(By.name("frm")).findElement(By.name("prop_txt_cpf")).sendKeys(cpf);
		
		
		/*
		 * Preencher combobox sem possuir valores relatados no html.
		 * */
		browser.findElement(By.xpath("//select[@id='prop_txt_codigoGrupo']")).sendKeys(group);;
		
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_limiteDesconto")).sendKeys(disLimit);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_celular")).sendKeys(cel);

		browser.findElement(By.id("btn_salvar")).click();
		//browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * Bloco de validação de resultados do método
		 * 
		 * */
		System.out.println("Exibir menssagem de alert!");
		
		Alert alerta = browser.switchTo().alert();
		
		Thread.sleep(3000);
		//System.out.println("Message: "+alerta.getText());
		alerta.accept();
		Thread.sleep(3000);
		alerta.accept();
		
		System.out.println("Exibiu menssagem de alert!");
		
		//Alert alert = browser.switchTo().alert();
		//alert.accept();
		//System.out.println("Mensagem de alert: " + alert.getText());
		
		
		String results = browser.findElement(By.id("toString")).getText();
		/*
		Users objUsers = new Users (new ChromeDriver());
		String result = objUsers.testUserAlertRegistryValidate(URL, username, password, "Teste Automatizado v2.0.2", "'011teste@teste.com", "73627138430", "CAIXA", "48999999999", "48996307564");
		
		boolean booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		*/
		
		/*
		objUsers = new Users (new ChromeDriver());
		result = objUsers.testUserRegistryValidateEmail(URL, "suporte@marconsoft.com.br", "!efacil#rul3z", "Teste Automatizado v2.0.2.1", "'01teste@teste.com", "87206673708", "CAIXA", "48999999999", "20");
		booResult = false;
		System.out.println("Result: " + result);
		if (result.contains("Cadastro de Usuario, ID")) {
			booResult = true;
		}
		Assert.assertEquals(booResult, true);
		*/
		
	}
	
}