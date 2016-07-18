package br.com.buscape.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.buscape.command.Comando;
import br.com.buscape.exception.ComandoException;
import br.com.buscape.model.enums.ComandoEnum;

public class Submarino {

	public static final Pattern COMANDO_REGEX = Pattern.compile("([lL|rR|uU|dD|mM]){1}");

	public static final String SIM = "S";
	public static final String NAO = "N";

	private Coordenada coordenada = new Coordenada();
	private String instrucao = "";

	public Submarino() {
		super();
	}

	public void ligar() {
		System.out.println("Ligando motores...\nAjustando coordenadas...");
		boolean ligado = true;
		while (ligado) {
			System.out.print("Tudo pronto, vamos? Para sair digite 'n'.\nInforme os comandos:");
			instrucao = new Scanner(System.in).nextLine();
			if (NAO.equalsIgnoreCase(instrucao)) {
				ligado = false;
			} else {
				processarStream();
			}
		}
		System.out.println("Ajustando coordenadas...\nDesligando motores...\nFoi um prazer, ate a proxima!");
		System.exit(0);
	}

	public Coordenada processarStream(String instrucao) {
		this.instrucao = instrucao;
		return processarStream();
	}

	private Coordenada processarStream() {
		Matcher m = COMANDO_REGEX.matcher(instrucao);

		List<Comando> comandos = new ArrayList<Comando>();

		while (m.find()) {
			try {
				ComandoEnum c = ComandoEnum.valueOf(m.group());
				comandos.add(c.getInstance());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		Iterator<Comando> it = comandos.iterator();

		while (it.hasNext()) {
			try {
				Comando c = it.next();
				coordenada = c.executar(coordenada);
			} catch (ComandoException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(coordenada);
		
		return coordenada;
	}
}
