package mi;

import java.util.ArrayList;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3460122664562727503L;
	public abstract void init();
	public abstract void draw(int k,ArrayList<Cluster> clstr);
}
