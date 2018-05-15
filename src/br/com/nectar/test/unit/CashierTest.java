package br.com.nectar.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.financial.Cashier;
import br.com.nectar.utils.Util;

public class CashierTest {

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
		this.testSave();
		this.testSearch();
		this.testValidateSave();
	}
	
	@Test
	public void testSave() {
		System.out.println("Teste salvar!");
		String description;
		String code;
		String cpf;
		String result = "";
		boolean booResult = false;
		Cashier objCashier;

		description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		code = Util.gerarString(50, "123456789");// "2";
		cpf = Util.gerarCPFValido();
		objCashier = new Cashier(new FirefoxDriver());
		try {
			result = objCashier.testSave(URL, username, password, description, code, cpf);
			if (result.contains("Caixa, ID")) {
				booResult = true;
				System.out.println("Caixa salvo no Firefox!");
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao salvar Caixa no Firefox: " + e.getMessage());
		}

		description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
		code = Util.gerarString(50, "123456789");// "2";
		cpf = Util.gerarCPFValido();
		objCashier = new Cashier(new ChromeDriver());
		try {
			result = objCashier.testSave(URL, username, password, description, code, cpf);
			booResult = false;
			if (result.contains("Caixa, ID")) {
				System.out.println("Caixa salvo no Chrome!");
				booResult = true;
			}
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao salvar Caixa no Chrome: " + e.getMessage());
		}

	}

	@Test
	public void testSearch() {
		System.out.println("Teste buscar!");
		Boolean booResult;
		String description = "caixa loia";
		Cashier objCashier = new Cashier(new ChromeDriver());

		try {
			booResult = objCashier.testSearch(URL, username, password, description);
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao Buscar caixa no Chrome: " + e.getMessage());
		}

		objCashier = new Cashier(new FirefoxDriver());
		try {
			booResult = objCashier.testSearch(URL, username, password, description);
			Assert.assertEquals(booResult, true);
		} catch (Exception e) {
			System.out.println("Erro ao Buscar caixa no Firefox: " + e.getMessage());
		}
	}

	@Test
	public void testValidateSave() {
		System.out.println("Teste validar!");
		String description = "";
		String code = "";
		String cpf = "";
		boolean booResult = false;
		Cashier objCashier = new Cashier(new FirefoxDriver());;

		try {
			description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
			code = Util.gerarString(50, "123456789");// "2";
			cpf = Util.gerarCPFValido();
			booResult = objCashier.testValidadeSave(URL, username, password, description, code, cpf);
			if (!booResult)
				System.out.println("Caixa validado no Firefox!");
			Assert.assertEquals(booResult, false);
		} catch (Exception e) {
			System.out.println("Erro ao salvar Caixa no Firefox: " + e.getMessage());
		}

		objCashier = new Cashier(new ChromeDriver());
		try {
			description = Util.gerarString(50, "abcfefghijklmnopqrstuvwxyz0123456789");
			code = Util.gerarString(50, "123456789");// "2";
			cpf = Util.gerarCPFValido();
			booResult = objCashier.testValidadeSave(URL, username, password, description, code, cpf);
			if (!booResult)
				System.out.println("Caixa validado no Chrome!");
			Assert.assertEquals(booResult, false);
		} catch (Exception e) {
			System.out.println("Erro ao salvar Caixa no Chrome: " + e.getMessage());
		}
	}
}
