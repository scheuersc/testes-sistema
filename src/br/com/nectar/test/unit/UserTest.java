package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.register.Users;
import br.com.nectar.utils.Util;;

public class UserTest {

	private static final String projectLocation = System.getProperty("user.dir");
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
		this.searchUsers();
		this.saveUsers();
		this.validateSaveUsers();
	}

	@Test
	public void searchUsers() {
		System.out.println("Teste automatizado de Buscar usuário!");
		String name = "TESTE AUTOMATIZADO V2.0.2.1";
		Users objUsers = new Users(new ChromeDriver());
		String result;
		boolean booResult = false;
		try {
			result = objUsers.testSearch(URL, username, password, name);
			System.out.println("Teste de Buscar usuário no Chrome: "
					+ (result.contains("Cadastro de Usuario, ID") ? "APROVADO" : "REPROVADO"));
			if (result.contains("Cadastro de Usuario, ID")) {
				booResult = true;
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao testar funcionalidade Buscar no Chrome: " + e.getMessage());
		}

		objUsers = new Users(new FirefoxDriver());
		try {
			result = objUsers.testSearch(URL, username, password, name);
			System.out.println("Teste de Buscar usuário no Firefox: "
					+ (result.contains("Cadastro de Usuario, ID") ? "APROVADO" : "REPROVADO"));
			booResult = false;
			if (result.contains("Cadastro de Usuario, ID")) {
				booResult = true;
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao testar funcionalidade Buscar no Firefox: " + e.getMessage());
		}
	}

	@Test
	public void saveUsers() {
		boolean booResult = false;
		String result;
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
				+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(1, "123456789") + Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		String cpf = "";
		Users objUsers;
		objUsers = new Users(new ChromeDriver());
		try {
			cpf = Util.gerarCPFValido();
			result = objUsers.testSave(URL, username, password, name, email, cpf, group, phone,
					disLimit);

			if (result.contains("Cadastro de Usuario, ID")) {
				booResult = true;
			}
			System.out.println("Teste de Salvar usuário no Chrome: "
					+ (result.contains("Cadastro de Usuario, ID") ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Esso ao testar a funcionalidade Salvar no Chrome: " + e.getMessage());
		}

		name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
				+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		phone = Util.gerarString(1, "123456789") + Util.gerarString(10, "0123456789");
		group = "CAIXA";
		disLimit = "20";
		
		objUsers = new Users(new FirefoxDriver());
		try {
			cpf = Util.gerarCPFValido();
			result = objUsers.testSave(URL, username, password, name, email, cpf, group, phone,
					disLimit);
			booResult = false;

			if (result.contains("Cadastro de Usuario, ID")) {
				booResult = true;
			}
			Assert.assertEquals(booResult, true);
			System.out.println("Teste de Buscar usuário no Firefox: "
					+ (result.contains("Cadastro de Usuario, ID") ? "APROVADO" : "REPROVADO"));
		} catch (Exception e) {
			System.out.println("Esso ao testar a funcionalidade Salvar no Firefox: " + e.getMessage());
		}
	}

	@Test
	public void validateSaveUsers(){
		String name = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		String email = Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@"
				+ Util.gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		String phone = Util.gerarString(10, "0123456789");
		String group = "CAIXA";
		String disLimit = "20";
		String cpf = "";// Util.gerarCPFValido();
		Boolean booResult = false;
		Users objUsers;
		try {
			objUsers = new Users(new FirefoxDriver());
			booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, phone);
			System.out.println("Teste de Buscar usuário no Firefox: "
					+ (booResult == true ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(true, booResult);
		} catch (Exception e) {
			System.out.println("Esso ao testar a funcionalidade Validar Campo Obrigatório no momento de Salvar no Firefox: " + e.getMessage());
		}

		try {
			objUsers = new Users(new ChromeDriver());
			booResult = objUsers.testValidadeSave(URL, username, password, name, email, cpf, group, disLimit, phone);
			System.out.println("Teste de Buscar usuário no Chrome: "
					+ (booResult == true ? "APROVADO" : "REPROVADO"));
			Assert.assertEquals(true, booResult);
		} catch (Exception e) {
			System.out.println("Esso ao testar a funcionalidade Validar Campo Obrigatório no momento de Salvar no Chrome: " + e.getMessage());
		}
	}

	@Test
	public void alertTest() throws InterruptedException {
		Users objUsers = new Users(new FirefoxDriver());
		Assert.assertEquals("Please enter a valid user name", objUsers.testesAlert());

		objUsers = new Users(new ChromeDriver());
		Assert.assertEquals("Please enter a valid user name", objUsers.testesAlert());
	}
}