import java.util.Random;

public class Agent {
	
	private int posX,posY;
	private int posXTmp, posYTmp;
	private MyColor color;
	private String direction;
	
	public Agent(int posX,int posY, MyColor color, String direction) {
		this.color = color;
		this.setPosX(posX);
		this.setPosY(posY);
		this.direction = initializeDirection();
	}
		
	public String initializeDirection(){
		Random r = new Random();
		int nbDir = r.nextInt(Direction.dir.length);
		return Direction.dir[nbDir];
	}
	
	public void updateTmp(int posXTmp, int posYTmp) {
		this.posXTmp = posXTmp;
		this.posYTmp = posYTmp;
	}
	
	public void update(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void decide(){
		findNewPosition();
		makeAction();
	}
	
	public MyColor getColor() {
		return color;
	}

	public void setColor(MyColor color) {
		this.color = color;
	}

	public void findNewPosition(){
		switch(this.direction){
		case "N":
			posXTmp = posX;
			posYTmp = posY + 1;
			break;
		case "S":
			posXTmp = posX;
			posYTmp = posY - 1;
			break;
		case "W":
			posXTmp = posX - 1;
			posYTmp = posY;
			break;
		case "E":
			posXTmp = posX + 1;
			posYTmp = posY;
			break;
		case "NW":
			posXTmp = posX - 1;
			posYTmp = posY + 1;
			break;
		case "NE":
			posXTmp = posX + 1;
			posYTmp = posY + 1;
			break;
		case "SW":
			posXTmp = posX - 1;
			posYTmp = posY + 1;
			break;
		case "SE":
			posXTmp = posX + 1 ;
			posYTmp = posY + 1;
			break;
		}
	}

	public void makeAction(){
		// Outside the map
		if(posXTmp >= Environment.getTailleX()){
			posXTmp = 0;
		}
		if(posXTmp == -1){
			posXTmp = Environment.getTailleX() - 1;
		}
		if(posYTmp >= Environment.getTailleY()){
			posYTmp = 0;
		}
		if(posYTmp == -1){
			posYTmp = Environment.getTailleY() - 1;
		}
		
		// On an existent Agent
		if(Environment.getTab()[posXTmp][posYTmp] != null){
			Agent swapAgent = Environment.getTab()[posXTmp][posYTmp];
			swapAgent(swapAgent);
			findNewPosition();
		}
		
		posX = posXTmp;
		posY = posYTmp;
	}
	
	public void swapAgent(Agent swapAgent){
		String myDirection = this.direction;
		String hisDirection = swapAgent.direction;
		
		swapAgent.direction = myDirection;
		this.direction = hisDirection;
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
