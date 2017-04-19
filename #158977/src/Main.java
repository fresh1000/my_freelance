import java.util.Scanner;

public class Main {
	//function return string type triangle 
	public static String classifyTriangle(int a, int b,int c) {
		if((a + b < c || b + c < a || a + c < b) ||
				a == 0 || b == 0 || c == 0) {
			return "Not triangle"; 
		}else
			if(a == b && c == a) {//if a = b = c ,triangle is  Equilateral
				return "Equilateral";
			}

			if((a == Math.sqrt(b * b + c * c))
					|| (b == Math.sqrt(a * a + c * c))
					||(c == Math.sqrt(b * b + a * a))) { //Pythagor theorem,if a^2 = b^2 + c^2 triangle is Rectangular 
				return "Rectangular";
			}
			
			if((a == b) || (a == c) || (b == c)) {// if triangle is isosceles
				
				if((a > Math.sqrt(b * b + c * c))
						||(b > Math.sqrt(a * a + c * c))
						||(c > Math.sqrt(b * b + a * a))) {// if a^2 > b^2 + c^2 triangle is Obtuse Isosceles  
					return "Obtuse Isosceles";
				}
				else                               				  //else Acute Isosceles
					return "Acute Isosceles";
			}
		return "Scalene";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c;	//variables for write console information
		System.out.println("Enter side a:");
		a = sc.nextInt();//read side a
		System.out.println("Enter side b:");
		b = sc.nextInt();//read side b
		System.out.println("Enter side c:");
		c = sc.nextInt();//read side c
		System.out.println("Triangle type: " + classifyTriangle(a, b, c));//call method classifyTriangle and write result
	}

}
