import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static File file = new File("iris.csv");
    public static Flowerpot setosa;
    public static Flowerpot versicolor;
    public static Flowerpot virginica;
    public static ArrayList<Flower> test;

    public static void main(String[] args) throws FileNotFoundException {
        double average = 0;
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(file);
            String s = scanner.nextLine();
            setosa = new Flowerpot();
            versicolor = new Flowerpot();
            virginica = new Flowerpot();
            test = new ArrayList<Flower>();
            input(setosa, scanner);
            input(versicolor, scanner);
            input(virginica, scanner);
            double ans = 0;
            for (Flower f : test)
                if (f.species.equals(detectKind(f)))
                    ans++;
            average += (ans / 30 * 100);
        }
        System.out.println(average / 5);
    }

    public static void input(Flowerpot kind, Scanner scanner) throws FileNotFoundException {
        boolean[] inTest = random();
        for (int i = 0; i < 50; i++) {
            String s = scanner.nextLine();
            if (s.length() == 0) {
                i--;
                continue;
            }
            StringTokenizer st = new StringTokenizer(s, ",");
            double[] data = new double[4];
            for (int j = 0; j < 4 && st.hasMoreTokens(); j++)
                data[j] = Double.parseDouble(st.nextToken());
            Flower flower = new Flower(data[0], data[1], data[2], data[3], st.nextToken());
            if (inTest[i])
                test.add(flower);
            else
                kind.addFlower(flower);
        }
    }

    public static boolean[] random() {
        boolean[] mark = new boolean[50];
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int r = rand.nextInt() % 50;
            if (r < 0)
                r *= -1;
            if (!mark[r])
                mark[r] = true;
            else
                i--;
        }
        return mark;
    }

    public static double function(double data, double avr, double var) {
        return (1 / Math.sqrt(2 * Math.PI * var)) * Math.exp(-Math.pow(data - avr, 2) / (2 * var));
    }

    public static double probability(Flowerpot kind, Flower data) {
        double p1 = function(data.sepalLength, kind.getSepalLengthAverage(), kind.getSepalLengthVariance());
        double p2 = function(data.sepalWidth, kind.getSepalWidthAverage(), kind.getSepalWidthVariance());
        double p3 = function(data.petalLength, kind.getPetalLengthAverage(), kind.getPetalLengthVariance());
        double p4 = function(data.petalWidth, kind.getPetalWidthAverage(), kind.getPetalWidthVariance());
        return p1 * p2 * p3 * p4;
    }

    public static String detectKind(Flower data) {
        double psetosa = probability(setosa, data);
        double pversicolor = probability(versicolor, data);
        double pvirginica = probability(virginica, data);
        if (psetosa > pversicolor) {
            if (psetosa > pvirginica)
                return "setosa";
            else
                return "virginica";
        } else if (pversicolor > pvirginica)
            return "versicolor";
        else
            return "virginica";
    }
}