package cs102a.util;
import cs102a.Info;

public class PlayerSwitch {

    public PlayerSwitch(){
        if ((Info.roundNow/Info.round)%2 ==0){
            Info.playerNow=1;
        }
        else if ((Info.roundNow/Info.round)%2 ==1){
            Info.playerNow=2;
        }
    }

    public static void playerSwitch(){
        if ((Info.roundNow/Info.round)%2 ==0){
            Info.playerNow=1;
        }
        else if ((Info.roundNow/Info.round)%2 ==1){
            Info.playerNow=2;
        }
    }


//    return the win player, 1 -> player 1, 2 -> player 2, 0 -> draw, -1 -> indefinite

    public int winRefresh(){
        if (Info.roundNow%(Info.round*2) == 0){
            if ((Info.playerScore[0]-Info.playerScore[1]) > Info.mineLeft){
                Info.playerPoints[0] += 10;
                return 1;
            } else if((Info.playerScore[1]-Info.playerScore[0]) > Info.mineLeft){
                Info.playerPoints[1] += 10;
                return 2;
            }
        }
        if (Info.mineLeft==0){
            if (Info.playerScore[0]>Info.playerScore[1]){
                Info.playerPoints[0] += 10;
                return 1;
            } else if (Info.playerScore[1]>Info.playerScore[0]){
                Info.playerPoints[1] += 10;
                return 2;
            } else if (Info.playerScore[0]==Info.playerScore[1]){
                if (Info.playerFaults[1]>Info.playerFaults[0]){
                    Info.playerPoints[0] += 10;
                    return 1;
                } else if (Info.playerFaults[0]>Info.playerFaults[1]){
                    Info.playerPoints[1] += 10;
                    return 2;
                } else if (Info.playerFaults[1]==Info.playerFaults[0]){
                    Info.playerPoints[0] += 10;
                    Info.playerPoints[1] += 10;
                    return 0;
                }
            }
        }
        return -1;
    }
}
