package br.com.buscape.exception;

public class OperacaoInvalidaException extends Throwable {

	private static final long serialVersionUID = 1807878628295142745L;

	public OperacaoInvalidaException(String m){
		super(m);
	}
}
