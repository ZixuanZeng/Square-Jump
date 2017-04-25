import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface ScoringSystem {
	
	final int winningScore = 1000;
	int initialScore = 0;
	
	void scoringMechanics();
	boolean isWin();
	void receiveDamaged();
	void awardPoints();
	void drawScore();
}
