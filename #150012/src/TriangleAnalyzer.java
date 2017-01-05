
public class TriangleAnalyzer {
	private int length1;//side 1
	private int length2;//side 2
	private int length3;//side 3

	//constructor
	public TriangleAnalyzer(int length1, int length2, int length3) {
		this.length1 = length1;
		this.length2 = length2;
		this.length3 = length3;
	}
	//get side 1
	public int getLength1() {
		return length1;
	}
	//get side 2
	public int getLength2() {
		return length2;
	}
	//get side 3
	public int getLength3() {
		return length3;
	}
	//return type triangle
	public String typeTriangle() {
		if(this.length1 + this.length2 > this.length3 && this.length2 + this.length3 > this.length1 && this.length1 + this.length3 > this.length2) {
			if(this.length1 == this.length2 && this.length3 == this.length1) {//if a = b = c ,triangle is  Equilateral
				return "Equilateral";
			}
			if((this.length1 == this.length2) || (this.length1 == this.length3) || (this.length2 == this.length3)) {// if triangle is isosceles
				
				if((this.length1 * this.length1 > this.length2 * this.length2 + this.length3 * this.length3)
						||(this.length2 * this.length2 > this.length1 * this.length1 + this.length3 * this.length3)
						||(this.length3 * this.length3 > this.length2 * this.length2 + this.length1 * this.length1)) {// if a^2 > b^2 + c^2 triangle is Obtuse Isosceles  
					return "Obtuse Isosceles";
				}
				
				if((this.length1 * this.length1 == this.length2 * this.length2 + this.length3 * this.length3)
						||(this.length2 * this.length2 == this.length1 * this.length1 + this.length3 * this.length3)
						||(this.length3 * this.length3 == this.length2 * this.length2 + this.length1 * this.length1)) {// if a^2 = b^2 + c^2 triangle is Right Isosceles
					return "Right Isosceles";
				}
				else                                           													  //else Acute Isosceles
					return "Acute Isosceles";
			}
			
			if((this.length1 * this.length1 == this.length2 * this.length2 + this.length3 * this.length3)
					||(this.length2 * this.length2 == this.length1 * this.length1 + this.length3 * this.length3)
					||(this.length3 * this.length3 == this.length2 * this.length2 + this.length1 * this.length1)) { //Pythagor theorem,if a^2 = b^2 + c^2 triangle is Rectangular 
				return "Rectangular";
			}
		}else
			return "Not triangle";
		return "Scalene";//return if triangle is Scalene
	}
	//return area triangle
	public double areaTriangle() {
		double s = (this.length1 + this.length2 + this.length3) * 0.5;//perimetr div 2 
		double area = Math.sqrt((double)(s * (s - this.length1) * (s - this.length2) * (s - this.length3)));//formula Gerona
		return area;
	}
	
}
