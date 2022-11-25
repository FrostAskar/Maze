package frost.countermobil.Maze.models;

public class Door extends MapSight{
    Room room1, room2;
    Key key;
    private boolean blocked = false;

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

    public void lock(Key key) {
        this.blocked = true;
        this.key = key;
    }

    public void unlock() {
        this.blocked = false;
    }

    public Key getKey(){
        return this.key;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
