import javafx.scene.paint.Color;

public class Monster extends Shape{
	
	public Monster(int xPos, int yPos) {
		Height = 20;
		Width = 20;
		XPos = xPos;
		YPos = yPos;
		color = Color.RED;
		
	}
	
	public void kill() {
		XPos = 1000;
	}

	@Override
	public int getXPos() {
		// TODO Auto-generated method stub
		return XPos;
	}

	@Override
	public int getYPos() {
		// TODO Auto-generated method stub
		return YPos;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Height;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public int getNumOfPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}

