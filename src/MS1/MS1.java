package MS1;

import java.util.Random;

public class MS1 {

    public boolean[][] mines;
    public int[][] minedNeighbours;
    Random rand = new Random();
    int curMine = 0;
    int maxMine, rows, columns;

    public MS1(int r, int c, int m) {
        rows = r;
        columns = c;

        minedNeighbours = new int[r][c];
        mines = new boolean[r][c];

    }

    public static void main(String args[]) {
        int r = Integer.parseInt(args[0]);
        int c = Integer.parseInt(args[1]);
        int m = Integer.parseInt(args[2]);
        MS1 test = new MS1(r, c, m);
        test.populate(m);
        //test.print();
        System.out.println(test.toString());
    }

    // print each row and column
    public void print() {
        for (int row = 0; row < mines.length; row++) {
            for (int col = 0; col < mines[row].length; col++) {
                System.out.print(mines[row][col] + "\t");
            }
            System.out.println();
        }
       
        for (int row = 0; row < minedNeighbours.length; row++) {
            for (int col = 0; col < minedNeighbours[row].length; col++) {
                System.out.print(minedNeighbours[row][col] + "\t");
            }
            System.out.println();
        }

    }

    public boolean mineTile(int row, int col) {
        if ((row != 0 && col != 0) && (mines[row][col] == false)) {
            curMine++;
            mines[row][col] = true;
            for (int y = row - 1; y <= row + 1; y++) {
                for (int x = col - 1; x <= col + 1; x++) {

                    if (y == -1) {
                        continue;
                    }
                    if (y == rows) {
                        continue;
                    }
                    if (x == -1) {
                        continue;
                    }
                    
                    if (x == columns) {
                        continue;
                    }

                    minedNeighbours[y][x]++;

                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void populate(int maxMine) {
        while (curMine < maxMine) {
            int randRow = rand.nextInt(rows);
            int randCol = rand.nextInt(columns);
            mineTile(randRow, randCol);
        }
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < minedNeighbours.length; row++) {
            for (int col = 0; col < minedNeighbours[row].length; col++) {
                if (mines[row][col]) {
                    s += "*" ;
                } else {
                    s += Integer.toString(minedNeighbours[row][col]) ;
                }
            }
            s += "\n";

        }
        return s;
    }
}
