public class EnterClass {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new int [] {2, 2}, new int[] {6, 5});
        Vector vector2 = new Vector(new int [] {2, 2}, new int[] {6, 5});

        System.out.println("Vector length: " + vector1.detVectorLength());

        Vector sumVector = Vector.operationsWithVectors(vector1, vector2, Operation.SUM);
        System.out.println("Vector length: " + sumVector.detVectorLength());

        Vector diffVector = Vector.operationsWithVectors(vector1, vector2, Operation.DIFF);
        System.out.println("Vector length: " + diffVector.detVectorLength());
    }
}
