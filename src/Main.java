import java.util.*;

public class Main {
    private static List<Distance> distances = new ArrayList<>();
    private static int counter = 0;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.welcomeInfo();
        menu.chooseMode();
        int k = menu.getKValue();
        FileReader fileReader = new FileReader();
        if(menu.getMode() == 1){
            for (Flower currentXFlower : fileReader.getTestFlowers()) {
                myMethod(k, fileReader, currentXFlower);
            }
            System.out.println("SKUTECZNOŚĆ: " + (double)counter/fileReader.getTestFlowers().size() * 100 + "%");
        }else {
            //logika dla podanych przez uzytkownika danych
            UserMode userMode = new UserMode();
            userMode.getTestPointsFromUser();
            List<Flower> testListFromUser = userMode.getUserFlowers();
            testListFromUser.forEach(System.out::println);

            for (Flower currentXFlower : testListFromUser) {
                myMethod(k, fileReader, currentXFlower);
            }
            System.out.println("SKUTECZNOŚĆ: " + (double)counter/testListFromUser.size() * 100 + "%");
        }
    }

    private static void myMethod(int k, FileReader fileReader, Flower currentXFlower) {
        String actualName = currentXFlower.name();
        for (Flower currentPointFlower : fileReader.getTrainFlowers()) {
            double distance = Math.sqrt(
                    Math.pow(currentPointFlower.a() - currentXFlower.a(), 2) +
                            Math.pow(currentPointFlower.b() - currentXFlower.b(), 2) +
                            Math.pow(currentPointFlower.c() - currentXFlower.c(), 2) +
                            Math.pow(currentPointFlower.d() - currentXFlower.d(), 2)
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
            String pointName = distance.getPoint().name();
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
}