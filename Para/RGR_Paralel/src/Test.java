
public class Test {
	private static final int PROBLEM_SIZE = 20000000;

    public static void main(String[] args) {
        new NativeSort(PROBLEM_SIZE);
        new OurQuickSort(PROBLEM_SIZE);
        new OurQuickSortParallelized(PROBLEM_SIZE);
    }
}
