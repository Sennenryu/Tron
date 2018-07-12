package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Joueurs {

	/** The name. */
	private String name;
	
	/** The direction. */
	private int direction;
	
	/** The head. */
	private Positions head;
	
	/** The color. */
	private Color color;

	/** The right. */
	public static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;


	/** The thiknes. */
	public static int PIX_PER_STEP = 5, THIKNES = 5;

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param direction the direction
	 * @param color the color
	 * @param x the x
	 * @param y the y
	 */
	public Joueurs(String name, int direction, Color color, int x, int y)
	{
		this.name = name;
		this.direction = direction;
		this.color = color;
		head = new Positions(x, y, null);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}



	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}



	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public Positions getHead() {
		return head;
	}

	/**
	 * Step.
	 */
	public void step()
	{
		switch(direction)
		{
		case 1: 		//haut
			head = new Positions(head.getX(), head.getY() - PIX_PER_STEP, head);
			break;
		case 2: 		//bas
			head = new Positions(head.getX(), head.getY() + PIX_PER_STEP, head);
			break;
		case 3: 		//gauche
			head = new Positions(head.getX() - PIX_PER_STEP, head.getY(), head);
			break;
		case 4: 		//droite
			head = new Positions(head.getX() + PIX_PER_STEP, head.getY(), head);
			break;
		}

	}



	/**
	 * Loosed.
	 *
	 * @param other the other
	 * @param maxWidth the max width
	 * @param maxHeight the max height
	 * @return true, if successful
	 */
	public boolean loosed(Joueurs other, int maxWidth, int maxHeight)
	{
		//joueur se touche lui-même
		for(Positions p = head.getNext(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//il touche un autre joueur
		for(Positions p = other.getHead(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//il touche les bordures
		if(head.getX() < 0 || head.getY() < 0 || head.getX() > maxWidth + THIKNES || head.getY() > maxHeight + THIKNES)
			return true;

		return false;
	}
	
	/**
	 * Checks if is winner.
	 *
	 * @param uptime the uptime
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void isWinner(long uptime) throws ClassNotFoundException {
		
		float Uptime = uptime;
		Uptime = Uptime/1000;
		String Time = Float.toString(Uptime);
		
		try {
			String url="jdbc:mysql://localhost/tron?useSSL=false&serverTimezone=UTC";
		    String user="root";
		    String password="";
		   
		    Connection conn = null;
		    conn = DriverManager.getConnection(url, user, password);
		    CallableStatement cStmt = conn.prepareCall("{call nouveau(?, ?)}");
		    cStmt.setString(1, this.getName());
		    cStmt.setString(2, Time);
		    cStmt.execute();
		    System.out.println("Vainqueur enregistré");


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		System.out.println("Le joueur " + this.getName() + " a gagné!");
		System.out.println("Temps: " + Uptime + "s");
		
	}


	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		Positions p = head;
		for(;p != null; p=p.getNext()) {
			g.fillRect(p.getX(), p.getY(), THIKNES, THIKNES);	//tous les joueurs
		}
	}
	
	
}




