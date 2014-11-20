/**
 * Created by zeya on 14/11/20.
 */
public class Game {
    private int[][] world;

    public Game(int[][] world) {

        this.world = world;
    }

    public boolean isAlive(int row, int col) {
        return this.world[row][col] == 1;
    }
}
