package mi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Kmean implements Modell {
	public ArrayList<Item> items = new ArrayList<Item>(); 

	@Override
	public void kmean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loadFile(String path) {
		// TODO Auto-generated method stub
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
					
					items.add(item);
					
					line = br.readLine();
				}
						
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Kmean [items=" + items + "]";
	}

	@Override
	public ArrayList<Item> getList() {
		// TODO Auto-generated method stub
		return items;
	}

}
