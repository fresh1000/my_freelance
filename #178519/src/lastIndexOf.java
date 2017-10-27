
import java.util.*;
//class lastIndexOf
public class lastIndexOf

{
	// main function
	public static void main(String[] args) {

		int a[] = { 27, 15, 15, 11, 27 };// initialize array a with size 5

		int b[] = { 27, 15, 15, 11, 27, 15 };// initialize array b with size 6

		int c[] = { 27, 15, 11, 15, 11, 27 };// initialize array c with size 5

		System.out.println("The mode of a is " + mode(a));// print mode in array a

		System.out.println("The mode of b is " + mode(b));// print mode in array b

		System.out.println("The mode of c is " + mode(c));// print mode in array c

	}

	public static int mode(int[] array) {

		int[] spareArray = new int[101];// initialize dynamic array spareArray with size 101
		// for loop from 0 to array length
		for (int i = 0; i < array.length; i++) {
			// all elements in array must be in the range from 0 to 100
			spareArray[array[i]]++;// get element array[i] in spareArray and add 1 to element

		}

		int mode = 101;// initialize mode to max number

		int count = 0;// initialize count to 0
		// for loop from 0 to spareArray length
		for (int i = 0; i < spareArray.length; i++) {
			// if spareArray[i] greater then count
			if (spareArray[i] > count) {

				count = spareArray[i];// count set to spareArray[i]

				mode = i;// mode set to index in spareArray, index in spareArray - value element in array

			}

		}

		return mode;// return mode in array

	}

}