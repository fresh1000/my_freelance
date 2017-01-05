
public class Array {
	
	static <T extends Comparable<T>> void  statistics(T[] a) {
		//print
		System.out.print("List: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("Count: " + a.length);
		
		//average
		double sum = 0;
		double average = 0;
	    for (int i = 0; i < a.length; i++) {
	    		sum = add(sum, a[i]);
	    }
	    average = sum / a.length;
		System.out.println("Average: " + average);
		
		//max element
		int max = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[max].compareTo(a[i]) < 0) {
				max = i;
			}
		}
		System.out.println("Max: " + a[max]);
		
		//min elem
		int min = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[min].compareTo(a[i]) > 0) {
				min = i;
			}
		}
		System.out.println("Min: " + a[min]);
	}
	
	static <T extends Comparable<T>> int search(T[] a, T value) {
		int index = -1;
		for(int i = 0; i < a.length; i++) {
			if(a[i].compareTo(value) == 0) {
				index = i;
			}
		}
		return index;
	}
	

	static <T> double add(T a, T b){

	    if (a instanceof Number && b instanceof Number) {
	        return ((Number) a).doubleValue() + ((Number) b).doubleValue();
	    }
		return 0;
	}
	
	
	public static <T> void main(String[] args) {
		Integer [] i1 = {12, 32, 123, 1245,122};
		Integer i2 = 32;
		System.out.println("Integer");
		statistics(i1);
		System.out.println("Value: " + i2);
		System.out.println("Index: " + search(i1, i2));
		System.out.println();
		
		Double [] d1 = {12.2, 123.1, 34.0, 312.3, 5.6, 153.2};
		Double d2 = 12.2;
		System.out.println("Double");
		statistics(d1);
		System.out.println("Value: " + d2);
		System.out.println("Index: " + search(d1, d2));
		System.out.println();
		
		Long[] l1 = {0l,174251L, 698027L, 2794155L, 11180715L, 123123L};
		Long l2 = 2794155L;
		System.out.println("Long");
		statistics(l1);
		System.out.println("Value: " + l2);
		System.out.println("Index: " + search(l1, l2));
		System.out.println();
		
		Short [] s1 = {12,23,32,1212,323,3323,323};
		Short s2 = 32;
		System.out.println("Short");
		statistics(s1);
		System.out.println("Value: " + s2);
		System.out.println("Index: " + search(s1, s2));
		System.out.println();
		
		Byte [] b1 = {12, 32, 57, 124, 32, 2, 34, 56};
		Byte b2 = 0;
		System.out.println("Byte");
		statistics(b1);
		System.out.println("Value: " + b2);
		System.out.println("Index: " + search(b1, b2));
		System.out.println();
		
		Float[] f1 = {0.32f,1.7251f, 279.4155f, 579.4155f, 111.80715f, 123.123f};
		Float f2 = 279.4155f;
		System.out.println("Float");
		statistics(f1);
		System.out.println("Value: " + f2);
		System.out.println("Index: " + search(f1, f2));
		System.out.println();
	}

}
