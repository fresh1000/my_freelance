import java.util.Scanner;
import edu.princeton.cs.algs4.*;

public class Percolation {

	public Percolation (int n) {
		if(n <= 0)
			throw new IllegalArgumentException();
	}
	public void open (int i, int j) {
		if(i > n || j > n || i < 1 || j < 1)
			throw new IndexOutOfBoundsException();
	}
	public boolean isOpen (int i, int j) {
		if(i > n || j > n)
			throw new IndexOutOfBoundsException();
	}
	public boolean isFull (int i, int j) {
		if(i > n || j > n)
			throw new IndexOutOfBoundsException();
	}
	public boolean percolation () {}
	
//	public static void main(String[] args) {
//
//		Scanner n = new Scanner(System.in);
//		int N = n.nextInt();
//		UF uf = new UF(N);
//	}

}
