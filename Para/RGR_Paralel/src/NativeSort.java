
import java.util.Arrays;

public class NativeSort extends TestCase {

    public NativeSort(int problemSize) {
        float[] numbers = getRandomNumbers(problemSize);

        StopWatch stopWatch = new StopWatch();

        Arrays.sort(numbers);

        System.out.println(getClass().getName() + ": " + stopWatch);

        verifyIfSorted(numbers);
    }
}