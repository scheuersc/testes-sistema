package br.com.nectar.acesso.cadastro;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.browser.Driver;

public class Usuario {
	
	@Test
	public boolean testUserFormRegistryEmailValidade(WebDriver browser, String URL, String username, String password, String name, String email, String cpf, String group, String celular, String limiteDesconto) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */

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
		 * Teste do Menu principal
		 * 
		 * */
//		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		browser.findElement(By.id("botaoMenuEsquerdo")).click();
		
		/*
		 * Fim do teste do menu principal
		 * 
		 * */
		
		/*
		 * 
 		 * Teste do formulário de cadastro de usuário
		 * 
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * 
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * 
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys(name);
		
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_email")).sendKeys("a'@");
		
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
			return false;
		return true;
	}
	
	@Test
	public boolean testUserFormRegistry(WebDriver browser, String URL, String username, String password, String name, String email, String cpf, String group, String celular, String limiteDesconto) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */

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
		 * Teste do Menu principal
		 * 
		 * */
//		browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		browser.findElement(By.id("botaoMenuEsquerdo")).click();
		
		/*
		 * Fim do teste do menu principal
		 * 
		 * */
		
		/*
		 * 
 		 * Teste do formulário de cadastro de usuário
		 * 
		 * */
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * 
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * 
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys(name);
		
		browser.findElement(By.name("frm")).findElement(By.name("prop_txt_email")).sendKeys("a'@");
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
	}

	public boolean testSearchUserFormRegistry(WebDriver browser, String URL, String username, String password, String name, String email, String cpf, String group, String celular, String limiteDesconto) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */

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
		browser.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*
		 * 
		 * Acessar aba localizar
		 * 
		 * */
		List<WebElement> tagA = browser.findElements(By.tagName("a"));
		for (WebElement x : tagA) {
			if (x.getText().equals("Localizar")) {
				x.click();
				System.out.println("Clicou no localizar!");
				break;
			}
		}
		
		
		/*
		 * 
		 * Atributos obrigatórios (nome, e-mail, cpf e grupo
		 * 
		 * */
		browser.findElement(By.name("frm")).findElement(By.name("para_txt_nome")).sendKeys(name);
		
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
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String results = browser.findElement(By.id("toString")).getText();
		if (results.contains("Cadastro de Usuario, ID")){
			System.out.println("achou");
		}
		browser.quit();
		if (results.contains("Cadastro de Usuario, ID"))
			return true;
		return false;
		
	}
}
