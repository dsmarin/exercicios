package br.com.buscape.model.enums;

import br.com.buscape.command.Comando;
import br.com.buscape.command.impl.DownCommand;
import br.com.buscape.command.impl.LeftCommand;
import br.com.buscape.command.impl.MoveCommand;
import br.com.buscape.command.impl.RightCommand;
import br.com.buscape.command.impl.UpCommand;

public enum ComandoEnum {
	
	L("left", LeftCommand.class), //
	R("right", RightCommand.class), //
	U("up", UpCommand.class), //
	D("down", DownCommand.class), //
	M("move", MoveCommand.class);

	private String nome;
	private Class<? extends Comando> clazz;

	private ComandoEnum(String nome, Class<? extends Comando> clazz) {
		this.nome = nome;
		this.clazz = clazz;
	}

	public Comando getInstance() throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	public String toString() {
		return nome.toUpperCase();
	}
}
