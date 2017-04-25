public class ScoreBoard implements ScoringSystem{
	private int Score;

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
	public void awardPoints() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addDistance(int dis) {
		Score += dis;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return Score/1000;
	}

}
