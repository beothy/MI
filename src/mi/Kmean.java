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
		if(k<2)
			new Exception("Warning! The value of k is incorrect.");
		
		/*while()
		{
			
		}*/
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

	public int getClustertoItem( Item i, int metric)
	{
		int index = -5;
		double minDist = Double.MAX_VALUE;
		double dist = 0;
		for(int j = 0; j < clusters.get(0).items.size(); j++)
		{
			if(metric == 0)
				dist = i.cos_distance(i, clusters.get(j).getCentroid());
			if(metric == 1)
				dist = i.euklid_distance(i, clusters.get(j).getCentroid());
			if(dist < minDist)	
			{
				minDist = dist;
				index = j;
			}
		}
		return index;
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
					item.setHeight(Double.parseDouble(params[2]));
					item.setArea(Double.parseDouble(params[3]));
					item.setPerimeter(Double.parseDouble(params[4]));
					item.setShapeFactor(Double.parseDouble(params[5]));
					item.setAreaLoadFactor(Double.parseDouble(params[6]));
					
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
