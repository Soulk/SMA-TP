package core;

import Hunter.Avatar;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;


import javax.swing.*;

public class InfoView extends JPanel implements Observer{

    private Environment env;
    private int canvasSizeX, canvasSizeY, boxSize;
    private int cptTicks;
    JLabel nbTicks, nbSharks, nbFish, speedAvatar, speedHunter, speedGame;
    public InfoView (Environment env){
        super();
        this.env = env;
        cptTicks = 0;
        Font f = new Font("Serif", Font.PLAIN, 22);
        nbTicks = new JLabel("Tick :" + 0);
        nbTicks.setFont(f);
        nbSharks = new JLabel("Sharks :"+0);
        nbSharks.setFont(f);
        nbFish = new JLabel("Fishs :"+0);
        nbFish.setFont(f);
        speedAvatar = new JLabel("Vitesse avatar :"+0);
        speedAvatar.setFont(f);
        speedHunter = new JLabel("Vitesse hunter :"+0);
        speedHunter.setFont(f);
        speedGame = new JLabel("Vitesse game :" + SMA.delay);
        speedGame.setFont(f);
        this.add(nbTicks);
        this.add(nbSharks);
        this.add(nbFish);
        this.add(speedAvatar);
        this.add(speedHunter);
        this.add(speedGame);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }


    @Override
    public void update(Observable o, Object arg) {
        cptTicks++;
        nbTicks.setText("Tick :" + cptTicks);
        nbSharks.setText("Sharks :"+env.getNbSharks());
        nbFish.setText("Fish :"+env.getNbFish());
        speedAvatar.setText("Vitesse avatar :"+ Avatar.speedAvatar);
        speedHunter.setText("Vitesse hunter :"+ Hunter.GameChanger.speedHunter);
        speedGame.setText("Vitesse game :"+SMA.delay);

    }

}
