package taakjavabasis;

import java.util.Scanner;
import taakjavabasis.logic.Card;
import taakjavabasis.logic.Deck;
import taakjavabasis.logic.GameLogic;
import taakjavabasis.logic.Player;
import taakjavabasis.ui.UI;

public class TaakJavaBasis {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        
        UI ui = new UI(reader);
        ui.run();
    }
    
}
