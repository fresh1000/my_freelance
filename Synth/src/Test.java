import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.media.AudioClip;

public class Test {

	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		File file = new File("0_1000.wav");
		//AudioInputStream audio = new AudioInputStream((TargetDataLine) file);
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(file));
		clip.start();
	}

}
