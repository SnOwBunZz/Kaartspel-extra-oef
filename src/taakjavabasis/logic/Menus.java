package taakjavabasis.logic;

import java.util.Scanner;

public class Menus {

    private GameLogic logic;
    private Scanner reader;

    public Menus(GameLogic logic, Scanner reader) {
        this.logic = logic;
        this.reader = reader;
    }

    public void mainMenu() {
        System.out.println("MAIN MENU"
                + "\n--------"
                + "\n[1] Shuffle"
                + "\n[2] Quit game");

        /*
         Asks for input, only one or two accepted
         Keep in mind that when you add menu options to adjust this!
         */
        int input = 0;
        while (true) {
            try {
                System.out.print("Choice: ");
                input = Integer.parseInt(reader.nextLine());
                if (input < 1 || input > 2) {
                    System.out.println("Please enter 1 or 2.");
                } else {
                    break;
                }
            } catch (NumberFormatException nFE) {
                System.out.println("Please enter a valid number.");
            }
        }

        switch (input) {
            case 1:
                logic.addPlayers(reader);
                logic.preparation();
                logic.game(this);
            case 2:
                break;
        }
    }

    public Card gameMenu(Player player) {
        System.out.print("[1] Draw card [2] Forfeit"
                + "\nPlayer " + player.getName() + ": ");
        int input = Integer.parseInt(reader.nextLine());

        Card card = new Card(99, 99);

        switch (input) {
            case 1:
                card = player.drawCard();
                return card;
            case 2:
                return card;
        }

        return card;
    }
}
