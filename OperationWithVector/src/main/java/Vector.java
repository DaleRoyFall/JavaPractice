import java.util.logging.Logger;

public class Vector {
    private double[] vector;

    Vector(double[] vector) {
        this.vector = vector;
    }

    Vector(double[] startPoint, double[] endPoint, VectorType vectorType) {
        if(startPoint.length != endPoint.length) {
            try {
                Logger LOGGER = Logger.getLogger(Vector.class.getName());
                LOGGER.info(("Start point and end point have different length."));
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.vector = detVector(startPoint, endPoint, vectorType);
    }

    private double[] detVector(double[] startPoint, double[] endPoint, VectorType vectorType) {
        double[] vector = new double[startPoint.length];

        for(int i = 0; i < startPoint.length; i++)
            if(vectorType.equals(VectorType.POSITIVE)) {
                vector[i] = endPoint[i] - startPoint[i];
            } else if(vectorType.equals(VectorType.NEGATIVE)) {
                vector[i] = startPoint[i] - endPoint[i];
            }

        return vector;
    }

    public double detVectorLength() {
        double vectorLength = 0;

        for(int i = 0; i < vector.length; i++)
            vectorLength += Math.pow(vector[i] , 2);

        return Math.sqrt(vectorLength);
    }

    public static Vector operationsWithVectors(Vector frstVector, Vector scndVector, Operation operation) {
        if(frstVector.vector.length != scndVector.vector.length) {
            try {
                Logger LOGGER = Logger.getLogger(Vector.class.getName());
                LOGGER.info(("Vectors have different lengths."));
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        double[] currVector = new double[frstVector.vector.length];

        for(int i = 0; i < frstVector.vector.length; i++) {
            if(operation.equals(Operation.SUM)) {
                currVector[i] = frstVector.vector[i] + scndVector.vector[i];
            } else if(operation.equals(Operation.DIFF)) {
                currVector[i] = frstVector.vector[i] - scndVector.vector[i];
            }
        }

        return new Vector(currVector);
    }

    public static double detVectorsMultiplication(Vector frstVector, Vector scndVector) {
        double multiplicationCounter = 0;

        for(int i = 0; i < frstVector.vector.length; i++)
            multiplicationCounter += (frstVector.vector[i] * scndVector.vector[i]);

        return multiplicationCounter;
    }

    public static double detDegreeBetweenVectors(Vector frstVector, Vector scndVector) {
        double vectorsMultiplication = detVectorsMultiplication(frstVector, scndVector);

        double frstVectorLength = frstVector.detVectorLength();
        double scndVectorLength = scndVector.detVectorLength();

        double angleBetweenVectors = vectorsMultiplication / (frstVectorLength * scndVectorLength);

        return Math.toDegrees(Math.acos(angleBetweenVectors));
    }
}
