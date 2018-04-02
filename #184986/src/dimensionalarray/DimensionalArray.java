/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensionalarray;

/**
 *
 * @author syed0023
 */
public class DimensionalArray {

	public static void OutputArray(int[][] array) {

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = 0;
				if (col == array[row].length - 1) {
					System.out.print("sales["+ row + "][" + col + "]");
				}else
					System.out.print("sales["+ row + "][" + col + "],");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		
		int[][] arr = new int[3][5];
		DimensionalArray.OutputArray(arr);
	}

}
