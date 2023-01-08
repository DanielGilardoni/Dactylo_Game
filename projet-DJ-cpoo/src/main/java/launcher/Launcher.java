package launcher;

import gui.Gui;
/**
 * @authors [Cortial Jade, Gilardoni Daniel]
 */
public class Launcher {
    public static void main( String[] args ){
        Gui gui = new Gui(1000, 660);
        gui.setHomeView();
    }
}
