
public class Agent {
	private int posX,posY;
	private Colour color;
	private enum Colour {
		  Jaune,
		  Rouge,
		  Bleu,
		  Vert;	
		}
	private Environment env;
	public Agent(Environment env,int posX,int posY, Colour color) {
		this.env=env;
		this.color = color;
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	
	public void update(int posX, int posY, Colour color) {
		this.color = color;
		this.posX = posX;
		this.posY = posY;
	}
	public void decide() {
		
		
	}
	

	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
}
