/**
 * Created by zeya on 14/11/20.
 */
public class Game {
    public static final int CELL_ALIVE_FLAG = 1;
    private boolean[][] innerWorld;

    public Game(int[][] world) {
        this.innerWorld = new boolean[world.length][world[0].length];
        for (int row = 0; row < getWorldLength(); row++) {
            for (int col = 0; col < getWorldWidth(); col++) {
                this.innerWorld[row][col] = (world[row][col] == CELL_ALIVE_FLAG);
            }
        }
    }

    public boolean isAlive(int row, int col) {
        return !isBeyondWorldEdge(row, col) && this.innerWorld[row][col];
    }

    private boolean isBeyondWorldEdge(int row, int col) {
        return row < 0 || col < 0 || row >= getWorldLength() || col >= getWorldWidth();
    }

    public void evolve() {
        boolean[][] newWorld = new boolean[getWorldLength()][getWorldWidth()];

        for (int row = 0; row < getWorldLength(); row++) {
            for (int col = 0; col < getWorldWidth(); col++) {
                int neighbourCount = calculateNeighbourCount(row, col);
                newWorld[row][col] = this.innerWorld[row][col];
                newWorld[row][col] = isSuitNewLifeBorn(neighbourCount) || newWorld[row][col];
                newWorld[row][col] = !isCauseLifeDead(neighbourCount) && newWorld[row][col];
            }
        }

        this.innerWorld = newWorld;
    }

    private boolean isCauseLifeDead(int neighbourCount) {
        return isTooCrowded(neighbourCount) || isTooLonely(neighbourCount);
    }

    private boolean isTooLonely(int neighbourCount) {
        return neighbourCount < 2;
    }

    private boolean isTooCrowded(int neighbourCount) {
        return neighbourCount > 3;
    }

    private boolean isSuitNewLifeBorn(int neighbourCount) {
        return neighbourCount == 3;
    }

    private int count = 0;

    private int calculateNeighbourCount(int row, int col) {
        boolean test;
        count = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                test = isAlive(i, j) && increaseCount();
            }
        }

        test = isAlive(row, col) && decreaseCount();
        return count;
    }

    private boolean increaseCount() {
        count++;
        return true;
    }

    private boolean decreaseCount() {
        count--;
        return true;
    }


    private int getWorldWidth() {
        return this.innerWorld[0].length;
    }

    private int getWorldLength() {
        return this.innerWorld.length;
    }
}
