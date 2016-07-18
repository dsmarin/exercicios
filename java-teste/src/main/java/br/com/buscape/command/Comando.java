package br.com.buscape.command;

import br.com.buscape.exception.ComandoException;
import br.com.buscape.model.Coordenada;

public interface Comando {

	public Coordenada executar(final Coordenada coordenada) throws ComandoException;
	
}
