package gui;

import javax.swing.*;
import java.awt.*;

public class FrameTree extends JFrame {

    private JPanel panel = new JPanel();

    public FrameTree()  {
        setTitle("Реакторы");
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        add(panel);
    }

    public JPanel getPanel() {
        return panel;
    }
}