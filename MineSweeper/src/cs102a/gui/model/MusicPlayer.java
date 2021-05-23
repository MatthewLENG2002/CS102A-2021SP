package model;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicPlayer {

    private final File file;
    private boolean isLoop = false;
    private boolean isPlaying;
    private int volume = 6;

    private playSoundThread playSoundThread;

    public MusicPlayer(String musicPath) {
        this.file = new File(musicPath);
        playSoundThread = new playSoundThread();
    }

    public void play() {
        playSoundThread = new playSoundThread();
        playSoundThread.start();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        try{
        playSoundThread.control.setValue(volume);
        }catch(Exception e){}
    }

    public void over() {
        isPlaying = false;
        if (playSoundThread != null) {
            playSoundThread.stop();
            System.gc();
        }
    }

    public void setLoop(boolean isLoop) {
        this.isLoop = isLoop;
    }


    private class playSoundThread extends Thread {
        SourceDataLine sourceDataLine = null;
        BufferedInputStream bufferedInputStream = null;
        AudioInputStream audioInputStream = null;
        FloatControl control;

        @Override
        public void run() {
            isPlaying = true;
            do {
//                SourceDataLine sourceDataLine = null;
//                BufferedInputStream bufferedInputStream = null;
//                AudioInputStream audioInputStream = null;
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);

                    AudioFormat format = audioInputStream.getFormat();
                    sourceDataLine = AudioSystem.getSourceDataLine(format);
                    sourceDataLine.open();

                    control = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
                    control.setValue(volume);

                    sourceDataLine.start();
                    byte[] buf = new byte[512];
                    int len;
                    while (isPlaying && (len = audioInputStream.read(buf)) != -1) {
                        sourceDataLine.write(buf, 0, len);
                    }
                } catch (Exception e) {
                } finally {
                    if (sourceDataLine != null) {
                        sourceDataLine.drain();
                        sourceDataLine.close();
                    }
                    try {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (audioInputStream != null) {
                            audioInputStream.close();
                        }
                    } catch (IOException e) {
                    }
                }
            } while (isPlaying && isLoop);
        }
    }
}
