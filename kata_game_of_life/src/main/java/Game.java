/**
 * Created by zeya on 14/11/20.
 */
public class Game {
    public static final int CELL_ALIVE_FLAG = 1;
    private static final int CELL_DEAD_FLAG = 0;
    private int[][] world;

    public Game(int[][] world) {
        this.world = world;
    }

    public boolean isAlive(int row, int col) {
        if (row < 0 || col < 0 || row >= getWorldWidth() || col >= getWorldLength())
            return false;
        return this.world[row][col] == CELL_ALIVE_FLAG;
    }

    public void evolve() {
        int[][] newWorld = new int[getWorldWidth()][getWorldLength()];

        for (int row = 0; row < getWorldWidth(); row++) {
            for (int col = 0; col < getWorldLength(); col++) {
                int neighbourCount = calculateNeighbourCount(row, col);
                if (neighbourCount == 3) {
                    newWorld[row][col] = CELL_ALIVE_FLAG;
                } else if (neighbourCount > 3 || neighbourCount < 2){
                    newWorld[row][col] = CELL_DEAD_FLAG;
                } else {
                    newWorld[row][col] = this.world[row][col];
                }
            }
        }

        this.world = newWorld;
    }

    private int calculateNeighbourCount(int row, int col) {
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

    private int getWorldLength() {
        return this.world[0].length;
    }

    private int getWorldWidth() {
        return this.world.length;
    }
}
