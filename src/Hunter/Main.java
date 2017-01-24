package Hunter;

import core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by decottignies on 18/01/17.
 */
public class Main {

    public static void main(String[] args) {
        Environment env = new Environment();
        GameChanger changer = new GameChanger();
        View view = new View(env);
        InfoView info = new InfoView(env);
        
        // core.View
        JFrame f = new JFrame();
        f.setSize(Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeX")), Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeY")));
        f.setLayout(new BorderLayout());
        f.add(view, BorderLayout.CENTER);
        f.add(info,BorderLayout.EAST);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setVisible(true);
        

        // Launch
        java.util.List<Agent> agents = new ArrayList<Agent>();
        SMA sma = new SMA(agents, view, info, "hunter");

        for(int i=0; i<sma.listAgent.size();i++) {
//            f.addKeyListener((KeyListener) sma.listAgent.get(i));
        }
        f.addKeyListener((KeyListener) changer );
        sma.run();
    }

}
