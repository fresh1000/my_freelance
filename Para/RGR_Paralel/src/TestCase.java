import java.util.Random;

public class TestCase {

    protected float[] getRandomNumbers(int howMany) {
        float[] numbers = new float[howMany];

        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextFloat();
        }

        return numbers;
    }

    protected void verifyIfSorted(float[] array) {
        boolean sorted = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                sorted = false;
                break;
            }
        }

        System.out.println("Array is sorted " + (sorted ? "correctly" : "incorrectly"));
    }
}