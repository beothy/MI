/**
 * 
 */
package mi;

import java.util.ArrayList;

/**
 * @author Bence
 *
 */
public class Item {
	//Width	Height	Area	Perimeter	ShapeFactor	AreaLoadFactor	
	private double width;
	private double height;
	private double area;
	private double perimeter;
	private double shapeFactor;
	private double areaLoadFactor;
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}
	/**
	 * @return the perimeter
	 */
	public double getPerimeter() {
		return perimeter;
	}
	/**
	 * @param perimeter the perimeter to set
	 */
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	/**
	 * @return the shapeFactor
	 */
	public double getShapeFactor() {
		return shapeFactor;
	}
	/**
	 * @param shapeFactor the shapeFactor to set
	 */
	public void setShapeFactor(double shapeFactor) {
		this.shapeFactor = shapeFactor;
	}
	/**
	 * @return the areaLoadFactor
	 */
	public double getAreaLoadFactor() {
		return areaLoadFactor;
	}
	/**
	 * @param areaLoadFactor the areaLoadFactor to set
	 */
	public void setAreaLoadFactor(double areaLoadFactor) {
		this.areaLoadFactor = areaLoadFactor;
	}
	
	public double euklid_distance(Item i, Item centroid)
	{
		return Math.sqrt(Math.pow((i.getWidth()-centroid.getWidth()),2) 
				+ Math.pow(i.getHeight()-centroid.getHeight(),2)
				+ Math.pow(i.getArea()-centroid.getArea(),2)
				+ Math.pow(i.getPerimeter()-centroid.getPerimeter(), 2)
				+Math.pow(i.getShapeFactor()-centroid.getShapeFactor(), 2)
				+Math.pow(i.getAreaLoadFactor()-centroid.getAreaLoadFactor(), 2));
	}
	
	public double cos_distance(Item i, Item centroid)
	{
		return (i.getArea()*centroid.getArea()
				+ i.getHeight()*centroid.getHeight()
				+ i.getArea()*centroid.getArea()
				+ i.getPerimeter()*centroid.getPerimeter()
				+ i.getShapeFactor()*centroid.getShapeFactor()
				+ i.getAreaLoadFactor()*centroid.getAreaLoadFactor())
				/(Math.sqrt(Math.pow((i.getWidth()-centroid.getWidth()),2) 
				+ Math.pow(i.getHeight()-centroid.getHeight(),2)
				+ Math.pow(i.getArea()-centroid.getArea(),2)
				+ Math.pow(i.getPerimeter()-centroid.getPerimeter(), 2)
				+ Math.pow(i.getShapeFactor()-centroid.getShapeFactor(), 2)
				+ Math.pow(i.getAreaLoadFactor()-centroid.getAreaLoadFactor(), 2)));
	}
	
	
	
}
