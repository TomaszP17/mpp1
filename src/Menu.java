import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private int mode;

    public int getMode() {
        return mode;
    }

    public void welcomeInfo(){
        System.out.println("<><><><><><><><><><><><><><><><>");
        System.out.println("Version: 1.0_beta");
        System.out.println("Author: Tomasz Pluciński s27477");
        System.out.println("<><><><><><><><><><><><><><><><>");
    }

    public void chooseMode() {
        System.out.println("Do you want to play on your points?");
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            if (scanner.nextInt() == 1) {
                mode = 1;
                exitFlag = true;
            } else if (scanner.nextInt() == 2) {
                mode = 2;
                exitFlag = true;
            } else {
                System.out.println("Bad number try it again!");
            }
        }
    }
    public int getKValue() {
        System.out.println("Witaj mpp1, podaj liczbe k: [k musi byc intem]");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
