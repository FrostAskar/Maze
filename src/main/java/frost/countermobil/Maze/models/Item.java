package frost.countermobil.Maze.models;

public abstract class Item {

    int roomId;
    double coordX;
    double coordY;

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoords(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }
}
