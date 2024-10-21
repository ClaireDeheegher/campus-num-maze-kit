package edu.campusnum.algo.maze.model;

import edu.campusnum.algo.maze.JsonMazeReader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Lab3 extends JPanel {
    public List getList() {

        List<MazeCell> maze = null;
        try {
            // We create a new JsonMazeReader object with the file name as parameter
            JsonMazeReader mazeLoader = new JsonMazeReader("mazes.json");
            // Specify the size and the name of the maze to load
            int mazeSize = 3;
            String mazeName = "ex-0";
            // We get the maze as a list of MazeCell
            maze = mazeLoader.getMaze(mazeSize, mazeName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return maze;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        List maze = getList();
        drawMaze(20, 20, 120, 120, 100, maze, g);
    }

    public void drawMaze(int x, int y, int x2, int y2, int length, java.util.List mazeCellList, Graphics g) {
        int i;
        for (i = 0; i < mazeCellList.size(); i++) {
            MazeCell cell = (MazeCell) mazeCellList.get(i);
            boolean[] walls = cell.getWalls();
            boolean entrance = cell.getStart();
            boolean exit = cell.getExit();
            if (i == 3 || i == 6) {
                x = 20;
                y = y2;
                x2 = 120;
                y2 = y2 + length;
            }
            if (walls[0] == true) {
                g.drawLine(x, y, x2, y);
            }
            if (walls[1] == true) {
                g.drawLine(x2, y, x2, y2);
            }
            if (walls[2] == true) {
                g.drawLine(x2, y2, x, y2);
            }
            if (walls[3] == true) {
                g.drawLine(x, y, x, y2);
            }
            if (entrance == true) {
                g.setColor(Color.green);
                g.fillRect(x, y, 100, 100);
            }
            if (exit == true) {
                g.setColor(Color.red);
                g.fillRect(x, y, 100, 100);
            }
            x = x2;
            x2 = x2 + length;
            g.setColor(Color.black);
        }
    }
}
