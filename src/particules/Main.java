package particules;

import core.*;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		Environment env = new Environment();
		View view = new View(env);
		InfoView info = new InfoView(env);
		
		// core.View
		JFrame f = new JFrame();
		f.setSize(Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeX")), Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeY")));
		f.setLayout(new BorderLayout());
		f.add(view, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationByPlatform(true);
		f.setVisible(true);
		
		// Launch 
		List<Agent> agents = new ArrayList<Agent>();
		SMA sma = new SMA(agents, view, info, "particules");
		sma.run();
		
	}

}
