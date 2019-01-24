import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import table.GameTable;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

     /*   GameTable gameTable = new GameTable();
        System.out.println(gameTable); */

        EventQueue.invokeLater(() -> {
            MenuGUI menu = new MenuGUI();
            menu.setVisible(true);

        });
    }

    public static void music() {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try{
            BGM = new AudioStream(new FileInputStream(new File("./home/Documents/Smetana _ Moldau.wav")));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }catch(IOException error){
            System.out.print("file not found");
        }

        MGP.start(loop);
    }
}
