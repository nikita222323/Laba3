package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

public class Frame extends JFrame {

    Panel panel = new Panel();

    public Frame() throws URISyntaxException {
        setTitle("Окно");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(new Dimension(1900,1000));
        setLocationRelativeTo(null);
        add(panel);
    }
}