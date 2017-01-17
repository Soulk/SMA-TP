package core;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;


import javax.swing.*;

public class InfoView extends JPanel implements Observer{

    private Environment env;
    private int canvasSizeX, canvasSizeY, boxSize;
    private int cptTicks;
    JLabel nbTicks, nbSharks, nbFish;
    public InfoView (Environment env){
        super();
        this.env = env;
        cptTicks = 0;
        nbTicks = new JLabel("Tick :" + 0);
        nbSharks = new JLabel("Sharks :"+0);
        nbFish = new JLabel("Fishs :"+0);
        this.add(nbTicks);
        this.add(nbSharks);
        this.add(nbFish);
    }


    @Override
    public void update(Observable o, Object arg) {
        cptTicks++;
        nbTicks.setText("Tick : " + cptTicks);
        nbSharks.setText("Sharks :"+env.getNbSharks());
        nbFish.setText("Fish :"+env.getNbFish());

    }

}
