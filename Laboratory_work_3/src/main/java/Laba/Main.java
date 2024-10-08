package Laba;

import gui.Frame;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

public class Main {
    Frame frame;

    public static void main(String[] args) throws URISyntaxException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            try {
                Frame frame = new Frame();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }
}