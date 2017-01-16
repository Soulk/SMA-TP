package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.awt.Color;


import javax.swing.JPanel;

public class View extends JPanel implements Observer{

	private Environment env;
	private int canvasSizeX, canvasSizeY, boxSize;
	private int cptTicks;
	
	public View (Environment env){
		super();
		this.env = env;
		cptTicks = this.env.getNbTicks();
		
		this.canvasSizeX = Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeX"));
		this.canvasSizeY = Integer.parseInt(PropertiesReader.getInstance().getProperties("canvasSizeY"));
		this.boxSize = Integer.parseInt(PropertiesReader.getInstance().getProperties("boxSize"));
		
		this.setSize(canvasSizeX,canvasSizeY);
        this.setPreferredSize(new Dimension(canvasSizeX,canvasSizeY));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i<Environment.getTailleX(); i++){
			for(int j = 0; j<Environment.getTailleY(); j++){
				if(Environment.getTab()[i][j] != null){
					g.setColor(getColor(Environment.getTab()[i][j]));
					g.fillRect(j * boxSize, i * boxSize, boxSize, boxSize);
				} else {
					if(PropertiesReader.getInstance().getProperties("grid").equals("true")) {
						g.setColor(Color.GRAY);
						g.drawRect(j * boxSize, i * boxSize, boxSize - 1, boxSize - 1);
					}
				}
			}
		}
	}
	
	public Color getColor(Agent agent){
		if(agent.getColor().equals(MyColor.Jaune)){
			return Color.YELLOW;
		} else if(agent.getColor().equals(MyColor.Rouge)){
			return Color.RED;
		} else if(agent.getColor().equals(MyColor.Bleu)){
			return Color.BLUE;
		} else if(agent.getColor().equals(MyColor.Vert)){
			return Color.GREEN;
		} else if(agent.getColor().equals(MyColor.Rose)) {
			return Color.PINK;
		} else {
			return null;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(cptTicks % Integer.parseInt(PropertiesReader.getInstance().getProperties("refresh")) == 0)
			repaint();

		cptTicks --;
	}

}
