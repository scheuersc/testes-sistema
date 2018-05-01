package br.com.nectar.autentication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	private WebDriver browser = null;
	
	public Login(WebDriver driver) {
		this.browser = driver;
	}
	
	public String testInvalidLogin(String URL, String username, String password) {
		browser.get(URL);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String result = browser.findElement(By.id("containerErros")).findElement(By.id("erros")).getText();
		browser.quit();

		return result;
	}
	
	public String testCorrectLogin(String URL, String username, String password) {

		browser.get(URL);
		
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);//não permitir mais que 3 tentativas de logar com o mesmo usuário no mesmo computador
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String result = browser.findElement(By.tagName("h4")).getText();
		browser.quit();
	
		return result;
	}
	
	public String testFormSqlInjectLogin(String URL, String username, String password) {
		browser.get(URL);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		String result = browser.findElement(By.id("containerErros")).findElement(By.id("erros")).getText();
		//browser.quit();
		
		return result;
	}
	
	public String testBruteForce(String URL, String username, String password) {

		String result;
		browser.get(URL);
		for (int i = 0; i < 15; i++) {
			browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);//não permitir mais que 3 tentativas de logar com o mesmo usuário no mesmo computador
			browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password + i);
			browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		}

		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);//não permitir mais que 3 tentativas de logar com o mesmo usuário no mesmo computador
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		
		result = browser.findElement(By.tagName("h4")).getText();
		browser.quit();
	
		return result;
	}
	
	public WebDriver autentication(String URL, String username, String password) {

		browser.get(URL);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();
		browser.findElement(By.className("bordaDiv")).click();
		
		return browser;
	}

}
