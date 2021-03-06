package Model;

// TODO: Auto-generated Javadoc
/**
 * The Class LengthNode.
 */
public class Positions {

	
	/** The y. */
	private int x, y;
	
	/** The next. */
	private Positions next;
	
	/**
	 * Instantiates a new length node.
	 *
	 * @param x the x
	 * @param y the y
	 * @param next the next
	 */
	public Positions(int x, int y, Positions next)
	{
		this.x = x;
		this.y = y;
		this.next = next;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Positions getNext() {
		return next;
	}

	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Positions next) {
		this.next = next;
	}
	
	/**
	 * Same values.
	 *
	 * @param other the other
	 * @return true, if successful
	 */
	public boolean sameValues(Positions other)
	{
		if(other.getX() == this.getX() && this.getY() == other.getY())
			return true;
		else
			return false;
	}
	
}
