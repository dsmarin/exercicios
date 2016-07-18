package br.com.buscape.model;

import br.com.buscape.exception.OperacaoInvalidaException;

public class Coordenada {

	public enum Direcao {

		NORTE("oeste", "leste"), //
		SUL("leste", "oeste"), //
		LESTE("norte", "sul"), //
		OESTE("sul", "norte");

		private String left;
		private String right;

		private Direcao(String left, String right) {
			this.left = left;
			this.right = right;
		}

		public Direcao left() {
			return Direcao.valueOf(left.toUpperCase());
		}

		public Direcao right() {
			return Direcao.valueOf(right.toUpperCase());
		}
	}

	private int x;
	private int y;
	private int z;
	private Direcao dir = Direcao.NORTE;

	public Coordenada() {
		super();
	}

	public Coordenada(int x, int y, int z, Direcao dir) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dir = dir;
	}

	public Coordenada mover() {
		switch (dir) {
		case NORTE:
			y++;
			break;
		case LESTE:
			x++;
			break;
		case SUL:
			y--;
		case OESTE:
			x--;
			break;
		}
		return this;
	}

	public String toString() {
		return x + " " + y + " " + z + " " + dir.toString();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Direcao getDir() {
		return dir;
	}

	public Coordenada subir() throws OperacaoInvalidaException {
		if (z < 0) {
			z++;
			return this;
		}
		throw new OperacaoInvalidaException("Submarino nao voa!");
	}

	public Coordenada descer() {
		z--;
		return this;
	}

	public Coordenada girarEsquerda() {
		dir = dir.left();
		return this;
	}

	public Coordenada girarDireita() {
		dir = dir.right();
		return this;
	}
}
