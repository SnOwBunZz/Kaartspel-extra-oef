package taakjavabasis;

import java.util.Scanner;

import taakjavabasis.ui.UI;

/**
 *
 * @author Michiel Thomassen
 */
public class TaakJavaBasis {

    /**
     * Main class of this program.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        UI ui = new UI(reader);

        ui.run();
    }

}
