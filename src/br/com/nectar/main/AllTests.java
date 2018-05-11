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
	public void begin() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		Login objLogin;
		String result;
		
		//------ Teste de SQL Injection ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testFormSqlInjectLogin(URL, "suporte@marconsoft.com.br", "' 1 = 1; --");
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de seguraça Injeção de SQL Aprovado!");
		} else {
			System.out.println("Teste de seguraça Injeção de SQL Reprovado!");
		}
		//------ Teste de SQL Injection ------
		
		//------ Teste de Segurança de Força Bruta ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testBruteForce(URL, username, password);
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de segurança de força bruta Aprovado!");
		} else {
			System.out.println("Teste de segurança de força bruta Reprovado!");
		}
		//------ Fim de Segurança de Força Bruta ------
		
		//------ Autenticação ------
		objLogin = new Login (new FirefoxDriver());
		result = objLogin.testCorrectLogin(URL, username, password);
		if (result.equals("Clique na banca que deseja acessar:")) {
			System.out.println("Teste de autenticação Aprovado!");
		} else {
			System.out.println("Teste de autenticação Reprovado!");
		}
		//------ Fim da Autenticação ------
		
		//System.out.println(result);
	}

}
