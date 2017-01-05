import javax.swing.*;
import java.util.ArrayList;

public class FishApp {
   static  ArrayList<GeneralFish> fishesA = new ArrayList<>();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FishPanel fishPanel = new FishPanel();
            fishPanel.startTimer(fishesA);
        });
    }
}
