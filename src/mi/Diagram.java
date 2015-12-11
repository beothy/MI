package mi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Diagram extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8359661270430825821L;
	private volatile boolean init = true;
	private volatile boolean draw = false;
	private int numOfCL;
	private ArrayList<Cluster> clusters;
	private ArrayList<Double> minmax;
	
	Diagram() {
		numOfCL=1;
		clusters = null;
		minmax = null;
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
		 
		 for(int i=0;i<clusters.size();i++){
			 	float hue = i/(float)clusters.size();
			 	System.out.println(hue);
			    float saturation = 1.0f;
			    float brightness = 1.0f;
			    Color c = Color.getHSBColor(hue,saturation,brightness);
			    System.out.println(c.toString());
			    g2d.setPaint(c);
			    
			   for(int j = 0; j< clusters.get(i).items.size();j++){
				   Item item = clusters.get(i).items.get(j);
				   g2d.drawLine(15+100, (int)(515-item.getWidth()*500/minmax.get(1)), 15+200, (int)(515-item.getHeight()*500/minmax.get(3)));
				   g2d.drawLine(15+200, (int)(515-item.getHeight()*500/minmax.get(3)), 15+300, (int)(515-item.getArea()*500/minmax.get(5)));
				   g2d.drawLine(15+300, (int)(515-item.getArea()*500/minmax.get(5)), 15+400, (int)(515-item.getPerimeter()*500/minmax.get(7)));
				   g2d.drawLine(15+400, (int)(515-item.getPerimeter()*500/minmax.get(7)), 15+500, (int)(515-item.getShapeFactor()*500/minmax.get(9)));
				   g2d.drawLine(15+500, (int)(515-item.getShapeFactor()*500/minmax.get(9)), 15+600, (int)(515-item.getAreaLoadFactor()*500/minmax.get(11)));
				  
			   }
		 }
		 	
	 }
	 
	 public void init(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g.create();
		 
		 for(int i = 1; i<6;i++)
			 g2d.drawRect(15+i*100, 15, 100, 500);
		 
		 g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		 g2d.drawString("Properties:", 15, 535);
		 g2d.drawString("Width", 93, 535);
		 g2d.drawString("Height", 200, 535);
		 g2d.drawString("Area", 300, 535);
		 g2d.drawString("Perimeter", 385, 535);
		 g2d.drawString("ShapeFactor", 478, 535);
		 g2d.drawString("AreaLoadFactor", 570, 535);
		 
		 for(int i = 0; i < 360; i += 360/numOfCL) {
			   
			    float hue = i/360f;
			    float saturation = 1.0f;
			    float brightness = 1.0f;
			    Color c = Color.getHSBColor(hue,saturation,brightness);

			    g2d.setPaint(c);
			    g2d.fill(new Rectangle2D.Double((i/(360/(double)numOfCL))*30, 550, 30, 10));
		}
		
	 }
	 
	 public void init() {
		 init = true;
		 this.repaint();
	 }
	 
	 public void draw(int k,ArrayList<Cluster> clstr,ArrayList<Double> minimax) {
		 clusters = clstr;
		 minmax = minimax;
		 draw = true;
		 numOfCL = k;
		 this.repaint();
	 }
	 
}
