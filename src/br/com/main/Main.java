package br.com.main;

import br.com.release.login.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.testesChrome();
		Main.testesFirefox();
	}

	public static void testesChrome() {
		TestSeleniumChrome tsc = new TestSeleniumChrome();
		System.out.println("Teste de autenticação inválida no Chrome está: " + (tsc.testLoginInvalidoChrome() ? "Aprovado" : "Reprovado"));
		System.out.println("Teste de login no Chrome está: " + (tsc.testLoginCorretoChrome() ? "Aprovado" : "Reprovado"));
		System.out.println("Teste de SQL Infection no Chrome está: " + (tsc.testLoginSQLInjectChrome() ? "Aprovado" : "Reprovado"));
		System.out.println("Teste de Ataque de força Bruta no Chrome.\nAGUARDE!");
		System.out.println("Teste de Ataque de força Bruta no Chrome está: " + (tsc.testLoginForcaBrutaChrome() ? "Aprovado" : "Reprovado"));
	}
	
	public static void testesFirefox() {
		TestSeleniumFirefox tsf = new TestSeleniumFirefox();
		System.out.println("Teste de autenticação inválida no Firefox está: " + (tsf.testLoginInvalidoFirefox() ? "Aprovado" : "Reprovado"));		
		System.out.println("Teste de login no Firefox está: " + (tsf.testLoginCorretoFirefox() ? "Aprovado" : "Reprovado"));
		System.out.println("Teste de SQL Infection no Firefox está: " + (tsf.testLoginSQLInjectFirefox() ? "Aprovado" : "Reprovado"));
		System.out.println("Teste de Ataque de força Bruta no Firefox.\nAGUARDE!");
		System.out.println("Teste de Ataque de força Bruta no Firefox está: " + (tsf.testLoginForcaBrutaFirefox() ? "Aprovado" : "Reprovado"));
	}
}