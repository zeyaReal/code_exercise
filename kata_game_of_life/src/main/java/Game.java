/**
 * Created by zeya on 14/11/20.
 */
public class Game {
    public static final int CELL_ALIVE_FLAG = 1;
    private static final int CELL_DEAD_FLAG = 0;
    private int[][] world;
    private boolean[][] boolWorld;

    public Game(int[][] world) {
        this.world = world;
        this.boolWorld = new boolean[world.length][world[0].length];
        for (int row = 0; row < getWorldLength(); row++) {
            for (int col =0; col< getWorldWidth(); col++){
                this.boolWorld[row][col] = (world[row][col] == CELL_ALIVE_FLAG);
            }
        }
    }

    public boolean isAlive(int row, int col) {
        if (row < 0 || col < 0 || row >= getWorldLength() || col >= getWorldWidth())
            return false;
        return this.boolWorld[row][col];
    }

    public void evolve() {
        boolean[][] newWorld = new boolean[getWorldLength()][getWorldWidth()];

        for (int row = 0; row < getWorldLength(); row++) {
            for (int col = 0; col < getWorldWidth(); col++) {
                int neighbourCount = calculateNeighbourCount(row, col);
                if (neighbourCount == 3) {
                    newWorld[row][col] = true;
                } else if (neighbourCount > 3 || neighbourCount < 2){
                    newWorld[row][col] = false;
                } else {
                    newWorld[row][col] = this.boolWorld[row][col];
                }
            }
        }

        this.boolWorld = newWorld;
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

    private int getWorldWidth() {
        return this.boolWorld[0].length;
    }

    private int getWorldLength() {
        return this.boolWorld.length;
    }
}
