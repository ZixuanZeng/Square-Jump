import java.util.List;

public class CollisionEvent implements Collision{
	private List<Shape> Elements;
	private int XPos;
	private int YPos;
	private int PrevYPos;
	private Square square;
	private boolean isGameOver;
	
	public CollisionEvent(List<Shape> elements) {
		Elements = elements;
		for(Shape s : Elements) {
			if(s instanceof Square) {
				square = (Square)s;
			}
		}
		PrevYPos = GameBackground.Height - square.getHeight();
	}
	
	@Override
	public boolean checkCollision() {
		YPos = square.getYPos();
		XPos = square.getXPos();
		for(Shape s : Elements) {
			if(s instanceof Platform) {
				if(XPos > s.getXPos()-square.getWidth() && XPos < s.getXPos() + s.getWidth() 
						&& YPos >= s.getYPos() - square.getHeight() 
						&& PrevYPos < s.getYPos() - square.getHeight()) {
					PrevYPos = GameBackground.Height - square.getHeight();
					return true;
				}
			}
			else if(s instanceof Monster){
				if(XPos > s.getXPos()-square.getWidth() && XPos < s.getXPos() + s.getWidth() 
						&& YPos >= s.getYPos() - square.getHeight() 
						&& PrevYPos < s.getYPos() - square.getHeight()){
					PrevYPos = GameBackground.Height - square.getHeight();
					Monster m = (Monster)s;
					m.kill();
					return true;
				}
				else if(XPos > s.getXPos()-square.getWidth() && XPos < s.getXPos() + s.getWidth() 
						&& YPos <= s.getYPos() + s.getHeight() 
						&& PrevYPos > s.getYPos() + s.getHeight()){
					PrevYPos = GameBackground.Height - square.getHeight();
					isGameOver = true;
					return true;
				}
			}
		}
		PrevYPos = YPos;
		return false;
	}
	
	@Override
	public boolean checkGameOver(){
		if(YPos > GameBackground.Height)
			isGameOver =  true;
		return isGameOver;
	}
}