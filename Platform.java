import javafx.scene.paint.Color;

public class Platform extends Shape{
	
	public Platform(int xPos, int yPos) {
		Height = 15;
		Width = 50;
		XPos = xPos;
		YPos = yPos;
		color = Color.GREEN;
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
}
