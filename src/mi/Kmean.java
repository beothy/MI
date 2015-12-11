package mi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Kmean implements Modell {
	//Array of clusters
	public ArrayList<Cluster> clusters = new ArrayList<Cluster>();
	public ArrayList<Double> minmax = new ArrayList<Double>();

	//standard k-mean algorithm
	public void kmean(int k, int vector, int metric, Cluster c) 
	{
		//Mivel a kis számláló bigyó csak 1tõl enged, lehetne, hogy 1-nél nem csinál semmit, mert mr úgyis 1 klaszter van
		if(k<1)
			new Exception("Warning! The value of k is incorrect.");
		else if(k==1)
			return;
		
		clusters.remove(c);
		ArrayList<Cluster> newClusters = new ArrayList<Cluster>();
		newClusters.add(c);
		for(int i = 0;i<k-1;i++){
			Cluster tmp = new Cluster();
			
			switch(vector){
			case 0:
				tmp.setCentroid(c.createRandCentroid(minmax));
				c.setCentroid(c.createRandCentroid(minmax));
				break;
			case 1:
				tmp.setCentroid(c.createRandCentfromData(c));
				c.setCentroid(c.createRandCentfromData(c));
				break;
			}
			
			newClusters.add(tmp);
		}
		
		boolean finish = false;
		
		while(!finish){
			for(int i=0;i<newClusters.size();i++)
				for(int j=0;j<newClusters.get(i).items.size();j++){
					int index = this.getClustertoItem(newClusters.get(i).items.get(j), metric, newClusters);
					if(index!=i){
						newClusters.get(index).items.add(newClusters.get(i).items.get(j));
						newClusters.get(i).items.remove(newClusters.get(i).items.get(j));
					}
				}
			
			for(int l=0;l<newClusters.size();l++){
				newClusters.get(l).setCentroid(newClusters.get(l).calcNewCentroid());
				double dist = 0;
				switch(metric){
				case 0:
					dist = newClusters.get(l).centroid.euklid_distance(newClusters.get(l).centroid, newClusters.get(l).lastCentroid);
					break;
				case 1:
					dist = newClusters.get(l).centroid.cos_distance(newClusters.get(l).centroid, newClusters.get(l).lastCentroid);
					break;
				}
				if(dist == 0)
					finish = true;
				else
					finish = false;
			}
		}
		clusters.addAll(newClusters);
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
		this.kmean(k, vector, metric, clusters.get(0));
	}

	public int getClustertoItem( Item i, int metric, ArrayList<Cluster> clusters)
	{
		int index = -5;
		double minDist = Double.MAX_VALUE;
		double dist = 0;
		//ez it tkérdéses
		for(int j = 0; j < clusters.size(); j++)
		{
			if(metric == 1)
				dist = i.cos_distance(i, clusters.get(j).getCentroid());
			if(metric == 0)
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
					
			} /*catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}*/ catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			}finally {
			
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
	@Override
	public ArrayList<Double> getminmax() {
		// TODO Auto-generated method stub
		return minmax;
	}

}
