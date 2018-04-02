import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class OurQuickSortParallelized extends TestCase {

    private void parallelQuickSort(float[] numbers) {
        new ForkJoinPool().invoke(new SortAction(numbers, 0, numbers.length - 1));
    }

    private class SortAction extends RecursiveAction {
        private static final int THRESHOLD = 1000;

        private float[] array;
        private int begin, end;

        private SortAction(float[] array, int begin, int end) {
            this.array = array;
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (begin < end) {
                int pivot = OurQuickSort.partition(array, begin, end);
                if (end - begin < THRESHOLD) {
                    OurQuickSort.quicksort(array, begin, pivot - 1);
                    OurQuickSort.quicksort(array, pivot + 1, end);

                } else {
                    invokeAll(
                            new SortAction(array, begin, pivot - 1),
                            new SortAction(array, pivot + 1, end));
                }
            }
        }
    }

    public OurQuickSortParallelized(int problemSize) {
        float[] numbers = getRandomNumbers(problemSize);

        StopWatch stopWatch = new StopWatch();

        parallelQuickSort(numbers);

        System.out.println(getClass().getName() + ": " +  stopWatch);

        verifyIfSorted(numbers);
    }
}