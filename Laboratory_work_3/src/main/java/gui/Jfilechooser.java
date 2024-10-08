package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;

public class Jfilechooser extends Component {

    private JFileChooser fileChooser;
    private JFileChooser fileChooserM;

    public Jfilechooser() throws URISyntaxException {
        try {
            File currentDirectory = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser = new JFileChooser(currentDirectory);
            fileChooserM = new JFileChooser(currentDirectory);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public String openFile() {
        fileChooser.setDialogTitle("Выбор файла");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        while (true) {
            int result = fileChooser.showOpenDialog(Jfilechooser.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!(filePath.toLowerCase().endsWith(".yaml") || filePath.toLowerCase().endsWith(".json") || filePath.toLowerCase().endsWith(".xml"))) {
                    JOptionPane.showMessageDialog(null, "Выбранный файл не является файлом формата yaml, xml или json", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    continue; // Вернуться к выбору файла
                }
                JOptionPane.showMessageDialog(null, selectedFile);
                return fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                throw new NullPointerException("Выбор файла был отменен, выберите снова");
            }
        }
    }
    public String openMFile() {
        fileChooserM.setDialogTitle("Выберите файл формата .m");
        fileChooserM.setFileSelectionMode(JFileChooser.FILES_ONLY);
        while (true) {
            int result = fileChooserM.showOpenDialog(Jfilechooser.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooserM.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".m")) {
                    JOptionPane.showMessageDialog(null, "Выбранный файл не является файлом формата .m", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    continue; // Вернуться к выбору файла
                }
                JOptionPane.showMessageDialog(null, selectedFile);
                return fileChooserM.getSelectedFile().getAbsolutePath();
            } else {
                throw new NullPointerException("Выбор файла был отменен, выберите снова");
            }
        }
    }
}