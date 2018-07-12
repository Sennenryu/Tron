package View;

import static org.junit.Assert.*;

import org.junit.Test;

import View.Deplacements;

// TODO: Auto-generated Javadoc
/**
 * The Class FenetreTest.
 */
public class FenetreTest {

	/** The game panel. */
	Deplacements gamePanel=null;
	
	/** The game panel test. */
	Deplacements gamePanelTest=actionPerformed();
	
	/** The game panel test 2. */
	Deplacements gamePanelTest2=null;
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		assertEquals(gamePanelTest,gamePanelTest2);	
	}
	
	/**
	 * Action performed.
	 *
	 * @return the deplacements
	 */
	private Deplacements actionPerformed() {
		

		return gamePanel;
	
	}

}
