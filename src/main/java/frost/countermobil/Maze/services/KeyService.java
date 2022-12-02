package frost.countermobil.Maze.services;

import frost.countermobil.Maze.models.Key;
import frost.countermobil.Maze.models.Player;

public class KeyService {

    public boolean checkIfCanGetKey(Key key, Player player) {
        return key.getCost() <= player.totalCoins();
    }
}
