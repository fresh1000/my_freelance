package part2;

public class Student {
	private int score;
	public String name;
	//getter score
	public int getScore() {
		return score;
	}
	//setter score
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return  "Name: " + name + " Score: " + score;
	}

	public void curve(double average) {
		if(this.score < average) {
			this.score += 5;//add 5 to score
		}
	}
}