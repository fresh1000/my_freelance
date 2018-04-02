import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int[] serial = new Random().ints(100_000_000).toArray();
        int[] parallel = Arrays.copyOf(serial, serial.length);
        
        MergeSort mergeSort = new MergeSort();
        long start = System.currentTimeMillis();
        mergeSort.sort(serial, 0, serial.length - 1);
        System.out.println("Merge Sort done in: "
                + (System.currentTimeMillis()-start));
 
        ParallelMergeSort sorter = new ParallelMergeSort(parallel);
        start = System.currentTimeMillis();
        sorter.sort();
        System.out.println("Parallel Merge Sort done in: "
                + (System.currentTimeMillis()-start));

	}

}
