package gui.controllers;

import gui.views.Window;

public class HomeController {
    public void playPressed(Window window) {
        // System.out.println("Start Game!");
        window.openGameForm();
    }

    public void quitPressed() {
        // System.out.println("Quit Game!");
    }
}