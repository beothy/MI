package mi;

import java.util.ArrayList;

public interface Modell {
	public ArrayList<Cluster> getList();
	public void kmean();
	public void step(int k,int vector, int metric);
	public void run(int k,int vector, int metric);
	public boolean loadFile(String path);
}
