import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

public class Vector {

    private int[] startPoint;
    private int[] endPoint;

    Vector(int[] startPoint, int[] endPoint) {
        if(startPoint.length != endPoint.length) {
            System.out.println("Start point and end point have different length.");
            System.exit(1);
        }

        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public double detVectorLength() {
        int vectorLength = 0;

        for(int i = 0; i < startPoint.length; i++)
            vectorLength = (endPoint[i] - startPoint[i])^2;

        return Math.sqrt(vectorLength);
    }

    public static Vector operationsWithVectors(Vector frstVector, Vector scndVector, Operation operation) {
        if(frstVector.startPoint.length != scndVector.startPoint.length
                || frstVector.endPoint.length != scndVector.endPoint.length) {
            System.out.println("Vectors have different lengths.");
            System.exit(1);
        }

        int[] currStartPoint = new int[frstVector.startPoint.length];
        int[] currEndPoint = new int[frstVector.endPoint.length];

        for(int i = 0; i < frstVector.startPoint.length; i++) {
            if(operation.equals(Operation.SUM)) {
                currStartPoint[i] = frstVector.startPoint[i] + scndVector.startPoint[i];
                currEndPoint[i] = frstVector.endPoint[i] + scndVector.endPoint[i];
            } else if(operation.equals(Operation.DIFF)) {
                currStartPoint[i] = frstVector.startPoint[i] - scndVector.startPoint[i];
                currEndPoint[i] = frstVector.endPoint[i] - scndVector.endPoint[i];
            }
        }

        return new Vector(currStartPoint, currEndPoint);
    }
}
