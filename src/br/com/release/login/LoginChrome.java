package br.com.release.login;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginChrome {
	
	private String projectLocation = System.getProperty("user.dir");
	private final static String URL = "http://172.16.186.128:10100";
	
	@Test
	public boolean testLoginInvalidoChrome() {

		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		browser.get(URL);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suport@marconsoft.com.br");
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z");
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String results = browser.findElement(By.id("containerErros")).findElement(By.id("erros")).getText();
		browser.quit();
		if (results.equals("Usuário ou senha invalidos!"))
			return true;
		return false;
	}
	
	@Test
	public boolean testLoginCorretoChrome() {

		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		browser.get(URL);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suporte@marconsoft.com.br");
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z");
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String results = browser.findElement(By.tagName("h4")).getText();
		browser.quit();
		if (results.equals("Clique na banca que deseja acessar:"))
			return true;
		return false;
	}
	
	@Test
	public boolean testLoginSQLInjectChrome() {

		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		browser.get(URL);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suport@marconsoft.com.br");
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z");
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String results = browser.findElement(By.id("containerErros")).findElement(By.id("erros")).getText();
		browser.quit();
		if (results.equals("Usuário ou senha invalidos!"))
			return true;
		return false;
	}

	@Test
	public boolean testLoginForcaBrutaChrome() {

		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String results; 
		
		for (int i = 0; i < 15; i++) {
			browser.get(URL);
			browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suporte@marconsoft.com.br");//não permitir mais que 3 tentativas de logar com o mesmo usuário no mesmo computador
			browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z" + 0);
			browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
			
			results = browser.findElement(By.id("containerErros")).findElement(By.id("erros")).getText();
		}

		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suporte@marconsoft.com.br");//Permitiu erro!
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z");
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		results = browser.findElement(By.tagName("h4")).getText();
		browser.quit();
		if (results.equals("Clique na banca que deseja acessar:"))
			return true;
		return false;
	}

}
