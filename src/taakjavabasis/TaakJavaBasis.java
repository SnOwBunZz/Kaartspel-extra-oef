package taakjavabasis;

import java.util.Scanner;
import taakjavabasis.ui.UI;

public class TaakJavaBasis {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        
        UI ui = new UI(reader);
        ui.run();
    }
    
}
