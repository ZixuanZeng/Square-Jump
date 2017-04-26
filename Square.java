import javafx.scene.paint.Color;

public class Square extends Shape implements Movable{
	private int StartTime;
	private int Time;
	private int initXPos;
	private int initYPos;
	private int bgMove;
	private int predictedYPos;
	private int prevPredictedYPos;
	private boolean resetInitYPos;

	public Square(int xPos, int yPos, int time) {
		Height = 20;
		Width = 20;
		initXPos = XPos = xPos;
		initYPos = YPos = yPos;
		color = Color.BLUE;
		StartTime = Time = time;
		predictedYPos = GameBackground.Height/2;
		prevPredictedYPos = GameBackground.Height/2;
		resetInitYPos = false;
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
		if(XPos < 0) {
			XPos = GameBackground.Width-10;
		}
	}

	@Override
	public void moveRight() {
		XPos+= 10;
		if(XPos > GameBackground.Width) {
			XPos = 0;
		}
	}

	@Override
	public void moveByGravity() {
		int deltaTime = Time-StartTime;
		YPos = initYPos - (JumpDistance*JumpDistance - 
				(deltaTime-JumpDistance)*(deltaTime-JumpDistance))/Speed;
		//System.out.println("pos: " + YPos + "time" + deltaTime);
		if(YPos <= GameBackground.Height/2) {
			if(deltaTime < JumpDistance) {
				predictedYPos = YPos;
				YPos = GameBackground.Height/2;
				bgMove = prevPredictedYPos - predictedYPos;
				prevPredictedYPos = predictedYPos;
				resetInitYPos = true;
			}
			else if(resetInitYPos){
				YPos = GameBackground.Height/2;
				initYPos = initYPos + (GameBackground.Height/2 - predictedYPos);
				resetInitYPos = false;
				bgMove = 0;
			}
		}
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

	@Override
	public void backgroundMove(int length) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public int getBackgroundMove() {
		// TODO Auto-generated method stub
		return bgMove;
	}
}
