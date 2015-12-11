package mi;

import java.awt.Color;
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
