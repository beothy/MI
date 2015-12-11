package mi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Kmean implements Modell {
	//Array of clusters
	public ArrayList<Cluster> clusters = new ArrayList<Cluster>();
	public ArrayList<Double> minmax = new ArrayList<Double>();

	//standard k-mean algorithm
	public void kmean(int k, int vector, int metric) 
	{
		int clust_num = k;
		

	}
	//bisect kmean algorithm
	public void bisect(int k, int vector, int metric){
		
	}
	
	//execute one step of kmean
	@Override
	public void step(int k, int vector, int metric) {
		// TODO Auto-generated method stub
		
	}


	//execute the full algorithm
	@Override
	public void run(int k, int vector, int metric) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loadFile(String path) {
		// TODO Auto-generated method stub
		clusters.add(new Cluster());
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line = br.readLine();
				line = br.readLine();
				
				String[] params = line.split("\t");
				
				Item item = new Item();
				item.setWidth(Double.parseDouble(params[1]));
				minmax.add(item.getWidth());
				minmax.add(item.getWidth());
				item.setHeight(Double.parseDouble(params[2]));
				minmax.add(item.getHeight());
				minmax.add(item.getHeight());
				item.setArea(Double.parseDouble(params[3]));
				minmax.add(item.getArea());
				minmax.add(item.getArea());
				item.setPerimeter(Double.parseDouble(params[4]));
				minmax.add(item.getPerimeter());
				minmax.add(item.getPerimeter());
				item.setShapeFactor(Double.parseDouble(params[5]));
				minmax.add(item.getShapeFactor());
				minmax.add(item.getShapeFactor());
				item.setAreaLoadFactor(Double.parseDouble(params[6]));
				minmax.add(item.getAreaLoadFactor());
				minmax.add(item.getAreaLoadFactor());
				
				clusters.get(0).items.add(item);
				
				line = br.readLine();
				
				while(line != null){
					params = line.split("\t");
					
					item = new Item();
					item.setWidth(Double.parseDouble(params[1]));
					if(item.getWidth()<minmax.get(0))
						minmax.set(0, item.getWidth());
					else if(item.getWidth()>minmax.get(1))
						minmax.set(1, item.getWidth());
					item.setHeight(Double.parseDouble(params[2]));
					if(item.getHeight()<minmax.get(2))
						minmax.set(2, item.getHeight());
					else if(item.getHeight()>minmax.get(3))
						minmax.set(3, item.getHeight());
					item.setArea(Double.parseDouble(params[3]));
					if(item.getArea()<minmax.get(4))
						minmax.set(4, item.getArea());
					else if(item.getArea()>minmax.get(5))
						minmax.set(5, item.getArea());
					item.setPerimeter(Double.parseDouble(params[4]));
					if(item.getPerimeter()<minmax.get(6))
						minmax.set(6, item.getPerimeter());
					else if(item.getPerimeter()>minmax.get(7))
						minmax.set(7, item.getPerimeter());
					item.setShapeFactor(Double.parseDouble(params[5]));
					if(item.getShapeFactor()<minmax.get(8))
						minmax.set(8, item.getShapeFactor());
					else if(item.getShapeFactor()>minmax.get(9))
						minmax.set(9, item.getShapeFactor());
					item.setAreaLoadFactor(Double.parseDouble(params[6]));
					if(item.getAreaLoadFactor()<minmax.get(10))
						minmax.set(10, item.getAreaLoadFactor());
					else if(item.getAreaLoadFactor()>minmax.get(11))
						minmax.set(11, item.getAreaLoadFactor());
					
					clusters.get(0).items.add(item);
					
					line = br.readLine();
				}
				br.close();		
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				for(double i : minmax)
					System.out.println(i);
			}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	@Override
	public ArrayList<Cluster> getList() {
		// TODO Auto-generated method stub
		return clusters;
	}

}
