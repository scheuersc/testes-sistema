package br.com.nectar.acesso.cadastro;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Usuario {
	
	@Test
	public boolean testUserForRegistry(WebDriver browser, String URL, String user, String password, String name, String email, String cpf, String group, String celular, String limiteDesconto) {
		/*
		 * Bloco de inicial (autenticação de usuário e acesso ao sistema propriamente dito)
		 * 
		 * */

		browser.get(URL);
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		browser.findElement(By.name("frmLogin")).findElement(By.name("txtUsuario")).sendKeys(user);
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

}
