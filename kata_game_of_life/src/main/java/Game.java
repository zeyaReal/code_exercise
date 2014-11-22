/**
 * Created by zeya on 14/11/20.
 */
public class Game {
    private int[][] world;

    public Game(int[][] world) {
        this.world = world;
    }

    public boolean isAlive(int row, int col) {
        if (row < 0 || col < 0 || row >= this.world.length || col >= this.world[0].length)
            return false;
        return this.world[row][col] == 1;
    }

    public void evolve() {
        int[][] newWorld = new int[this.world.length][this.world[0].length];

        for (int row = 0; row < this.world.length; row++) {
            for (int col = 0; col < this.world[0].length; col++) {
                if (getNeighbourCount(row, col) == 3) {
                    newWorld[row][col] = 1;
                } else {
                    newWorld[row][col] = this.world[row][col];
                }
            }
        }

        this.world = newWorld;
    }

    private int getNeighbourCount(int row, int col) {
        int count = 0;
        for (int i = row-1; i <row+2 ; i++) {
            for (int j = col-1; j < col+2; j++) {
                if (isAlive(i,j)) {
                    count++;
                }
            }
        }
        if (isAlive(row,col))
            count--;
        return count;
    }
}
