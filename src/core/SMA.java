package core;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class SMA extends Observable {
	private List<Agent> listAgent;
	private Environment environment;
	private int nbTicks;

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

		for (int i = 0; i < environment.getNbTicks(); i++) {
			for (Agent agent : listAgent) {
				if (PropertiesReader.getInstance().getProperties("scheduling").equals("ALEATOIRE")) {
					Random r = new Random();
					int bool = r.nextInt(1);
					if (bool == 1)
						agent.decide();
				} else {
					agent.decide();
				}
				if (PropertiesReader.getInstance().getProperties("trace").equals("true"))
					System.out.println("");
			}
				environment.update(listAgent);
				environment.printTest();

			if (PropertiesReader.getInstance().getProperties("scheduling").equals("EQUITABLE")
					|| PropertiesReader.getInstance().getProperties("scheduling").equals("ALEATOIRE"))
				Collections.shuffle(listAgent);
				notifyObservers();
				setChanged();


			try {
				Thread.sleep(Integer.parseInt(PropertiesReader.getInstance().getProperties("delay")));
			} catch (InterruptedException e) {
				if (PropertiesReader.getInstance().getProperties("trace").equals("true"))
					System.err.println("sleep problem");
				e.printStackTrace();
			}
		}
	}
}