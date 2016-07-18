package br.com.buscape.exception;

import br.com.buscape.command.Comando;

public class ComandoException extends Throwable{

	private static final long serialVersionUID = 8694169072218075149L;

	public ComandoException(Comando comando, Throwable e){
		super("Erro ao processar o comando [" + comando + "].", e);
	}
	
}
