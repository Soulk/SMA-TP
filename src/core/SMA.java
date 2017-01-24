package core;

import utils.CSVManager;

import java.util.*;

import static java.lang.System.in;

public class SMA extends Observable {
	public static List<Agent> listAgent;
	private Environment environment;
	public static int nbTicks,delay;
    public static boolean stopped;

	public SMA(List<Agent> listAgent, View view,InfoView infoView, String game) {
		this.addObserver(view);
		this.addObserver(infoView);
        delay = Integer.parseInt(PropertiesReader.getInstance().getProperties("delay"));
        stopped = false;
		environment = new Environment();
		this.listAgent = environment.initialisation(game);
		notifyObservers();
		setChanged();
	}
	public List<Agent> tabToList(Agent[][] tab) {
		List<Agent> lst = new ArrayList<Agent>();
		for(int i=0;i<Environment.getTailleX();i++) {
			for(int j=0;j<Environment.getTailleY();j++) {
				if(Environment.getTab()[i][j] != null)lst.add(Environment.getTab()[i][j]);
			}
		}
		return lst;
	}

	/**
	 * run the simulation
	 */
	public void run() {
		for (int i = 0; i < environment.getNbTicks(); i++) {
			for(int j=0;j<listAgent.size();j++) {
				if (PropertiesReader.getInstance().getProperties("scheduling").equals("ALEATOIRE")) {
					Random r = new Random();
					int bool = r.nextInt(1);
					if (bool == 1)
						listAgent.get(j).decide();
				} else {
					listAgent.get(j).decide();
				}
				if (PropertiesReader.getInstance().getProperties("trace").equals("true"))
					System.out.println("");
				//listAgent = tabToList(Environment.getTab());
			}
				environment.update(listAgent);
				environment.printTest();

			if (PropertiesReader.getInstance().getProperties("scheduling").equals("EQUITABLE")
					|| PropertiesReader.getInstance().getProperties("scheduling").equals("ALEATOIRE"))
				Collections.shuffle(listAgent);
				notifyObservers();
				setChanged();
			nbTicks++;


			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				if (PropertiesReader.getInstance().getProperties("trace").equals("true"))
					System.err.println("sleep problem");
				e.printStackTrace();
			}
            while(stopped) {

            }
			if(Boolean.parseBoolean(PropertiesReader.getInstance().getProperties("csv")))
				CSVManager.getInstance().writeCSV("TICK;"+environment.getNbSharks()+";"+environment.getNbFish()+"\n");
		}
		if(Boolean.parseBoolean(PropertiesReader.getInstance().getProperties("csv")))CSVManager.getInstance().stopRecord();

	}
}
