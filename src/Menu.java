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
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Do you want to play on your points?");
        boolean exitFlag = false;
        while (!exitFlag) {
            int userInput = scanner1.nextInt();
            if (userInput == 1) {
                mode = 1;
                exitFlag = true;
            } else if (userInput == 2) {
                mode = 2;
                exitFlag = true;
            } else {
                System.out.println("Bad number try it again!");
            }
        }
    }
    public int getKValue() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Witaj mpp1, podaj liczbe k: [k musi byc intem]");
        String k = scanner2.nextLine();
        return Integer.parseInt(k);
    }
}
