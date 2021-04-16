package ref.cs102a.aeroplane.model;

import ref.cs102a.aeroplane.frontend.GameGUI;

import javax.swing.*;

public class ChessBoard extends JPanel {

    public ChessBoard(int xOffSet, int yOffSet, GameGUI nowGamingGUI) {
    }


    /**
     * @apiNote 开局即放入ChessBoard并只需调用此方法，其他的自动执行
     */
    public void startGame() {
        //开始播放bgm
        if (GameInfo.getTheme() == 1) Sound.GAMING_THEME1.play(true);
        else Sound.GAMING_THEME2.play(true);
        beginTurn();
    }


    // 结束回合
    public boolean endTurn() {
        // 检查游戏是否结束
        if (checkGameEnd()) {
            endGame();
            return false;
        } else {
            // 先确定当前玩家有没有赢
            //...
            return true;
        }
    }

    // 结束游戏
    public void endGame() {
        // TODO: 2020/12/8 联网模式还要广播游戏结束
        EndGameAndShowRank endGameAndShowRank = new EndGameAndShowRank(nowGamingGUI);
        endGameAndShowRank.setVisible(true);
        nowGamingGUI.dispose();
        Sound.GAMING_THEME1.end();
        Sound.GAMING_THEME2.end();
    }

    /*
     * util methods for assisting judging
     */

    // 判断index上有没有其他方的棋子
    public boolean hasOtherPlane(int index) {
        for (Aeroplane plane : planes)
            if (plane.getGeneralGridIndex() == index && plane.getColor() != nowPlayer) return true;
        return false;
    }

    // 获取所有当前格子上的敌机以battle
    public LinkedList<Aeroplane> getOppoPlanes(int index) {
        LinkedList<Aeroplane> p = new LinkedList<>();
        for (Aeroplane plane : planes) {
            if (plane.getGeneralGridIndex() == index && plane.getColor() != nowPlayer) p.add(plane);
        }
        return p;
    }

    // 获取所有当前格子上任意一架
    public LinkedList<Aeroplane> getMyPlanes(int index) {
        LinkedList<Aeroplane> p = new LinkedList<>();
        for (Aeroplane plane : planes) {
            if (plane.getGeneralGridIndex() == index && plane.getColor() == nowPlayer) p.add(plane);
        }
        return p;
    }

    public LinkedList<Aeroplane> getPartners(int indexOfMyTeam) {
        LinkedList<Aeroplane> p = new LinkedList<>();
        for (Aeroplane plane : planes) {
            if (plane.indexOfTeam == indexOfMyTeam && plane.getColor() == nowPlayer) p.add(plane);
        }
        if (indexOfMyTeam == -1) {
            p.clear();
        }
        return p;
    }

    // 获取index上的飞机数目
    public int selfPlaneNumOnIndex(int index) {
        int planeNum = 0;
        for (Aeroplane plane : planes) {
            if (plane.getGeneralGridIndex() == index) {
                planeNum++;
            }
        }
        return planeNum;
    }

    // 获取index上的飞机数目
    public int realSelfPlaneNumOnIndex(int index, int myColor) {
        int planeNum = 0;
        for (int i : BoardCoordinate.COLOR_PLANE_NUMBER[myColor]) {
            if (planes[i].getGeneralGridIndex() == index) {
                planeNum++;
            }
        }
        return planeNum;
    }

    public void recordOnePlayerEnd() {
        if (winner1Index == -1) winner1Index = nowPlayer;
        else if (winner2Index == -1) winner2Index = nowPlayer;
        else if (winner3Index == -1) winner3Index = nowPlayer;
        if (winner3Index != -1) state = GameState.GAME_END;

        if (GameInfo.isIsOnlineGame()) {
            // TODO: 2020/12/8 socket 广播玩家胜利
        }
    }

    boolean checkGameEnd() {
        return state == GameState.GAME_END;
    }


    /*
     * util methods for external accessing
     */
    public ArrayList<Integer> getMovedPlanes() {
        return movedPlanes;
    }

    public int getNowPlayer() {
        return nowPlayer;
    }

    public void setNowPlayer(int nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public Aeroplane[] getPlanes() {
        return planes;
    }

    public int getWinner1Index() {
        return winner1Index;
    }

    public void setWinner1Index(int winner1Index) {
        this.winner1Index = winner1Index;
    }

    public int getWinner2Index() {
        return winner2Index;
    }

    public void setWinner2Index(int parseInt) {
        this.winner2Index = parseInt;
    }

    public int getWinner3Index() {
        return winner3Index;
    }

    public int getWinner4Index() {
        for (int i = 0; i < 4; i++) {
            if (i != winner1Index && i != winner2Index && i != winner3Index) return i;
        }
        return -1;
    }

    public int[] getPlayerSteps() {
        return playerSteps;
    }
}
