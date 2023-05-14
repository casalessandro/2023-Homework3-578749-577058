package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	protected Labirinto labirinto;
	protected IO IO;
	
	@BeforeEach
	public void setUp() {
		this.IO = new IOConsole();
	}
	
	
	@Test
	// test stanza iniziale corretta
	public void testInizialeCorretta() {
		IO.mostraMessaggio("Sto eseguendo testInizialeCorretta()");
		labirinto = new LabirintoBuilder()
					.addStanzaIniziale("inizio")
					.getLabirinto();
		assertEquals("inizio", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	// test stanza finale corretta
	public void testFinaleCorretta() {
		IO.mostraMessaggio("Sto eseguendo testFinaleCorretta()");
		labirinto = new LabirintoBuilder()
				.addStanzaFinale("fine")
				.getLabirinto();
		assertEquals("fine", this.labirinto.getUscita().getNome());
	}
	
	@Test
	public void testAdiacenzaLabirintoBilocale() {
		IO.mostraMessaggio("Sto eseguendo testAdiacenzaLabirintoBilocale()");
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.addStanzaFinale("fine")
				.addAdiacenza("inizio","fine", "nord")
				.addAdiacenza("fine", "inizio", "sud")
				.getLabirinto();
		assertEquals(labirinto.getStanzaIniziale(), labirinto.getUscita().getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAttrezzoPiazzato() {
		IO.mostraMessaggio("Sto eseguendo testAdiacenzaLabirintoBilocale()");
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("inizio")
				.addAttrezzo("inizio", "test", 1)
				.getLabirinto();
		Map<String, Attrezzo> attrezzi = labirinto.getStanzaIniziale().getAttrezzi();
		Attrezzo attrezzo = attrezzi.get("test");
		assertTrue(attrezzo.getNome().equals("test") &&
				   attrezzo.getPeso() == 1);
	}
}
