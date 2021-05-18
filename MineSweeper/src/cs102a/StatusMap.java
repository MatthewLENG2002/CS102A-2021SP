package cs102a;

public class StatusMap {
/*       int status, 1 represents uncovered, 0 represents covered, -1 represents flagged, -2 represents wrong flagged
        reset: set all the grid to covered status;
        uncover: parameters x,y stands for the coordinate(x,y) of the map (start from (1,1)), map represents the map that contains the #mine
                    if the uncover grid isn't mine, return true and the status becomes 1
                    if the uncover grid is mine,return false and the status also becomes 1
        flag: parameters are the same as uncover
                    if the flag grid isn't mine, return false and the status becomes 1
                    if the flag grid is mine,return true and the status becomes -1
 */
    int status;
    public static int[][] statusmap;

    public StatusMap(int[][] map){
        this.statusmap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                statusmap[i][j] = 0;
            }
        }
    }

    public void reset() {
        for (int i = 0; i < statusmap.length; i++) {
            for (int j = 0; j < statusmap[0].length; j++) {
                statusmap[i][j] = 0;
            }
        }
    }

    public static boolean uncover(int x, int y) {
        if (MineMap.map[x-1][y-1] >=0){
            statusmap[x-1][y-1] = 1;
            return true;
        }
        else {
            statusmap[x-1][y-1] = 1;
            return false;
        }

    }

    public static boolean flag(int x, int y) {
        if (MineMap.map[x-1][y-1] < 0){
            statusmap[x-1][y-1] = -1;
            return true;
        }
        else {
            statusmap[x-1][y-1] = -2;
            return false;
        }
    }
}
