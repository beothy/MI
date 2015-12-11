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
	
	//Ez fog uj centroidot szamolni
	public Item calcNewCentroid(){
		Item centr = new Item();
		double w = 0;
		double h = 0;
		double a = 0;
		double p = 0;
		double sf = 0;
		double alf = 0;
		
		for(int i = 0; i<items.size();i++){
			w+=items.get(i).getWidth();
			h+=items.get(i).getHeight();
			a+=items.get(i).getArea();
			p+=items.get(i).getPerimeter();
			sf+=items.get(i).getShapeFactor();
			alf+=items.get(i).getAreaLoadFactor();
		}
		w/=items.size();
		h/=items.size();
		a/=items.size();
		p/=items.size();
		sf/=items.size();
		alf/=items.size();
		
		centr.setWidth(w);
		centr.setHeight(h);
		centr.setArea(a);
		centr.setPerimeter(p);
		centr.setShapeFactor(sf);
		centr.setAreaLoadFactor(alf);
		
		return centr;
	}
	
	public Item getCentroid()
	{
		return centroid;
	}
	
	public void setCentroid(Item c)
	{
		this.centroid = c;
	}
	
	public static Item createRandCentroid(ArrayList<Double> minmax){ //atirva hogy tombot kapjon
		double wMin = minmax.get(0);
		double wMax = minmax.get(1);
		double hMin = minmax.get(2);
		double hMax = minmax.get(3);
		double aMin = minmax.get(4);
		double aMax = minmax.get(5);
		double pMin = minmax.get(6);
		double pMax = minmax.get(7);
		double sfMin = minmax.get(8);
		double sfMax = minmax.get(9);
		double alfMin = minmax.get(10);
		double alfMax = minmax.get(11);
		Item RandomCentroid = new Item();
		double wR = Math.random()*wMax + wMin;
		double hR = Math.random()*hMax + hMin;
		double aR = Math.random()*aMax + aMin;
		double pR = Math.random()*pMax + pMin;
		double sfR = Math.random()*sfMax + sfMin;
		double alfR = Math.random()*alfMax + alfMin;
		RandomCentroid.setWidth(wR);
		RandomCentroid.setHeight(hR);
		RandomCentroid.setArea(aR);
		RandomCentroid.setPerimeter(pR);
		RandomCentroid.setShapeFactor(sfR);
		RandomCentroid.setAreaLoadFactor(alfR);
		return RandomCentroid;
	}
	
	public static Item createRandCentfromData(Cluster c) //konretan egy klasztert kap
	{
		Item RandCentfromData = new Item();
		int max = c.items.size(); //az itemek saáma az erdekes
		int min = 1;
		int R = (int)Math.random()*max + min;
		RandCentfromData = c.items.get(R);
		return RandCentfromData;
	}
	
}
