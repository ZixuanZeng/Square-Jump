import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface ScoringSystem {
	
	final int winningScore = 10000;
	int initialScore = 0;
	
	void scoringMechanics();
	boolean isWin();
	void receiveDamaged();
	void awardPoints();
	int getScore();
	public void addDistance(int dis);
}
