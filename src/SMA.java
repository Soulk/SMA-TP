import java.util.Collections;
import java.util.List;
import java.util.Observable;


public class SMA extends Observable{
	private List<Agent>listAgent;
	private Environment environment;

	public SMA(List<Agent> listAgent, View view) {
		this.addObserver(view);
		setChanged();
		notifyObservers();

		environment = new Environment();
		this.listAgent = environment.initialisation();
	}

	/**
	 * run the simulation
	 */
	public void run() {

		while(true){
			for(Agent agent : listAgent){
				agent.decide();
			}
			environment.update(listAgent);
			environment.printTest();

			Collections.shuffle(listAgent);

			notifyObservers();
			setChanged();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("sleep problem");
				e.printStackTrace();
			}
		}
	}
}
