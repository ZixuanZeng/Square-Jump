import javafx.scene.paint.Color;

public abstract class Shape {
	protected int XPos;
	protected int YPos;
	protected int Width;
	protected int Height;
	protected int NumOfPoints;
	protected Color color;

	public abstract int getXPos();
	public abstract int getYPos();
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract int getNumOfPoints();
	public abstract Color getColor();
	public void backgroundMove(int length) {
		YPos += length;
	}
}
