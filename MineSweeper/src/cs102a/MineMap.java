package cs102a;

import java.util.Random;

public class MineMap {
//    int level;
//    int attribute;
//    int rowi;
//    int coli;
//    int minei;
    int[][] temp;
    int[][] temp2;
    int[][] minemap;
    public int[][] map;

    // when level=1,2,3 , generate map of specific size with negative value represented the mine and other figures represented the number of mines in the 3*3 region

    public MineMap(int level) {
        this.map = mapGenerator(level);
    }

    /* when level=4 ,generate the map with rowi*coli and #minei of mines in it
    !!!!!remember to append the restrictions of size less than 24*30 and #mine no more than half of the total #grid later
     */

    public MineMap(int level, int rowi, int coli, int minei) {
        this.map = mapGenerator(level, rowi, coli, minei);
    }

    public int[][] mapGenerator(int level) {
        Random r = new Random();
        if (level == 1) {
            temp = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    temp[i][j] = 0;
                }
            }
            for (int i = 0; i < 10; i++) {
                int row = r.nextInt(9);
                int col = r.nextInt(9);
                if (temp[row][col] != 1)
                    temp[row][col] = 1;
                else i--;
            }

        }
        if (level == 2) {
            temp = new int[16][16];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    temp[i][j] = 0;
                }
            }
            for (int i = 0; i < 40; i++) {
                int row = r.nextInt(16);
                int col = r.nextInt(16);
                if (temp[row][col] != 1)
                    temp[row][col] = 1;
                else i--;
            }

        }
        if (level == 3) {
            temp = new int[16][30];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 30; j++) {
                    temp[i][j] = 0;
                }
            }
            for (int i = 0; i < 99; i++) {
                int row = r.nextInt(16);
                int col = r.nextInt(30);
                if (temp[row][col] != 1)
                    temp[row][col] = 1;
                else i--;
            }

        }

        map = mineCounter(temp);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                while (map[i][j] == -9 ) {
                    return mapGenerator(level);
                }
            }
        }

        minemap = temp;
        temp = null;

        return map;

    }

    public int[][] mapGenerator(int level, int rowi, int coli, int minei) {
        if (level != 4)
            return null;
        Random r = new Random();
        temp = new int[rowi][coli];
        for (int i = 0; i < rowi; i++) {
            for (int j = 0; j < coli; j++) {
                temp[i][j] = 0;
            }
        }
        for (int i = 0; i < minei; i++) {
            int row = r.nextInt(rowi);
            int col = r.nextInt(coli);
            if (temp[row][col] != 1)
                temp[row][col] = 1;
            else i--;
        }


        map = mineCounter(temp);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                while (map[i][j] == -9) {
                    return mapGenerator(level, rowi, coli, minei);
                }
            }
        }

        minemap = temp;
        temp = null;

        return map;
    }

    public int[][] mineCounter(int[][] temp) {
        temp2 = new int[temp.length][temp[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                int counter = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        try {
                            counter += temp[i + k][j + l];
                        } catch (Exception e) {
                        }
                    }
                }
                if (temp[i][j] == 1)
                    temp2[i][j] =-counter;
                else
                    temp2[i][j] = counter;
            }
        }
        return temp2;
    }
}