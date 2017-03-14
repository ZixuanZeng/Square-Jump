import java.awt.Graphics;
public interface ScoringSystem {
	
	final int winningScore = 1000;
	int initialScore = 0;
	
	void scoreBoard(Graphics g);
	void scoringMechanics();
	boolean isWin();
	void receiveDamaged();
	void awardPoints();
}
