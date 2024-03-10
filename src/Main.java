import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    /*private static final List<Flower> testFlowers = new ArrayList<>();
    private static final List<Flower> trainFlowers = new ArrayList<>();*/
    private static List<Distance> distances = new ArrayList<>();
    private static int counter = 0;

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.welcomeInfo();
        menu.chooseMode();
        int k = menu.getKValue();

        if(menu.getMode() == 1){
            // logika dla plikow
            FileReader fileReader = new FileReader();
            for (Flower currentXFlower : fileReader.getTestFlowers()) {
                String actualName = currentXFlower.getName();
                for (Flower currentPointFlower : fileReader.getTrainFlowers()) {
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
                System.out.println("--------");
                finalList.forEach(System.out::println);
                System.out.println("--------");
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
                        break;
                    }

                }
                distances = new ArrayList<>();
            }
            System.out.println("SKUTECZNOŚĆ: " + (double)counter/fileReader.getTestFlowers().size() * 100 + "%");
        }else {
            //logika dla podanych przez uzytkownika danych

        }

    }
}