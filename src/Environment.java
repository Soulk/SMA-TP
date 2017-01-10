import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Environment extends Observable {
	private static Agent[][] tab;
	private static int tailleX;
	private static int tailleY;
	private int nbAgent;
	
	public Environment() {
		tab = new Agent[10][10];
		tailleX = 10;
		tailleY = 10;
		nbAgent = 5;
	}

	/**
	 * create all the agents
	 * @return
	 */
	public List<Agent> initialisation() {
		List<Agent> agents = new ArrayList<Agent>();
		
		for(int i = 0; i<nbAgent; i++){
			// find a position
			Random r = new Random();
			int x = -1 , y = -1;
			while(!isAGoodPosition(x, y)){
				x = r.nextInt(tailleX - 1);
				y = r.nextInt(tailleY - 1);
			}
			
			//find a color
			MyColor color = MyColor.randomColor();
			
			// find a direction
			String direction = Direction.dir[r.nextInt(Direction.dir.length)];	
			
			// create the agent
			Agent agent = new Agent(x, y, color, direction);
			agents.add(agent);
			
			// put the agent in the Environment
			tab[agent.getPosX()][agent.getPosY()] = agent;
		}
		return agents;
	}

	/**
	 * test if a position doesn't contains an existant agent or is outside the map
	 * @param x
	 * @param y
	 * @return
	 */
	public Boolean isAGoodPosition(int x, int y){
		if(x < 0 || y < 0)
			return false;
		else if (tab[x][y] != null )
			return false;
		
		return true;
	}
	public Agent[][] getEnv2d() {
		return tab;
	}
	
	public static int getTailleX() {
		return tailleX;
	}
	public static int getTailleY() {
		return tailleY;
	}
	public static Agent[][] getTab(){
		return tab;
	}

	/**
	 * update the environment tab with the new agents
	 * @param agents
	 */
	public void update(List<Agent> agents){
		for(int i = 0; i<Environment.getTailleX(); i++){
			for(int j = 0; j<Environment.getTailleY(); j++){
				tab[i][j] = null;
			}
		}
		for(Agent agent : agents){
			tab[agent.getPosX()][agent.getPosY()] = agent;
		}
	}
	
	public void printTest(){
		System.out.println("<<<<<<<< Mon petit tableau >>>>>>>>");
		for(int i = 0; i<Environment.getTailleX(); i++){
			for(int j = 0; j<Environment.getTailleY(); j++){
				if(tab[i][j] != null){
					System.out.print("0");
				} else {
					System.out.print("-");
				}
			}
			System.out.println("");
		}

	}
}
