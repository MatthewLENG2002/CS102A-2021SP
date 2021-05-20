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
}
