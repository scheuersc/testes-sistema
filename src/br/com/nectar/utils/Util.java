package br.com.nectar.utils;

import java.util.Random;

public class Util {

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));
		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		return primDig.toString() + segDig.toString();
	}

	public static String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + calcDigVerif(iniciais);
	}

	public static boolean validaCPF(String cpf) {
		if (cpf.length() != 11)
			return false;
		String numDig = cpf.substring(0, 9);
		return calcDigVerif(numDig).equals(cpf.substring(9, 11));
	}

	public static String gerarCPFValido() {
		String CPF = geraCPF();
		Boolean found = false;
		while (found == false) {
			if (validaCPF(CPF)) {
				found = true;
			} else {
				CPF = geraCPF();
			}
		}
		return CPF;
	}

	public static String gerarString(int tamanho, String letras) {
		Random random = new Random();
		StringBuilder saida = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			saida.append(letras.charAt(random.nextInt(letras.length())));
		}
		return saida.toString();
	}

	public static void main(String args[]) {
		String CPF = gerarCPFValido();
		System.out.println("CPF Válido: " + CPF);
		String email = gerarString(10, "abcfefghijklmnopqrstuvwxyz") + "@" +gerarString(10, "abcfefghijklmnopqrstuvwxyz") + ".com";
		System.out.println(email);
	}
}