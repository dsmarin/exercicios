package br.com.buscape.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.buscape.model.Submarino;

public class SubmarinoTestCase {

	private Submarino submarino;

	@Before
	public void setUp() throws Exception {
		submarino = new Submarino();
	}

	@Test
	public void CommandStreamTest1() {
		assertEquals(submarino.processarStream("LMRDDMMUU").toString(), "-1 2 0 NORTE");
	}
	
	@Test
	public void CommandStreamTest2() {
		assertEquals(submarino.processarStream("RMMLMMMDDLL").toString(), "2 3 -2 SUL");
	}
}
