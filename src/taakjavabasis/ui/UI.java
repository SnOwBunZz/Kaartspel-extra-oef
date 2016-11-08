package taakjavabasis.ui;

import java.util.Scanner;
import taakjavabasis.logic.GameLogic;
import taakjavabasis.logic.Menus;

public class UI {

    private GameLogic logic;
    private Menus menu;

    public UI(Scanner reader) {
        this.logic = new GameLogic();
        this.menu = new Menus(logic, reader);
    }

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        menu.mainMenu();
    }
}
