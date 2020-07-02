import java.util.Random;

public class ArrayOperations {
    // Array with numbers
    int[] numberArr;

    // Array with weights of the numbers
    int[] weightArr;

    ArrayOperations(int[] numberArr, int[] weightArr) {
        this.numberArr = numberArr;
        this.weightArr = weightArr;
    }

    private int calcTotalWeight() {
        int totalWeigh = 0;

        for (int weight : weightArr) {
            totalWeigh += weight;
        }

        return totalWeigh;
    }

    Integer getNumber() {
        Random rand = new Random();

        // Get random number
        int randNumber = rand.nextInt(calcTotalWeight()) + 1;

        // Verify intervals
        int intervalNumber = 0;
        for(int i = 0; i < weightArr.length; i++) {
            intervalNumber += weightArr[i];

            if(intervalNumber + weightArr[i] > randNumber) {
                return numberArr[i];
            }

        }

        return null;
    }

}
