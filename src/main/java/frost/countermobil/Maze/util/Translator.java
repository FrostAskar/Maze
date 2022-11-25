package frost.countermobil.Maze.util;

import frost.countermobil.Maze.models.Maze;

public class Translator {

    //Front uses N, S, W & E to define the sides. Back has Maze.Directions. This translates the message

    public Maze.Directions singleLetterToWord(String letter) {
        Maze.Directions dir = null;
        switch (letter) {
            case "N":
                dir = Maze.Directions.NORTH;
                break;
            case "S":
                dir = Maze.Directions.SOUTH;
                break;
            case "W":
                dir = Maze.Directions.WEST;
                break;
            case "E":
                dir = Maze.Directions.EAST;
                break;
        }

        return dir;
    }
}
