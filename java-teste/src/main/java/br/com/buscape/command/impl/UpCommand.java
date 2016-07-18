package br.com.buscape.command.impl;

import br.com.buscape.command.Comando;
import br.com.buscape.exception.ComandoException;
import br.com.buscape.exception.OperacaoInvalidaException;
import br.com.buscape.model.Coordenada;

public class UpCommand implements Comando{

	public Coordenada executar(final Coordenada coordenada) throws ComandoException {
		Coordenada c = new Coordenada(coordenada.getX(),coordenada.getY(),coordenada.getZ(),coordenada.getDir());
		try {
			return c.subir();
		} catch (OperacaoInvalidaException e) {
			throw new ComandoException(this,e);
		}
	}

}
