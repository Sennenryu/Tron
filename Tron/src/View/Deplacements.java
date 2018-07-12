package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.Collisions;
import Model.Joueurs;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel.
 */
public class Deplacements extends JPanel implements ActionListener, KeyListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logic. */
	private Collisions logic;
	
	/** The Constant W and H. */
	public static final int W = 1200, H = 800;


	


	/** The timer general. */
	Timer timerGeneral;
	

	/**
	 * Instantiates a new game panel.
	 */
	public Deplacements() {
		
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setSize(W, H);
	
		
		
		logic = new Collisions(W, H);
		timerGeneral = new Timer(30, this);

	}

	

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		logic.draw(g);
	}


	
	/**
	 * Start.
	 */
	public void start(){
		
		logic.restart();
		timerGeneral.start();
	}
	
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==timerGeneral)
		{
			
			try {
				if(logic.stepAndOk())
					repaint();
				else
				{
					timerGeneral.stop();	
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}


		

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * Touches du joueur 1
		 */
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(logic.getP1().getDirection() != Joueurs.UP)
				logic.setP1Direction(Joueurs.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			if(logic.getP1().getDirection() != Joueurs.DOWN)
				logic.setP1Direction(Joueurs.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(logic.getP1().getDirection() != Joueurs.RIGHT)
				logic.setP1Direction(Joueurs.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(logic.getP1().getDirection() != Joueurs.LEFT)
				logic.setP1Direction(Joueurs.RIGHT);
		}

		/*
		 * Touches du joueur 2
		 */
		if(e.getKeyCode() == KeyEvent.VK_S){
			if(logic.getP2().getDirection() != Joueurs.UP)
				logic.setP2Direction(Joueurs.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			if(logic.getP2().getDirection() != Joueurs.DOWN)
				logic.setP2Direction(Joueurs.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			if(logic.getP2().getDirection() != Joueurs.RIGHT)
				logic.setP2Direction(Joueurs.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			if(logic.getP2().getDirection() != Joueurs.LEFT)
				logic.setP2Direction(Joueurs.RIGHT);
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}
