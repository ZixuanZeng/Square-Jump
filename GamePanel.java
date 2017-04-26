import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel {
	private List<Shape> Elements = new ArrayList<Shape>();
	private List<Integer> UsedRows, UsedRows2;
	private ScoringSystem Score;
	private int Time;
	private Square s;
	private Collision collision;
	private boolean isGameOver;
	
	public GamePanel(int width, int height) {
		Time = 0;
		Random rand = new Random();
		Random rand2 = new Random();
		UsedRows = new ArrayList<Integer>(height/20);
		UsedRows2 = new ArrayList<Integer>(height/30);
		for(int i = 0; i < 10000; i++) {
			UsedRows.add(0); // set to unused
			if(i%3 == 0) {
				Platform p = new Platform(rand.nextInt(width-50), i*20 - 100000);
				Elements.add(p);
				UsedRows.set(i, 1);
			}
		}
		for(int j = 0; j < 10000; j++){
			UsedRows2.add(0);
			if(j % 4 ==0){
				Monster m = new Monster(rand2.nextInt(width-50), j*40 - 100000);
				Elements.add(m);
				UsedRows2.set(j, 1);
			}
		}
		Platform p = new Platform(width/2, height - 20);
		s = new Square(width/2, height-20, Time);
		Elements.add(s);
		Elements.add(p);
		collision = new CollisionEvent(Elements);
		Score = new ScoreBoard();
		isGameOver = false;
	}
	
	public void setTime(int time) {
		Time = time;
		for(Shape shape : Elements) {
			if(shape instanceof Square) {
				Square square = (Square)shape;
				if(collision.checkCollision()) square.setStartTime(time);
				if(collision.checkGameOver()) isGameOver = true;
				square.setTime(Time);
			}
			else {
				if(s.getBackgroundMove() > 0) {
					shape.backgroundMove(s.getBackgroundMove());
					Score.addDistance(s.getBackgroundMove());
				}
			}
		}
	}
	
	public List<Shape> getElements() {
		return Elements;
	}
	
	public Square getSquare(){
		return s;
	}
	
    public ScoringSystem getScore() {
    	return Score;
    }
    
    public boolean checkGameOver() {
    	return isGameOver;
    }
}
