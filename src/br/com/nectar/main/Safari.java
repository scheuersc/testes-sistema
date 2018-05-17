package br.com.nectar.main;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.nectar.autentication.*;
import br.com.nectar.browser.connect.Driver;

public class Safari {

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
		//System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver driver = new SafariDriver();
		// Visita a página do Correios
		driver.get("http://www.marconsoft.com.br");
	}

	@Test
	public void preencheFormularioCorreiosBuscaLogradouroPorBairro() {
		//System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		WebDriver driver = new SafariDriver();
		// Visita a página do Correios
		driver.get("http://www.marconsoft.com.br");

		// Escolhe o valor de UF
		/*Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Preenche o campo Bairro com o valor "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");

		// clica no botão Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();*/
	}

}
