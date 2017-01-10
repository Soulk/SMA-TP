package model;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import Utils.Agent;
import View.View;

public class SMA extends Observable{
	private List<Agent>listAgent;
	private Environment environment;

	public SMA(List<Agent> listAgent, View view) {
		this.addObserver(view);

		environment = new Environment();
		this.listAgent = environment.initialisation();
		notifyObservers();
		setChanged();
	}

	/**
	 * run the simulation
	 */
	public void run() {

		while(true){
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
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.err.println("sleep problem");
				e.printStackTrace();
			}
		}
	}
}
