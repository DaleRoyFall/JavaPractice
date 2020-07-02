import java.util.logging.Logger;

public class RandomArray {
    private static final Logger LOGGER = Logger.getLogger(RandomArray.class.getName());

    public static void main(String args[]) {
        ArrayOperations arrayOperations = new ArrayOperations(new int[]{1,2,3},new int[] {1,3,4});

        LOGGER.info(arrayOperations.getNumber().toString());
    }
}
