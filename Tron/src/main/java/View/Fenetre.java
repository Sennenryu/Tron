package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class GameFrame.
 */
public class Fenetre extends JFrame implements ActionListener{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The Constant FRAME_HEIGHT. */
	public static final int FRAME_WIDTH = 600, FRAME_HEIGHT = 400;

	
	/** The game panel. */
	public Deplacements gamePanel;

	/**
	 * Instantiates a new game frame.
	 */
	public Fenetre()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Tron Java Alexandre HALTER");
		setResizable(false);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		gamePanel = new Deplacements();
		
		
		gamePanel.setVisible(true);
		add(gamePanel);
		gamePanel.start();
		
		setVisible(true);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
			gamePanel.setVisible(true);
			add(gamePanel);
			gamePanel.start();
		
	}

}
