import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import table.GameTable;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {

    public static void main(String[] args) {

     /*   GameTable gameTable = new GameTable();
        System.out.println(gameTable); */

        EventQueue.invokeLater(() -> {
            MenuGUI menu = new MenuGUI();
            menu.setVisible(true);
            music();
        });
    }

    public static void music()
    {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("/home/dani/Documents/Smetana _ Moldau.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
}
