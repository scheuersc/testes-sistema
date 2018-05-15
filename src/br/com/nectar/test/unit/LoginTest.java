package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.autentication.Login;

public class LoginTest {

	private static String projectLocation = System.getProperty("user.dir");
	private String URL = "http://172.16.101.128:10100";
	private String username = "suporte@marconsoft.com.br";
	private String password = "!efacil#rul3z";

	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
	}

	@Test
	public void all() {
		this.loginIvalid();
		this.loginCorrect();
		this.bruteForce();
		this.formSqlInjectionLogin();
	}

	@Test
	public void loginIvalid() {
		String result = "";
		System.out.println("\n\n\nAutenticação inválida!");
		Login objLogin = new Login(new FirefoxDriver());
		try {
			result = objLogin.testInvalidLogin(URL, username, "erro");
			System.out.println("Teste de autenticão inválida no Firefox: "
					+ (result.equals("Usuário ou senha invalidos!") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Usuário ou senha invalidos!");
		} catch (Exception e) {
			System.out.println("Erro ao testar a Autenticação Inválida no Firefox: " + e.getMessage());
		}

		objLogin = new Login(new ChromeDriver());
		try {
			result = objLogin.testInvalidLogin(URL, username, "error");
			System.out.println("Teste de autenticão inválida no Chrome: "
					+ (result.equals("Usuário ou senha invalidos!") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Usuário ou senha invalidos!");
		} catch (Exception e) {
			System.out.println("Erro ao testar a Autenticação Iválida no sistema: " + e.getMessage());
		}
	}

	@Test
	public void loginCorrect() {
		System.out.println("\n\n\nAutenticação válida!");
		Login objLogin = new Login(new FirefoxDriver());
		String result = "";
		try {
			result = objLogin.testCorrectLogin(URL, username, password);
			System.out.println("Teste de autenticão válida no Firefox: "
					+ (result.equals("Clique na banca que deseja acessar:") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar teste de Autenticação Válida no Firefox: " + e.getMessage());
		}

		objLogin = new Login(new ChromeDriver());
		try {
			result = objLogin.testCorrectLogin(URL, username, password);
			System.out.println("Teste de autenticão válida no Chrome: "
					+ (result.equals("Clique na banca que deseja acessar:") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar teste de Autenticação Válida no Chrome: " + e.getMessage());
		}
	}

	@Test
	public void formSqlInjectionLogin() {
		System.out.println("\n\n\nTeste de segurança de SQL Injection!");
		Login objLogin = new Login(new FirefoxDriver());
		String result = "";
		try {
			result = objLogin.testFormSqlInjectLogin(URL, username, "' 1 = 1; --");
			System.out.println("Teste de SQL Injection válida no Firefox: "
					+ (result.equals("Usuário ou senha invalidos!") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Usuário ou senha invalidos!");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar teste de segurança SQL Injection no Firefox: " + e.getMessage());
		}

		objLogin = new Login(new ChromeDriver());
		try {
			result = objLogin.testFormSqlInjectLogin(URL, username, "' 1 = 1; --");
			System.out.println("Teste de SQL Injection válida no Chrome: "
					+ (result.equals("Usuário ou senha invalidos!") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Usuário ou senha invalidos!");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar teste de segurança SQL Injection no Chrome: " + e.getMessage());
		}
	}

	@Test
	public void bruteForce() {
		System.out.println("\n\n\nTestede segurança de autenticação com Brute Force!");
		Login objLogin = new Login(new ChromeDriver());
		String result = "";

		try {
			result = objLogin.testBruteForce(URL, username, password);
			System.out.println("Teste de Brute Force no Firefox: "
					+ (result.equals("Clique na banca que deseja acessar:") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar o ataque de segurança Brute Force no Chrome: " + e.getMessage());
		}

		try {
			objLogin = new Login(new FirefoxDriver());
			result = objLogin.testBruteForce(URL, username, password);
			System.out.println("Teste de Brute Force no Chrome: "
					+ (result.equals("Clique na banca que deseja acessar:") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(result, "Clique na banca que deseja acessar:");
		} catch (Exception e) {
			System.out.println("Erro ao aplicar o ataque de segurança Brute Force no Firefox: " + e.getMessage());
		}
	}

}