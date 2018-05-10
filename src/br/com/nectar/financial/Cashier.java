package br.com.nectar.financial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.nectar.autentication.Login;

public class Cashier {
	
	private WebDriver browser = null;
	private String destiny = "br.com.mns.financeiro.Caixa";
	
	public Cashier() {
		
	}
	
	public Cashier (WebDriver driver) {
		this.browser = driver;
	}

	public String testSave (String URL, String username, String password, String description, String code, String cpfCnpj) {
		Login objLogin = new Login(browser);
		WebDriver browser = objLogin.autentication(URL, username, password);

		/*
		 * Teste do formulário de cadastro de usuário
		 */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=" + destiny);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_descricao")).sendKeys(description);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_responsavel_codigo")).sendKeys(code);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_responsavel_cpf_Cnpj")).sendKeys(cpfCnpj);
		
		/*
		 * Acionar botão salvar
		 */
		browser.findElement(By.id("btn_salvar")).click();
		
		/*
		 * Bloco comentado se retornar mais do que um resultado
		 */ 
		
		/*
		List<WebElement> divResultado = browser.findElements(By.className("ag-cell-value"));
		boolean results = false;
		for (WebElement x : divResultado) {
			System.out.println("conferindo");
			System.out.println(name.toUpperCase() + " = " + x.getText());
			if (x.getText().contains(name.toUpperCase())) {
				results = true;
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
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String results = browser.findElement(By.id("toString")).getText();
		if (results.contains("Cadastro de Usuario, ID")){
			System.out.println("achou");
		}
		browser.quit();
		return results;
	}
	
	public Boolean testSearch (String URL, String username, String password, String description) {
		Boolean booResults = false;
		Login objLogin = new Login(browser);
		WebDriver browser = objLogin.autentication(URL, username, password);

		/*
		 * Teste do formulário de cadastro de usuário
		 */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=" + destiny);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * Acessar aba localizar
		 */
		List<WebElement> tagA = browser.findElements(By.tagName("a"));
		for (WebElement x : tagA) {
			if (x.getText().equals("Localizar")) {
				x.click();
				break;
			}
		}
		
		
		/*
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 */
		browser.findElement(By.name("frm")).findElement(By.name("para_txt_descricao")).sendKeys(description);
		
		/*
		 * Acionar botão localizar
		 */
		browser.findElement(By.id("btn_localizar")).click();
		
		/*
		 * Bloco comentado se retornar mais do que um resultado
		 */ 
		
		List<WebElement> divResultado = browser.findElements(By.className("ag-cell-value"));
		for (WebElement x : divResultado) {
			System.out.println("conferindo");
			System.out.println(description.toUpperCase() + " = " + x.getText());
			if (x.getText().contains(description.toUpperCase())) {
				booResults = true;
			}
		}
		browser.quit();
		return booResults;
		
		/*
		 * 
		 * Bloco que apresenta apenas 1 resultado 
		 * Alterar o atributo "name" que fica na esntrada de dados na classe "Main"
		 * 
		 * */
		/*
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		booResults = browser.findElement(By.id("toString")).getText();
		if (results.contains("Cadastro de Usuario, ID")){
			System.out.println("achou");
		}
		browser.quit();
		return results;
		*/
	}

	public String testSave (String URL, String username, String password, String name, String email, String cpf, String group, String celular, String disLimit) {
		Login objLogin = new Login(browser);
		WebDriver browser = objLogin.autentication(URL, username, password);
		
		/*
		 * 
 		 * Teste do formulário de cadastro de usuário
		 * 
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=" + destiny);
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
		 * Preencher (% limite desconto e celular)
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_limiteDesconto")).sendKeys(disLimit);
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
		return results;
	}

	public Boolean testValidadeSave(String URL, String username, String password, String description, String code, String cpfCnpj) {
		Boolean booResult = false;
		Login objLogin = new Login(browser);
		WebDriver browser = objLogin.autentication(URL, username, password);

		/*
		 * Teste do formulário de cadastro de usuário
		 */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=" + destiny);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_descricao")).sendKeys(description);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_responsavel_codigo")).sendKeys(code);
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_responsavel_cpf_Cnpj")).sendKeys(cpfCnpj);
		
		/*
		 * Acionar botão salvar
		 */
		browser.findElement(By.id("btn_salvar")).click();
		
		/*
		 * Bloco de validação de resultados do método
		 * 
		 * */
		String notice = browser.findElement(By.className("ajs-content")).getText();
		if (notice.contains("Descrição")) {
			booResult = true;
			System.out.println("Faltou o campo obrigatório Descrição!");
		}
		if (browser.findElement(By.className("ajs-ok")) != null)
			browser.findElement(By.className("ajs-ok")).click();
		
		browser.quit();
		return booResult;
	}

	public String testesAlert() throws InterruptedException {
		browser.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		browser.findElement(By.name("proceed")).click();
		Alert alert = browser.switchTo().alert();
		
		//Thread.sleep(3000);
		String retorno = alert.getText();
		
		alert.accept();
		browser.quit();
		
		return retorno;
	}
}
