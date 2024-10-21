package edu.campusnum.algo.maze;

import edu.campusnum.algo.maze.model.GraphicInterface;
import edu.campusnum.algo.maze.model.MazeCell;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        try{
            // We create a new JsonMazeReader object with the file name as parameter
            JsonMazeReader mazeLoader = new JsonMazeReader("mazes.json");

            // Specify the size and the name of the maze to load
            int mazeSize = 3;
            String mazeName = "ex-0";

            // We get the maze as a list of MazeCell
            List<MazeCell> maze = mazeLoader.getMaze(mazeSize, mazeName);
            boolean[] walls = maze.get(0).getWalls();

            System.out.println(Arrays.toString(walls));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
       SwingUtilities.invokeLater(new Runnable() {
            final GraphicInterface graphicInterface = new GraphicInterface();
            public void run() {
                GraphicInterface.createAndShowGUI();
            }
        });

    }
}