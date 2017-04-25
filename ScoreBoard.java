import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ScoreBoard implements ScoringSystem{
	
	private int Score;
	
	public ScoreBoard(){
		
	}

	@Override
	public void scoringMechanics() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receiveDamaged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int awardPoints() {
		// TODO Auto-generated method stub
		Score += 1000000;
		return Score;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return Score/1000;
	}

	@Override
	public void addDistance(int d) {
		// TODO Auto-generated method stub
		Score += d;
	}

}
