package core;

import particules.Particules;
import water.Fish;
import water.Shark;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import Hunter.Avatar;

public class Environment extends Observable {
	private static Agent[][] tab;
	private static int tailleX;
	private static int tailleY;
	private int nbAgent, nbShark, nbFish;
	private int nbTicks;


	public Environment() {
		tab = new Agent[Integer.parseInt(PropertiesReader.getInstance().getProperties("gridSizeX"))]
					   [Integer.parseInt(PropertiesReader.getInstance().getProperties("gridSizeY"))];
		tailleX = Integer.parseInt(PropertiesReader.getInstance().getProperties("gridSizeX"));
		tailleY = Integer.parseInt(PropertiesReader.getInstance().getProperties("gridSizeY"));
		nbAgent = Integer.parseInt(PropertiesReader.getInstance().getProperties("nbParticles"));
		nbFish = Integer.parseInt(PropertiesReader.getInstance().getProperties("nbFish"));
		nbShark = Integer.parseInt(PropertiesReader.getInstance().getProperties("nbShark"));
        nbTicks = Integer.parseInt(PropertiesReader.getInstance().getProperties("nbTicks"));

	}

	/**
	 * create all the agents
	 * @return
	 */
	public List<Agent> initialisation(String game) {
			List<Agent> agents = new ArrayList<Agent>();

			for (int i = 0; i < nbAgent; i++) {
				MyColor color = null;
				Agent agent = null;
				// find a position
				Random r = new Random();
				int x = -1, y = -1;
				while (!isAGoodPosition(x, y)) {
					x = r.nextInt(tailleX);
					y = r.nextInt(tailleY);
				}

				// find a direction
				String direction = Direction.dir[r.nextInt(Direction.dir.length)];

				if (game.equals("particules")) {

					//find a color
					color = MyColor.randomColor();

					// create the agent
					agent = new Particules(x, y, color, direction);
				} else if (game.equals("water")){

					if(nbShark > 0) {
						color = MyColor.Rose;
						nbShark--;
						agent = new Shark(x, y, color, direction);
					} else if (nbFish >= 0){
						color = MyColor.Vert;
						nbFish--;
						agent = new Fish(x, y, color, direction);
					}

				} else if (game.equals("hunter")){
					//// TODO: 18/01/17 
					color = MyColor.randomColor();
					
					agent = new Avatar(x, y, color, null);
                }

				if(agent != null) {
					agents.add(agent);
					// put the agent in the core.Environment
					tab[agent.getPosX()][agent.getPosY()] = agent;
				}
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
		if(x < 0 || y < 0 || x > tailleX || y > tailleY)
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
		/*for(int i = 0; i<Environment.getTailleX(); i++){
			for(int j = 0; j<Environment.getTailleY(); j++){
				tab[i][j] = null;
			}
		}
		for(Agent agent : agents){
			tab[agent.getPosX()][agent.getPosY()] = agent;
		}*/
	}
	
	public void printTest(){
		if(PropertiesReader.getInstance().getProperties("trace").equals("true"))System.out.println("<<<<<<<< Mon petit tableau >>>>>>>>");
		for(int i = 0; i<tailleX; i++){
			for(int j = 0; j<tailleY; j++){
				if(tab[i][j] != null){
					if(PropertiesReader.getInstance().getProperties("trace").equals("true"))System.out.print("0");
				} else {
					if(PropertiesReader.getInstance().getProperties("trace").equals("true"))System.out.print("-");
				}
			}
			if(PropertiesReader.getInstance().getProperties("trace").equals("true"))System.out.println("");
		}

	}

	public static String findWall(int x, int y) {
        String pos ="";
        if(x == -1) pos+="N";
        if(x >= tailleX) pos+="S";
        if(y == -1)pos+="W";
        if(y >= tailleY)pos+="E";
        return pos;
    }

    public int getNbSharks() {
		int cpt = 0;
		for(int i = 0; i < SMA.listAgent.size();i++) {
			if(SMA.listAgent.get(i).getClass().equals(Shark.class)) {
				cpt ++;
			}
		}
		return cpt;
	}
	public int getNbFish() {
		int cpt = 0;
		for(int i = 0; i < SMA.listAgent.size();i++) {
			if(SMA.listAgent.get(i).getClass().equals(Fish.class)) {
				cpt ++;
			}
		}
		return cpt;
	}

	public int getNbTicks(){
        return nbTicks;
    }
}
