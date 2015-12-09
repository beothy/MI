package mi;

import java.util.ArrayList;

public interface Modell {
	public ArrayList<Item> getList();
	public void kmean();
	public void step();
	public void run();
	public boolean loadFile(String path);
}
