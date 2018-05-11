package br.com.nectar.main;

import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import br.com.nectar.autentication.*;

public class AllTests {
	
	private static final String projectLocation = System.getProperty("user.dir");
	private static String URL = "http://172.16.101.128:10100";
	private static String username = "suporte@marconsoft.com.br";
	private static String password = "!efacil#rul3z";
	
	@Before
	public static void begin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
	}

	public static void main(String[] args) {
		// define o local do driver	
		begin();
		
		Login objLogin;
		String result;
		
		//------ Test SQL Injection ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testFormSqlInjectLogin(URL, username, "' 1 = 1; --");
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de violação pelo ataque de seguraça Injeção de SQL: Aprovado!");
		} else {
			System.out.println("Teste de violação pelo ataque de seguraça Injeção de SQL: Reprovado!");
		}
		//------ End Test SQL Injection ------
		
		//------ Test Safety Brute Force ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testBruteForce(URL, username, password);
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de violação pelo ataque de segurança de força bruta: Aprovado!");
		} else {
			System.out.println("Teste de violação pelo ataque de segurança de força bruta: Reprovado!");
		}
		//------ End test safety Brute Force ------
		
		//------ Test Autentication ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testCorrectLogin(URL, username, password);
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de autenticação: Aprovado!");
		} else {
			System.out.println("Teste de autenticação: Reprovado!");
		}
		//------ End Test Autentication ------
		
		//------ Test invalid autentication ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testInvalidLogin(URL, username, password+"1");
		if (result.equals("Usuário ou senha invalidos!")) {
			System.out.println("Teste de falha na autenticação: Aprovado!");
		} else {
			System.out.println("Teste de falha na autenticação: Reprovado!");
		}
		//------ End Test invalid autentication ------
		
		//System.out.println("Resultado a ser verificado: " + result);
	}

}
