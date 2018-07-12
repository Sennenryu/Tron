package Controller;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Model.Joueurs;

// TODO: Auto-generated Javadoc
/**
 * The Class CollisionsTest.
 */
public class CollisionsTest {
	

	/** The color P 1. */
	Color colorP1= new Color(0,0,255);
	
	/** The player test 1. */
	Joueurs playerTest1= new Joueurs("jaune",Joueurs.LEFT, colorP1, 15, 15);
	
	/** The resultat attendu. */
	String resultatAttendu = "jaune";
	
	/** The result. */
	String result = getP1Name();

	
	
	
	/**
	 * Test assert.
	 */
	@Test	
    public void testAssert(){	

		assertEquals(resultatAttendu, result);
    }
	
	
	
	
	/**
	 * Gets the p 1 name.
	 *
	 * @return the p 1 name
	 */
	private String getP1Name() {
		return playerTest1.getName();
	}

}
