package mi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Diagram extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8359661270430825821L;
	private volatile boolean init = true;
	private volatile boolean draw = false;
	
	 @Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);  // paint background
	      setBackground(new Color(214,217,223));
	      
	      if(init) {
	    	   init(g);
	      } 
	      if(draw){
	    	  draw(g);
	      }
	   }
	 
	 public void draw(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g.create();
		 	
	 }
	 
	 public void init(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g.create();
		 
		 for(int i = 0; i<7;i++)
			 g2d.drawRect(15+i*100, 15, 100, 500);
		 
		 g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		 g2d.drawString("Properties:", 15, 535);
		 g2d.drawString("Width", 100, 535);
		 g2d.drawString("Height", 200, 535);
		 g2d.drawString("Area", 300, 535);
		 g2d.drawString("Perimeter", 400, 535);
		 g2d.drawString("ShapeFactor", 500, 535);
		 g2d.drawString("AreaLoadFactor", 600, 535);
	 }
	 
	 public void init() {
		 init = true;
		 this.repaint();
	 }
	 
	 public void draw() {
		 draw = true;
		 this.repaint();
	 }
	 
}
