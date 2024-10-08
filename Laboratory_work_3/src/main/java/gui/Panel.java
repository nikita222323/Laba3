package gui;

import reactor.ReactorHolder;
import readers.JsonReader;
import m.ParseM;
import readers.XmlReader;
import readers.YamlReader;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Panel extends JPanel {

    JButton b_convert = new JButton("Конвертировать");
    JButton b_openFile = new JButton("Выбрать файл");
    JButton b_tree = new JButton("Показать результат");
    JButton b_exit = new JButton("Выход");
    GridLayout gr = new GridLayout(2, 2);
    JScrollPane scrollPane;

    Jfilechooser jfilechooser;
    String path;
    ParseM parseM;
    ReactorHolder reactorHolder = new ReactorHolder();
    Tree tree;

    JsonReader jsonReader = new JsonReader();
    XmlReader xmlReader = new XmlReader();
    YamlReader yamlReader = new YamlReader();

    public Panel() throws URISyntaxException {

        setLayout(gr);
        add(b_convert);
        add(b_openFile);
        add(b_tree);
        add(b_exit);

        b_convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jfilechooser = new Jfilechooser();
                    path = jfilechooser.openMFile();
                    parseM = new ParseM(path);
                    JOptionPane.showMessageDialog(null, "Конвертация завершена");
                }
                catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b_openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jfilechooser = new Jfilechooser();
                    path = jfilechooser.openFile();
                    File file = new File(path);

                    jsonReader.setNextReader(xmlReader);
                    xmlReader.setNextReader(yamlReader);
                    try {
                        jsonReader.readFile(file, reactorHolder);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        b_tree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tree != null) {
                    remove(scrollPane);
                }

                System.out.println(jsonReader.getReactorHolder().getReactorHashMap());
                JTree jtree = null;
                if (jsonReader.getCheck()) {
                    jtree = new JTree(new Tree().createTree(jsonReader.getReactorHolder()));
                } else if (xmlReader.getCheck()) {
                    jtree = new JTree(new Tree().createTree(xmlReader.getReactorHolder()));
                } else if (yamlReader.getCheck()) {
                    jtree = new JTree(new Tree().createTree(yamlReader.getReactorHolder()));
                }

                scrollPane = new JScrollPane(jtree);
                scrollPane.setPreferredSize(new Dimension(400, 400));
                new FrameTree().getPanel().add(scrollPane);

                revalidate();
                repaint();
            }
        });

        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}