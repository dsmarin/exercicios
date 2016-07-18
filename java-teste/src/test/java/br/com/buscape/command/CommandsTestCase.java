package br.com.buscape.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.buscape.exception.ComandoException;
import br.com.buscape.model.Coordenada;
import br.com.buscape.model.Submarino;
import br.com.buscape.model.enums.ComandoEnum;

public class CommandsTestCase {

	private Coordenada coordenada;

	@Before
	public void setUp() throws Exception {
		coordenada = new Coordenada();
	}

	@Test
	public void UpFailTest() {
		try {
			Comando c = ComandoEnum.U.getInstance();
			coordenada = c.executar(coordenada);
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
			if (e instanceof ComandoException) {
				// Sucesso submarino nao voa!
			}
		}
	}

	@Test
	public void DownTest() {
		try {
			Comando c = ComandoEnum.D.getInstance();
			coordenada = c.executar(coordenada);
			assertEquals(coordenada.toString(), "0 0 -1 NORTE");
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
		}
	}

	@Test
	public void UpTest() {
		try {
			coordenada = coordenada.descer();
			Comando c = ComandoEnum.U.getInstance();
			coordenada = c.executar(coordenada);
			assertEquals(coordenada.toString(), "0 0 0 NORTE");
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
		}
	}

	@Test
	public void MoveTest() {
		try {
			Comando c = ComandoEnum.M.getInstance();
			coordenada = c.executar(coordenada);
			assertEquals(coordenada.toString(), "0 1 0 NORTE");
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
		}
	}

	@Test
	public void LeftTest() {
		try {
			Comando c = ComandoEnum.L.getInstance();
			coordenada = c.executar(coordenada);
			assertEquals(coordenada.toString(), "0 0 0 OESTE");
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
		}
	}

	@Test
	public void RightTest() {
		try {
			Comando c = ComandoEnum.R.getInstance();
			coordenada = c.executar(coordenada);
			assertEquals(coordenada.toString(), "0 0 0 LESTE");
		} catch (InstantiationException | IllegalAccessException | ComandoException e) {
		}
	}
}
