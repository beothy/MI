package mi;

import java.util.ArrayList;

public class Cluster {
	public ArrayList<Item> items = new ArrayList<Item>(); 
	public Item centroid;
	
	public void Claster()
	{
		this.items = new ArrayList<Item>();
		this.centroid = null;
	}
	
	
	
	public Item getCentroid()
	{
		return centroid;
	}
	
	public void setCentroid(Item c)
	{
		this.centroid = c;
	}
	
}
