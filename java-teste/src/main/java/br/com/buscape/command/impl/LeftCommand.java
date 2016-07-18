package br.com.buscape.command.impl;

import br.com.buscape.command.Comando;
import br.com.buscape.exception.ComandoException;
import br.com.buscape.model.Coordenada;

public class LeftCommand implements Comando {

	public Coordenada executar(Coordenada coordenada) throws ComandoException {
		Coordenada c = new Coordenada(coordenada.getX(), coordenada.getY(), coordenada.getZ(), coordenada.getDir());
		return c.girarEsquerda();
	}

}
