package model;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import Utils.Agent;
import Utils.PropertiesReader;
import View.View;

public class SMA extends Observable{
	private List<Agent>listAgent;
	private Environment environment;
	private int nbTicks;

	public SMA(List<Agent> listAgent, View view) {
		this.addObserver(view);

		nbTicks = Integer.parseInt(PropertiesReader.getInstance().getProperties("nbTicks"));
		environment = new Environment();
		this.listAgent = environment.initialisation();
		notifyObservers();
		setChanged();
	}

	/**
	 * run the simulation
	 */
	public void run() {

		for(int i = 0; i<nbTicks; i++){
			for(Agent agent : listAgent){
				agent.decide();
				System.out.println("");
			}
			environment.update(listAgent);
			environment.printTest();

			Collections.shuffle(listAgent);

			notifyObservers();
			setChanged();

			try {
				Thread.sleep(Integer.parseInt(PropertiesReader.getInstance().getProperties("delay")));
			} catch (InterruptedException e) {
				System.err.println("sleep problem");
				e.printStackTrace();
			}
		}
	}
}
