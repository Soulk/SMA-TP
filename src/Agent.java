import java.util.Random;

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
	
	
	public void update(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	public void decide() {
		Random r = new Random();
		int rand = r.nextInt(7)+1;
		switch (rand) {
		case 1:
			actD();
			break;
		case 2:
			actDB();
			break;
		case 3:
			actB();
			break;
		case 4:
			actBG();
			break;
		case 5:
			actG();
			break;
		case 6:
			actGH();
			break;
		case 7:
			actH();
			break;
		case 8:
			actHD();
			break;	
		default:
			break;
		}
	}
	
	private Agent getElementOn(int posX, int posY) {
		Agent[][] tab = env.getEnv2d();
		return tab[posX][posY];
	}
	private boolean isBound(int posX, int posY) {
		if(env.getTailleX() == posX || env.getTailleY() ==posY)return true;
		return false;
	}
	private void permuter(int posX, int posY) {
		int tmpX = this.posX;
		int tmpY = this.posY;
		update(posX, posY);
		env.getEnv2d()[tmpX][tmpY] = this;
	}
	public void actD() {
		if(isBound(posX+1, posY)) {
			Agent tmp = getElementOn(0, posY);
			if(tmp == null) {
				update(0, posY);
			} else {
				tmp.permuter(this.posX, this.posY);
				update(0, posY);
				env.getEnv2d()[0][posY] = this;
			}
		}
		Agent a = getElementOn(posX+1, posY);
		if(a == null) {
			Agent tmp = getElementOn(0, posY);
		}
	}
	public void actDB() {
		
	}
	
	public void actB() {
		
	}
	public void actBG() {
		
	}
	
	public void actG() {
		
	}
	public void actGH() {
		
	}
	public void actH() {
		
	}
	public void actHD() {
		
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
