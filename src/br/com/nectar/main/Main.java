package br.com.nectar.main;

import org.openqa.selenium.WebDriver;

import br.com.nectar.acesso.cadastro.Usuario;
import br.com.nectar.autentication.*;
import br.com.nectar.browser.Driver;

public class Main {

	public static void main (String[] args) {
		
		Usuario user = new Usuario();
		Login login = new Login();
		WebDriver browser = null;

		/*
		 * Dados de entrada
		 * */
		String URL = "http://172.16.186.128:10100";
		String username = "suporte@marconsoft.com.br";
		String password = "!efacil#rul3z";
		String name = "Teste Automatizado3 v1.0";
		String email = "teste2@teste.com";
		String cpf = "88588155990";
		String group = "CAIXA";
		String cel = "48999999999";
		String limitDes = "20";
		
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes de Login Chrome
		 * 
		 * */
		
		System.out.println("Teste de autenticação inválida está: " + (login.testLoginInvalido(browser) ? "Aprovado" : "Reprovado"));
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		System.out.println("Teste de login está: " + (login.testLoginCorreto(browser) ? "Aprovado" : "Reprovado"));
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		System.out.println("Teste de SQL Infection está: " + (login.testLoginSQLInject(browser) ? "Aprovado" : "Reprovado"));
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		System.out.println("Teste de Ataque de força Bruta .\nAGUARDE!");
		System.out.println("Teste de Ataque de força Bruta está: " + (login.testLoginForcaBruta(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		
		browser = Driver.initChrome();
		System.out.println("O cadastro está: " + (user.testUserForRegistry( 
				browser,
				URL,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes)? "Aprovado" : "Reprovado"));
				
		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		browser = Driver.initFirefox(); 

		/*
		 * 
		 * Testes de Login Firefox
		 * 
		 * */
		
		System.out.println("Teste de autenticação inválida está: " + (login.testLoginInvalido(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		browser = Driver.initFirefox(); 
		System.out.println("Teste de login está: " + (login.testLoginCorreto(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		browser = Driver.initFirefox(); 
		System.out.println("Teste de SQL Infection está: " + (login.testLoginSQLInject(browser) ? "Aprovado" : "Reprovado"));

		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		System.out.println("Teste de Ataque de força Bruta.\nAGUARDE!");

		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		browser = Driver.initFirefox(); 
		System.out.println("Teste de Ataque de força Bruta está: " + (login.testLoginForcaBruta(browser) ? "Aprovado" : "Reprovado"));

		/*
		 * 
		 * Invocação do driver do Firefox
		 * 
		 * */
		browser = Driver.initFirefox(); 
		System.out.println("O cadastro está: " + (user.testUserForRegistry( 
				browser,
				URL,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes)? "Aprovado" : "Reprovado"));
	}
}