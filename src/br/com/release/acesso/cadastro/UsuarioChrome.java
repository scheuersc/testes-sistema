package br.com.release.acesso.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UsuarioChrome {

	private String projectLocation = System.getProperty("user.dir");
	private final static String URL = "http://172.16.186.128:10100";
	
	@Test
	public void testLoginCorretoChrome() {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		browser.get(URL);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys("suporte@marconsoft.com.br");
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys("!efacil#rul3z");
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();

		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.className("bordaDiv")).click();
		
		/*
		 * Fim do bloco inicial
		 * 
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//browser.findElement(By.id("botaoMenuEsquerdo")).click();
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys("Teste Automatizado v1.0");
		
		//Select select = new Select(browser.findElement(By.xpath("prop_txt_codigoGrupo")));
		//WebElement option = select.getFirstSelectedOption();
		//String defaultItem = option.getText();
		
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_codigoGrupo")).sendKeys("01");
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_codigoGrupo")).isSelected();
		//String results = browser.findElement(By.tagName("h4")).getText();
		
		/*
		 * Bloco de validação de resultados do método
		 * 
		 * */
		
		//browser.quit();
		//if (results.equals("Clique na banca que deseja acessar:"))
		//	return true;
		//return false;
		
		/*
		 * Fim da validação do método
		 * 
		 * */
	}
	
}
