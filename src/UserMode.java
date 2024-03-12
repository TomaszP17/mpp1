import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMode {
    private final List<Flower> userFlowers = new ArrayList<>();

    public void getTestPointsFromUser(){
        System.out.println("Enter a new point: [FORMAT: 0.0,0.0,0.0,0.0,name] [0 - END LOOP]");
        Scanner scanner = new Scanner(System.in);
        String newLine = scanner.nextLine();
        while(!newLine.equals("0")){
            String[] splitLine = newLine.split(",");
            Flower flower = new Flower(
                    Double.parseDouble(splitLine[0]),
                    Double.parseDouble(splitLine[1]),
                    Double.parseDouble(splitLine[2]),
                    Double.parseDouble(splitLine[3]),
                    splitLine[4]
            );
            userFlowers.add(flower);
            newLine = scanner.nextLine();
        }
    }
    public List<Flower> getUserFlowers() {
        return userFlowers;
    }
}
