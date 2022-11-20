package frost.countermobil.Maze.models;

public class Door extends MapSight{
    Room room1, room2;
    private boolean blocked = true;

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }
}
