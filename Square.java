import java.util.Random;
public class Square {
    public static class Dot {
        double X;
        double Y;

        public Dot(double x, double y) {
            this.X = x;
            this.Y = y;
        }

        public Dot() {
            Random rand = new Random();
            X = rand.nextDouble() * 10;
            Y = rand.nextDouble() * 10;
        }
    }

    private Dot A, B, C, D;
    public double P;

    public Square() {
        createSquare();
        if (!isValidSquare()){
            createSquare();
        }
        P = getPerimeter();
    }

    public void createSquare() {
        A = new Dot();
        B = new Dot();
        double sideLength = sideLength(A, B);
        C = new Dot(B.X + sideLength, B.Y);
        D = new Dot(A.X + sideLength, A.Y);
    }

    public boolean isValidSquare() {
        double AB = sideLength(A, B);
        double BC = sideLength(B, C);
        double CD = sideLength(C, D);
        double AD = sideLength(A, D);
        double d1 = sideLength(A, C);
        double d2 = sideLength(B, D);

        return (AB == BC && BC == CD && CD == AD && d1 != d2);
    }

    private double sideLength(Dot start, Dot end) {
        return Math.sqrt(Math.pow((start.X - end.X), 2) + Math.pow((start.Y - end.Y), 2));
    }

    public double getPerimeter() {
        double sideLength = sideLength(A, B);
        return 4 * sideLength;
    }

    public double getArea() {
        double sideLength = sideLength(A, B);
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return String.format("Координати вершин: (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f)\nПериметр: %.2f\nПлоща: %.2f",
                A.X, A.Y, B.X, B.Y, C.X, C.Y, D.X, D.Y, getPerimeter(), getArea());
    }
}