import Utils.Agent;
import View.View;
import model.Environment;
import model.SMA;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		Environment env = new Environment();
		View view = new View(env);
		
		// View.View
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLayout(new BorderLayout());
		f.add(view, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationByPlatform(true);
		f.setVisible(true);
		
		// Launch 
		List<Agent> agents = new ArrayList<Agent>();
		SMA sma = new SMA(agents, view);
		sma.run();
		
	}

}
