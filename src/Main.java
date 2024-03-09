import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static final List<Flower> testFlowers = new ArrayList<>();
    private static final List<Flower> trainFlowers = new ArrayList<>();
    private static List<Distance> distances = new ArrayList<>();
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Witaj mpp1, podaj liczbe k: [k musi byc intem]");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println(k);

        //reading files
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

        for (Flower currentXFlower : testFlowers) {
            String actualName = currentXFlower.getName();
            for (Flower currentPointFlower : trainFlowers) {
                double distance = Math.sqrt(
                        Math.pow(currentPointFlower.getA() - currentXFlower.getA(), 2) +
                                Math.pow(currentPointFlower.getB() - currentXFlower.getB(), 2) +
                                Math.pow(currentPointFlower.getC() - currentXFlower.getC(), 2) +
                                Math.pow(currentPointFlower.getD() - currentXFlower.getD(), 2)
                );
                Distance myDistance = new Distance(distance, currentXFlower, currentPointFlower);
                distances.add(myDistance);
            }

            List<Distance> finalList = distances.stream()
                    .sorted(Distance::compareTo)
                    .limit(k)
                    .toList();

            Map<String, Integer> counterMap = new HashMap<>();

            for(Distance distance : finalList){
                String pointName = distance.getPoint().getName();
                counterMap.put(pointName, counterMap.getOrDefault(pointName, 0) + 1);
            }
            String resultDistance;
            int max = Collections.max(counterMap.values());
            for(Map.Entry<String, Integer> entry : counterMap.entrySet()){
                if(entry.getValue() == max){
                  resultDistance = entry.getKey();
                    System.out.println("resultDistance: " + resultDistance + " "  + entry.getValue());
                    if(resultDistance.equals(actualName)){
                        counter++;
                        System.out.println("zgoda");
                    }else{
                        System.out.println("niezgoda");
                    }
                }
            }
            distances = new ArrayList<>();
        }
        System.out.println("SKUTECZNOŚĆ: " + (double)counter/testFlowers.size() * 100 + "%");
    }

    private static void xyz(Scanner testScanner, List<Flower> list) {
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

}