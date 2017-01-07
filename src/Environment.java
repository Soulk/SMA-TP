import java.util.ArrayList;
import java.util.List;

public class Environment {
	private Agent[][] tab;
	private int tailleX, tailleY;
	private int nbAgent;
	public Environment() {
		tab = new Agent[1][1];
		tailleX = 10;
		tailleY = 10;
		nbAgent = 2;
	}
	
	public void initialisation() {
		
	}
	public Agent[][] getEnv2d() {
		return tab;
	}
	
	public int getTailleX() {
		return tailleX;
	}
	public int getTailleY() {
		return tailleY;
	}
}
