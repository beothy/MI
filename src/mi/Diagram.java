package mi;

import java.awt.Color;
import java.awt.Graphics;


public class Diagram extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8359661270430825821L;
	
	 @Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);  // paint background
	      setBackground(Color.GRAY);
	 
	   }
}
