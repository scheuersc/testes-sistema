package br.com.release.acesso.cadastro;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UsuarioChrome {

	private static String projectLocation = System.getProperty("user.dir");
	private final static String URL = "http://172.16.186.128:10100";
	
	@Test
	public boolean testUserForRegistry(WebDriver browser, String user, String password, String name, String email, String cpf, String group, String celular, String limiteDesconto) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */
		//System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");

		//WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		browser.get(URL);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(user);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();

		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.className("bordaDiv")).click();
		/*
		 * Fim do bloco inicial
		 * 
		 * */
		
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * Teste do Menu principal
		 * 
		 * */
		//browser.findElement(By.id("botaoMenuEsquerdo")).click();
		/*
		 * Fim do teste do menu principal
		 * 
		 * */
		
		/*
		 * 
 		 * Teste do formulário de cadastro de usuário
		 * 
		 * */
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * 
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * 
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys(name);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_email")).sendKeys(email);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_cpf")).sendKeys(cpf);
		
		/*
		 * 
		 * Preencher combobox sem possuir valores relatados no html.
		 * 
		 * */
		browser.findElement(By.xpath("//select[@id='prop_txt_codigoGrupo']")).sendKeys(group);;
		/*
		 * 
		 * Fim do preenchimento do combo
		 * 
		 * */
		
		/*
		 * 
		 * Fim do preenchimento dos campos obrigatórios
		 * 
		 * */
		
		/*
		 * Preencher (% limite desconto e celular)
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_limiteDesconto")).sendKeys(limiteDesconto);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_celular")).sendKeys(celular);
		
		/*
		 * 
		 * Acionar botão salvar
		 * 
		 * */
		browser.findElement(By.id("btn_salvar")).click();
		
		/*
		 * Bloco de validação de resultados do método
		 * 
		 * */
		String results = browser.findElement(By.id("toString")).getText();
		browser.quit();
		boolean retorno;
		if (results.contains("Cadastro de Usuario, ID"))
			return true;
		return false;
		/*
		 * Fim da validação do método
		 * 
		 * */
	}

	public static void main (String[] args) {
		UsuarioChrome user = new UsuarioChrome();

		/*
		 * Dados de entrada
		 * */
		String username = "suporte@marconsoft.com.br";
		String password = "!efacil#rul3z";
		String name = "Teste Automatizado3 v1.0";
		String email = "teste2@teste.com";
		String cpf = "88588155990";
		String group = "CAIXA";
		String cel = "48999999999";
		String limitDes = "20";
		
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver browserChrome = new ChromeDriver();
		
		System.out.println("O cadastro está: " + (user.testUserForRegistry( 
				browserChrome,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes)? "Aprovado no Chrome" : "Reprovado no Chrome"));
		
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		
		/*
		 * Firefox
		 * */
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		//System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		WebDriver browserFirefox = new FirefoxDriver();
		
		
		System.out.println("O cadastro está: " + (user.testUserForRegistry( 
				browserFirefox,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes)? "Aprovado no Chrome" : "Reprovado no Chrome"));
	}
}
