import java.util.ArrayList;

public class Flowerpot {
    public ArrayList<Flower> flowers = new ArrayList<Flower>();

    private double sepalLengthAverage = -1;
    private double sepalLengthVariance = -1;

    private double sepalWidthAverage = -1;
    private double sepalWidthVariance = -1;

    private double petalLengthAverage = -1;
    private double petalLengthVariance = -1;

    private double petalWidthAverage = -1;
    private double petalWidthVariance = -1;

    public double getSepalLengthAverage() {
        if (sepalLengthAverage != -1)
            return sepalLengthAverage;
        sepalLengthAverage = 0;
        for (Flower f : flowers)
            sepalLengthAverage += f.sepalLength;
        sepalLengthAverage /= flowers.size();
        return sepalLengthAverage;
    }

    public double getSepalLengthVariance() {
        if (sepalLengthVariance != -1)
            return sepalLengthVariance;
        sepalLengthVariance = 0;
        for (Flower f : flowers)
            sepalLengthVariance += Math.pow(f.sepalLength, 2);
        sepalLengthVariance /= flowers.size();
        sepalLengthVariance -= Math.pow(getSepalLengthAverage(), 2);
        return sepalLengthVariance;
    }

    public double getSepalWidthAverage() {
        if (sepalWidthAverage != -1)
            return sepalWidthAverage;
        sepalWidthAverage = 0;
        for (Flower f : flowers)
            sepalWidthAverage += f.sepalWidth;
        sepalWidthAverage /= flowers.size();
        return sepalWidthAverage;
    }

    public double getSepalWidthVariance() {
        if (sepalWidthVariance != -1)
            return sepalWidthVariance;
        sepalWidthVariance = 0;
        for (Flower f : flowers)
            sepalWidthVariance += Math.pow(f.sepalWidth, 2);
        sepalWidthVariance /= flowers.size();
        sepalWidthVariance -= Math.pow(getSepalWidthAverage(), 2);
        return sepalWidthVariance;
    }

    public double getPetalLengthAverage() {
        if (petalLengthAverage != -1)
            return petalLengthAverage;
        petalLengthAverage = 0;
        for (Flower f : flowers)
            petalLengthAverage += f.petalLength;
        petalLengthAverage /= flowers.size();
        return petalLengthAverage;
    }

    public double getPetalLengthVariance() {
        if (petalLengthVariance != -1)
            return petalLengthVariance;
        petalLengthVariance = 0;
        for (Flower f : flowers)
            petalLengthVariance += Math.pow(f.petalLength, 2);
        petalLengthVariance /= flowers.size();
        petalLengthVariance -= Math.pow(getPetalLengthAverage(), 2);
        return petalLengthVariance;
    }

    public double getPetalWidthAverage() {
        if (petalWidthAverage != -1)
            return petalWidthAverage;
        petalWidthAverage = 0;
        for (Flower f : flowers)
            petalWidthAverage += f.petalWidth;
        petalWidthAverage /= flowers.size();
        return petalWidthAverage;
    }

    public double getPetalWidthVariance() {
        if (petalWidthVariance != -1)
            return petalWidthVariance;
        petalWidthVariance = 0;
        for (Flower f : flowers)
            petalWidthVariance += Math.pow(f.petalWidth, 2);
        petalWidthVariance /= flowers.size();
        petalWidthVariance -= Math.pow(getPetalWidthAverage(), 2);
        return petalWidthVariance;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }
}