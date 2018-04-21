package br.com.nectar.test.unit;
/*
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.nectar.autentication.Login;

public class Teste {

	private static final String projectLocation = System.getProperty("user.dir");
	
	private final String URL = "http://172.16.186.135:10100";
	
	private String username = "suporte@marconsoft.com.br";
	private String password = "!efacil#rul3z";
	private String name = "Teste Automatizado v1.01";
	//private String email = "teste@teste.com";
	private String cpf = "25956326476";
	private String group = "CAIXA";
	private String cel = "48999999999";
	private String limitDes = "20";
	
	@Test
	public void testes() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		/*WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		System.out.println("Message: "+alert.getText());
		
		alert.accept();
		Thread.sleep(3000);
		driver.quit();
		*/
/*		
		Login objLogin = new Login(new FirefoxDriver());
		WebDriver driver = objLogin.autentication(URL, username, password);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.name("frm")).findElement(By.name("prop_txt_nome")).sendKeys(name);
		
		driver.findElement(By.name("frm")).findElement(By.name("prop_txt_email")).sendKeys("a'@");
		
		driver.findElement(By.name("frm")).findElement(By.name("prop_txt_cpf")).sendKeys(cpf);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='prop_txt_codigoGrupo']")).sendKeys(group);
		driver.findElement(By.name("frm")).findElement(By.name("prop_txt_limiteDesconto")).sendKeys(limitDes);
		driver.findElement(By.name("frm")).findElement(By.name("prop_txt_celular")).sendKeys(cel);
		driver.findElement(By.id("btn_salvar")).click();

		Alert alert = driver.switchTo().alert();//wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		System.out.println("aqui: " + alert.toString());
/*
		Thread.sleep(3000);
		System.out.println("Message: "+alert.getText());
		alert.accept();
		
		Thread.sleep(2000);
		//System.out.println(browser.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.quit();*/
/*
	}
}
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nectar.autentication.Login;

import org.openqa.selenium.NoAlertPresentException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

public class Teste {
	
	private static final String projectLocation = System.getProperty("user.dir");
	private static String URL = "http://172.16.101.128:10100";
	private static String username = "suporte@marconsoft.com.br";
	private static String password = "!efacil#rul3z";
	
	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
		//System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckdriver/geckodriver");
		
		String name = "Teste Automatizado v2.0.2";
		String email = "'011teste@teste.com";
		String cpf = "73627138430";
		String group = "CAIXA";
		String disLimit = "48999999999";
		String cel = "48996307564";
		Login objLogin = new Login(new ChromeDriver());
		WebDriver driver = objLogin.autentication(URL, username, password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL + "/jedi-gt?nomeClasseXML=br.com.mns.acesso.Usuario");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Alert Message handling
		driver.findElement(By.xpath("//input[@id='btn_salvar']")).click();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println("Mensagem: "+ alertMessage);	
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert.accept();		
    }	

}