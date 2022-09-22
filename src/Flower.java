import java.util.StringTokenizer;

public class Flower {
    public String species;
    public double sepalLength;
    public double sepalWidth;
    public double petalLength;
    public double petalWidth;

    public Flower(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                '}';
    }
}
