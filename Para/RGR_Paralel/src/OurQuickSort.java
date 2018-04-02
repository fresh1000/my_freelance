
public class OurQuickSort extends TestCase {

    public static void quicksort(float[] array) {
        quicksort(array, 0, array.length - 1);
    }

    static void quicksort(float[] array, int begin, int end) {
        if (begin < end) {
            int pivot = partition(array, begin, end);

            quicksort(array, begin, pivot - 1);
            quicksort(array, pivot + 1, end);
        }
    }

    static int partition(float[] array, int begin, int end) {
        int pivot = begin + (end - begin) / 2;
        float pivotValue = array[pivot];
        int storeIdx = begin;

        swap(array, pivot, end);

        for (int i = begin; i < end; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, storeIdx);
                storeIdx++;
            }
        }

        swap(array, storeIdx, end);

        return storeIdx;
    }

    static void swap(float[] array, int i, int j) {
        float tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public OurQuickSort(int problemSize) {
        float[] numbers = getRandomNumbers(problemSize);

        StopWatch stopWatch = new StopWatch();

        quicksort(numbers);

        System.out.println(getClass().getName() + ": " + stopWatch);

        verifyIfSorted(numbers);
    }
}