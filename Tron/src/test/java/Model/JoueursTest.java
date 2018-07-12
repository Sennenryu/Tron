package Model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Model.Joueurs;
import Model.Positions;

// TODO: Auto-generated Javadoc
/**
 * The Class JoueursTest.
 */
public class JoueursTest {
	
	/** The color P 1. */
	Color colorP1= new Color(0,0,255);
	
	/** The x 1. */
	int x1 = 10;
	
	/** The y 1. */
	int y1 = 15;
	
	/** The head test. */
	Positions headTest = new Positions(x1, y1, null);
	
	/** The head. */
	Positions head = new Positions(x1, y1, null);
	
	/** The player test 1. */
	Joueurs playerTest1= new Joueurs("jaune",Joueurs.LEFT, colorP1, 15, 20);
	
	
	/** The direction. */
	int direction = 2;
	
	/** The direction test 1. */
	int directionTest1 = 2;
	
	/** The direction test 2. */
	int directionTest2 = getDirection();
	
	
	
	/**
	 * Test assert.
	 */
	@Test	
    public void testAssert(){	

		assertTrue(headTest!=head);
		assertEquals(directionTest1,directionTest2);
    }
	
	/**
	 * Joueurs.
	 *
	 * @param name the name
	 * @param direction the direction
	 * @param color the color
	 * @param x the x
	 * @param y the y
	 */
	public void Joueurs(String name, int direction, Color color, int x, int y)
	{
		head = new Positions(x, y, null);
	}
	
	
	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}
	
}
