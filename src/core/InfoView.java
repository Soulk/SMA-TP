package core;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;


import javax.swing.*;

public class InfoView extends JPanel implements Observer{

    private Environment env;
    private int canvasSizeX, canvasSizeY, boxSize;
    private int cptTicks;

    public InfoView (Environment env){
        super();
        this.env = env;
        this.add(new JLabel("test"));
    }


    @Override
    public void update(Observable o, Object arg) {

    }

}
