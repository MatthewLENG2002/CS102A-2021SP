package cs102a.gui.model;

public class EQ {
    public static EQ bgm1 = new EQ("bgm1",true);
    public static EQ bgm2 = new EQ("bgm2",true);
    public static EQ bomb = new EQ("bomb",false);
    public static EQ flag = new EQ("flag",false);

    MusicPlayer py;

    public EQ(String fileName,boolean isLoop) {
        py = new MusicPlayer("sound/" + fileName + ".wav");
        py.setLoop(isLoop);
    }

    public final void play() {
        py.setVolume(6);
//        py.setLoop(isLoop);
        py.play();

        // ? consider its necessity
//        if (!isLoop) System.gc();
    }

    public final void stop() {
        py.over();
    }

    public final boolean changeIsMute() {
        boolean nowIsMute=py.getVolume() == 6;
        if (py.getVolume() == 6) py.setVolume(-8000);
        else py.setVolume(6);
        return nowIsMute;
    }
}
