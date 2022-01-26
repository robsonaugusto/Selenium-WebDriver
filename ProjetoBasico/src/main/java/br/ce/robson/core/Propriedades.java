package br.ce.robson.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX,
		
	}
	
	

}
