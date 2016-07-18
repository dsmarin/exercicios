package br.com.buscape.exception;

public class ComandoInvalidoException extends Throwable{

	private static final long serialVersionUID = -7475413663434554414L;

	public ComandoInvalidoException(String comando){
		super(comando + " nao reconhecido.");
	}
	
}
