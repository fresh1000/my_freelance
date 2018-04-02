
public class GradedActivity {
	private double score;
	private double weight;
	
	public GradedActivity(double score, double weight) {
		this.score = score;
		this.weight = weight;
	}

	public GradedActivity(double weight) {
		this.score = 0;
		this.weight = weight;
	}

	public double getScore() {
		return score;
	}

	public double getWeight() {
		return weight;
	}

	public void setScore(double score) {
		if (score <= 100 && score >= 0) {
			this.score = score;
		}else
			throw new IllegalArgumentException("Score must be in range 0-100(inclusive)");
	}

	public void setWeight(double weight) {
		if (weight < 1 && weight > 0) {
			this.weight = weight;
		}else
			throw new IllegalArgumentException("weight must be in range 0-1(exclusive)");
	}
	
	public char getGrade() {
		char grade = 'F';
		
		if (this.score >= 60 && this.score <= 69) {
			grade = 'D';
		} else if (this.score >= 70 && this.score <= 79) {
			grade = 'C';
		} else if (this.score >= 80 && this.score <= 89) {
			grade = 'B';
		} else if (this.score >= 90 && this.score <= 100) {
			grade = 'A';
		}
		
		return grade;
	}

	public String toString() {
		return "Score: " + score + ", Weight: " + weight + ", Grade: " + getGrade();
	}
	
	
}
