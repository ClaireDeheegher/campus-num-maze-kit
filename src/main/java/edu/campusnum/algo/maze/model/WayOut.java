package edu.campusnum.algo.maze.model;

import java.util.List;

public class WayOut {
    Lab3 generation = new Lab3();
    List maze = generation.getList();

    public WayOut() {}

    public void resolveMaze(List maze){
        int posX =0;
        int posY =0;
        boolean exit =true;
        int i=0;

        while (!exit){
            MazeCell cell = (MazeCell) maze.get(i);
            boolean[] walls = cell.getWalls();
            boolean end = cell.getExit();
            if (end==true){
                exit = true;
                break;
            }


        }
    }

}
