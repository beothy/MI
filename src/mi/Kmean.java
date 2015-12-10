package mi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Kmean implements Modell {
	//Array of clusters
	public ArrayList<Cluster> clusters = new ArrayList<Cluster>(); 

	//standard k-mean algorithm
	public void kmean(int k, int vector, int metric) {
		// TODO Auto-generated method stub

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
				
				while(line != null){
					String[] params = line.split("\t");
					
					Item item = new Item();
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
