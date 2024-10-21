package edu.campusnum.algo.maze.model;

import javax.swing.*;

public class GraphicInterface extends JPanel {
    public static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Labyrinth Maze");
        JPanel panel = new Lab3();
        f.getContentPane().add(panel);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(500,500);
        f.setVisible(true);
    }


}
