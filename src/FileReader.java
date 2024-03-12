import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private final List<Flower> testFlowers = new ArrayList<>();
    private final List<Flower> trainFlowers = new ArrayList<>();

    public FileReader() {
        try(Scanner testScanner = new Scanner(new File("resources/test-set"))){
            xyz(testScanner, testFlowers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(Scanner trainScanner = new Scanner(new File("resources/train-set"))){
            xyz(trainScanner, trainFlowers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void xyz(Scanner testScanner, List<Flower> list) {
        while(testScanner.hasNextLine()){
            String[] lineParts = testScanner.nextLine().split(",");
            Flower flower = new Flower(
                    Double.parseDouble(lineParts[0]),
                    Double.parseDouble(lineParts[1]),
                    Double.parseDouble(lineParts[2]),
                    Double.parseDouble(lineParts[3]),
                    lineParts[4]);
            list.add(flower);
        }
    }

    public List<Flower> getTestFlowers() {
        return testFlowers;
    }

    public List<Flower> getTrainFlowers() {
        return trainFlowers;
    }
}
