import javafx.scene.paint.Color;

public class Square extends Shape implements Movable{
	private int StartTime;
	private int Time;
	private int initXPos;
	private int initYPos;
	private boolean isFalling;

	public Square(int xPos, int yPos, int time) {
		Height = 20;
		Width = 20;
		initXPos = XPos = xPos;
		initYPos = YPos = yPos;
		color = Color.BLUE;
		StartTime = Time = time;
	}
	
	@Override
	public int getXPos() {
		return XPos;
	}

	@Override
	public int getYPos() {
		return YPos;
	}

	@Override
	public int getWidth() {
		return Width;
	}

	@Override
	public int getHeight() {
		return Height;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void moveLeft() {
		XPos-= 10;
	}

	@Override
	public void moveRight() {
		XPos+= 10;
	}

	@Override
	public void moveByGravity() {
		int deltaTime = Time-StartTime;
		YPos = initYPos - (JumpDistance*JumpDistance - 
				(deltaTime-JumpDistance)*(deltaTime-JumpDistance))/Speed;
		//System.out.println("pos: " + YPos + "time" + deltaTime);
		if(deltaTime > JumpDistance) isFalling = true;
	}

	@Override
	public void setTime(int time) {
		Time = time;
		this.moveByGravity();
	}

	@Override
	public void setStartTime(int time) {
		StartTime = time;
		initXPos = XPos;
		initYPos = YPos;
	}

	@Override
	public int getNumOfPoints() {
		// TODO Auto-generated method stub
		return 0;
	}
}
