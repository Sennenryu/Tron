package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import Model.Joueurs;

// TODO: Auto-generated Javadoc
/**
 * La Class GameLogic.
 */
public class Collisions {
	
	/**  Player 2 and 1. */
	private Joueurs player1, player2;
	
	/** The height and the width. */
	private int width, height;
	
	/** The color P 2. */
	private Color colorP1, colorP2;
	
	/** The P 1 start X. */
	//Coordonnées de départ des joueurs
	private int P1StartX = 450;
	
	/** The P 1 start Y. */
	private int P1StartY = 175;
	
	/** The P 2 start X. */
	private int P2StartX = 150;
	
	/** The P 2 start Y. */
	private int P2StartY = 175;

	/**
	 * Instantiates a new game logic.
	 *
	 * @param maxWidth the max width
	 * @param maxHeight the max height
	 */
	public Collisions(int maxWidth, int maxHeight)
	{
		width = maxWidth;
		height = maxHeight;
		colorP1 = new Color(0,0,255);
		colorP2 = new Color(255, 0, 0 );

		player1 = new Joueurs("bleu",Joueurs.LEFT, colorP1, P1StartX, P1StartY);  //commence de la droite
		player2 = new Joueurs("rouge", Joueurs.RIGHT, colorP2, P2StartX, P2StartY);  //commence de la gauche 
	}


	/**
	 * Sets the p 1 direction.
	 *
	 * @param direct the new p 1 direction
	 */
	public void setP1Direction(int direct)
	{
		player1.setDirection(direct);
	}

	/**
	 * Sets the p 2 direction.
	 *
	 * @param direct the new p 2 direction
	 */
	public void setP2Direction(int direct)
	{
		player2.setDirection(direct);
	}

	/**
	 * Gets the p 1 name.
	 *
	 * @return the p 1 name
	 */
	public String getP1Name()
	{
		return player1.getName();
	}

	/**
	 * Gets the p 2 name.
	 *
	 * @return the p 2 name
	 */
	public String getP2Name()
	{
		return player2.getName();
	}

	/**
	 * Gets the p1.
	 *
	 * @return the p1
	 */
	public Joueurs getP1(){
		return player1;
	}

	/**
	 * Gets the p2.
	 *
	 * @return the p2
	 */
	public Joueurs getP2(){
		return player2;
	}


	/**
	 * Step and ok.
	 *
	 * @return true, if successful
	 * @throws ClassNotFoundException the class not found exception
	 */
	public boolean stepAndOk() throws ClassNotFoundException
	{

		player1.step();
		player2.step();
		//Permet de connaître le Uptime du Jeu, et donc la durée de la partie.
		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		long uptime = rb.getUptime();
		
		if(player1.loosed(player2, width, height))
		{
			player2.isWinner(uptime);
			return false;
		}
		else if(player2.loosed(player1, width, height))
		{
			player1.isWinner(uptime);
			return false;
		}
		return true;
	}


	/**
	 * Restart.
	 */
	public void  restart()
	{
		player1 = new Joueurs(player1.getName(), Joueurs.LEFT, colorP1,P1StartX, P1StartY);
		player2 = new Joueurs(player2.getName(), Joueurs.RIGHT, colorP2,P2StartX, P2StartY);
	}



	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	public void draw(Graphics g)
	{
		player1.draw(g);
		player2.draw(g);
	}

}
