package cs102a;

import java.util.Random;

public class MineMap {
    int level;
    int attribute;
    int rowi;
    int coli;
    int minei;
    int[][] minemap;
    int[][] temp;
    int[][] map;

    public void mapGenerator(int level) {
        Random r = new Random();
        if (level == 1) {
            temp = new int[9][9];
            for (int i = 0; i < 10; i++) {
                int row = r.nextInt(9);
                int col = r.nextInt(9);
                if (temp[row][col] != 1)
                    temp[row][col] = 1;
                else i--;
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (temp[i][j] != 1)
                        temp[i][j] = 0;
                }
            }
        }
        if (level == 2) {
            temp = new int[16][16];
            for (int i = 0; i < 40; i++) {
                int row = r.nextInt(16);
                int col = r.nextInt(16);
                if (minemap[row][col] != 1)
                    minemap[row][col] = 1;
                else i--;
            }
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (minemap[i][j] != 1)
                        minemap[i][j] = 0;
                }
            }
        }
        if (level == 3) {
            temp = new int[16][30];
            for (int i = 0; i < 99; i++) {
                int row = r.nextInt(16);
                int col = r.nextInt(30);
                if (minemap[row][col] != 1)
                    minemap[row][col] = 1;
                else i--;
            }
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 30; j++) {
                    if (minemap[i][j] != 1)
                        minemap[i][j] = 0;
                }
            }
        }

        mineCounter(temp);

        for (int i = 0; i < minemap.length; i++) {
            for (int j = 0; j < minemap[0].length; j++) {
                while (map[i][j] == 9) {
                    mapGenerator(level);
                }
            }
        }

        map = temp;
        temp = null;

    }

    public void mineGenerator(int level, int rowi, int coli, int minei) {
        Random r = new Random();
        temp = new int[rowi][coli];
        for (int i = 0; i < minei; i++) {
            int row = r.nextInt(9);
            int col = r.nextInt(9);
            if (minemap[row][col] != 1)
                minemap[row][col] = 1;
            else i--;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (minemap[i][j] != 1)
                    minemap[i][j] = 0;
            }
        }
    }

    public void mineCounter(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            int counter = 0;
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 1) {
                    map[i][j] = -1;
                } else {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            try {
                                counter += temp[i + k][j + l];
                            } catch (Exception e) {
                            }
                        }
                    }
                    map[i][j] = counter;
                }
            }
        }
    }

}
