import java.util.logging.Logger;

public class EnterClass {
    private static final Logger LOGGER = Logger.getLogger(EnterClass.class.getName());

    public static void main(String[] args) {
        Vector vector1 = new Vector(new double [] {2, 2}, new double[] {6, 5}, VectorType.POSITIVE);
        Vector vector2 = new Vector(new double [] {2, 2}, new double[] {6, 5}, VectorType.NEGATIVE);

        LOGGER.info("Vector length: " + vector1.detVectorLength());

        Vector sumVector = Vector.operationsWithVectors(vector1, vector2, Operation.SUM);
        LOGGER.info("[Summation]Vector length: " + sumVector.detVectorLength());

        Vector diffVector = Vector.operationsWithVectors(vector1, vector2, Operation.DIFF);
        LOGGER.info("[Difference]Vector length: " + diffVector.detVectorLength());

        double multiplicationVector = Vector.detVectorsMultiplication(vector1, vector2);
        LOGGER.info("[Multiplication]: " + multiplicationVector);

        double degree = Vector.detDegreeBetweenVectors(vector1, vector2);
        LOGGER.info("[Degree]: " + degree);
    }
}
