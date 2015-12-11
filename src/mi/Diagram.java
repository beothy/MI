package mi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Diagram extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8359661270430825821L;
	private volatile boolean init = true;
	private volatile boolean draw = false;
	private int numOfCL;
	
	Diagram() {
		numOfCL=1;
	}
	
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
		 
		 for(int i = 0; i < 360; i += 360/numOfCL) {
			   
			    float hue = i/360f;
			    float saturation = 1.0f;
			    float brightness = 1.0f;
			    Color c = Color.getHSBColor(hue,saturation,brightness);

			    g2d.setPaint(c);
			    g2d.fill(new Rectangle2D.Double((i/(360/(double)numOfCL))*30, 550, 30, 10));
			    System.out.println(hue);
		}
		
	 }
	 
	 public void init() {
		 init = true;
		 this.repaint();
	 }
	 
	 public void draw(int k) {
		 draw = true;
		 numOfCL = k;
		 this.repaint();
	 }
	 
}
