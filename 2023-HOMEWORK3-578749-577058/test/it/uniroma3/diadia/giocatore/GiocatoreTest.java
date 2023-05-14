package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;

import org.junit.jupiter.api.BeforeEach;


class GiocatoreTest {
	
	private IO io;
	
	private Giocatore giocatore = new Giocatore(io);
	private Giocatore giocatore0cfu = new Giocatore(io);
	
	@BeforeEach 
	
	
	public void setUp() {
		
		this.giocatore.setCfuGioc(20);
		this.giocatore0cfu.setCfuGioc(0);
	}
	
	
	

	@Test
	void testGetCfu() {
		assertEquals(20, this.giocatore.getCfuGioc());
	}
	
	
	@Test
	void testGet0Cfu() {
		assertEquals(0, this.giocatore0cfu.getCfuGioc());
	}
	
	


}

