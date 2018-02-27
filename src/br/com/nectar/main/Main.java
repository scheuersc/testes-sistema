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
		//String name = "Teste Automatizado";
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
		 * Testes de Login Inválido Chrome
		 * 
		 * */
		System.out.println("Teste de autenticação inválida está: " + (login.testLoginInvalido(browser) ? "Aprovado" : "Reprovado"));
		
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
		System.out.println("Teste de login está: " + (login.testLoginCorreto(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes de Injeção de SQL Chrome
		 * 
		 * */
		System.out.println("Teste de SQL Injection está: " + (login.testLoginSQLInject(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes de ataque de força bruta no Chrome
		 * 
		 * */
		System.out.println("Teste de Ataque de força Bruta .\nAGUARDE!");
		System.out.println("Teste de Ataque de força Bruta está: " + (login.testLoginForcaBruta(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Chrome
		 * 
		 * */
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes de validação de email no cadastro de usuário no Chrome
		 * 
		 * */
		System.out.println("A validação do email do cadastro de usuário está: " + (user.testUserFormRegistryEmailValidade( 
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
		 * Invocação do driver Chrome
		 * 
		 * */
		
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes do cadastro de usuário no Chrome
		 * 
		 * */
		System.out.println("O cadastro está: " + (user.testUserFormRegistry( 
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
		 * Invocação do driver Chrome
		 * 
		 * */
		
		browser = Driver.initChrome();
		
		/*
		 * 
		 * Testes do localizador de usuário no Chrome
		 * 
		 * */
		System.out.println("A procura do cadastro de usuário está: " + (user.testSearchUserFormRegistry( 
				browser,
				URL,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes) ? "Aprovado" : "Reprovado"));
				
		/*
		 * 
		 * Invocação do driver Firefox
		 * 
		 * */
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes de Login Inválido Firefox
		 * 
		 * */
		System.out.println("Teste de autenticação inválida está: " + (login.testLoginInvalido(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Firefox
		 * 
		 * */
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes de Login Firefox
		 * 
		 * */
		System.out.println("Teste de login está: " + (login.testLoginCorreto(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Firefox
		 * 
		 * */
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes de Injeção de SQL Firefox
		 * 
		 * */
		System.out.println("Teste de SQL Injection está: " + (login.testLoginSQLInject(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Firefox
		 * 
		 * */
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes de ataque de força bruta no Firefox
		 * 
		 * */
		System.out.println("Teste de Ataque de força Bruta .\nAGUARDE!");
		System.out.println("Teste de Ataque de força Bruta está: " + (login.testLoginForcaBruta(browser) ? "Aprovado" : "Reprovado"));
		
		/*
		 * 
		 * Invocação do driver Firefox
		 * 
		 * */
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes de validação de email no cadastro de usuário no Firefox
		 * 
		 * */
		System.out.println("A validação do email do cadastro de usuário está: " + (user.testUserFormRegistryEmailValidade( 
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
		 * Invocação do driver Firefox
		 * 
		 * */
		
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes do cadastro de usuário no Firefox
		 * 
		 * */
		System.out.println("O cadastro está: " + (user.testUserFormRegistry( 
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
		 * Invocação do driver Firefox
		 * 
		 * */
		
		browser = Driver.initFirefox();
		
		/*
		 * 
		 * Testes do localizador de usuário no Firefox
		 * 
		 * */
		System.out.println("A procura do cadastro de usuário está: " + (user.testSearchUserFormRegistry( 
				browser,
				URL,
				username, 
				password, 
				name, 
				email, 
				cpf,
				group,
				cel, 
				limitDes) ? "Aprovado" : "Reprovado"));

	}
}