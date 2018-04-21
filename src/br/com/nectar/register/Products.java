package br.com.nectar.register;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {

	private static String projectLocation = System.getProperty("user.dir");
	
	@Test
	public void pesquisaNaPaginaGoogleTermoTesteAceitacao() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com.br");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("testes de aceitação");
	 
		assertNotNull(driver.findElement(By.cssSelector("div.srg")));
	}

	
	@Test
	public void testRegistry() {//WebDriver browser, String URL, String username, String password, String codBarras, String descricao, String grupo, String unidade, String precoCusto, String estoque, String resumo, String porMargem, String estoqueIdeal, boolean brinde, boolean status) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */

		String URL = "http://172.16.186.128:10100";
		String username = "suporte@marconsoft.com.br";
		String password = "!efacil#rul3z";
		String codBarras = "123456";
		String descricao = "asd23";
		String grupo = "08-BEBIDAS";
		String precoCusto = "1,00";
		String precoVenda = "15";
		String estoque = "2";
		String resumo = "asdfzxcv";
		String porMargem = "50";
		String estoqueIdeal = "1";
		
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver browser = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		//WebDriver browser = new FirefoxDriver();
		
		browser.get(URL);
		
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(username);
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtSenha")).sendKeys(password);
		browser.findElement(By.name("frmLogin")).findElement(By.name("cmdEntrar")).click();

		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.className("bordaDiv")).click();
		/*
		 * Fim do bloco inicial
		 * 
		 * */
		
		/*
		 * 
 		 * Teste do formulário de cadastro de usuário
		 * 
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.cadastros.Produto");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * 
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * 
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_codigoBarras")).sendKeys(codBarras);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_descricao")).sendKeys(descricao);
		browser.findElement(By.xpath("//select[@id='prop_lst_grupo']")).sendKeys(grupo);
		//browser.findElement(By.name("frm")).findElement(By.name("prop_txt_unidade")).sendKeys(unidade);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_precoCusto")).sendKeys(precoCusto);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_precoVenda")).sendKeys(precoVenda);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_estoque")).sendKeys(estoque);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_resumo")).sendKeys(resumo);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_percentualMargem")).sendKeys(porMargem);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_estoque")).sendKeys(estoque);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_estoqueIdeal")).sendKeys(estoqueIdeal);
		browser.findElement(By.id("prop_chk_brinde")).click();
		browser.findElement(By.id("prop_chk_inativo")).click();
		
		/*
		 * 
		 * Acionar botão salvar
		 * 
		 * */
		browser.findElement(By.id("btn_localizar")).click();
		
		/*
		 * Bloco de validação de resultados do método
		 * 
		 * */
		
		/*
		 * Bloco comentado se retornar mais do que um resultado
		 * 
		 */ 
		/*List<WebElement> divResultado = browser.findElements(By.className("ag-cell-value"));
		boolean results = false;
		for (WebElement x : divResultado) {
			System.out.println("conferindo");
			System.out.println(name.toUpperCase() + " = " + x.getText());
			if (x.getText().contains(name.toUpperCase())) {
				results = true;
				System.out.println("entrou");
			}
		}
		browser.quit();
		return results;
		*/	
		/*
		 * 
		 * Bloco que apresenta apenas 1 resultado 
		 * Alterar o atributo "name" que fica na esntrada de dados na classe "Main"
		 * 
		 * */
		/*browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String results = browser.findElement(By.id("toString")).getText();
		if (results.contains("Cadastro de Usuario, ID")){
			System.out.println("achou");
		}
		browser.quit();
		if (results.contains("Cadastro de Usuario, ID"))
			return true;
		return false;*/
		
	}
}
