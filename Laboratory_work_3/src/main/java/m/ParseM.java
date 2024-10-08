package m;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ParseM {

    private String path;
    private ReactorType reactorType = new ReactorType();

    public ParseM(String path) {
        this.path = path;

        String mContent = readMFileContent();
        Map<String, ReactorType> reactorTypes = reactorType.parseMContent(mContent);
        convertToJson(reactorTypes);
        convertToXml(reactorTypes);
        convertToYaml(reactorTypes);
        System.out.println();
    }

    private String readMFileContent() {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private void convertToJson(Map<String, ReactorType> reactorTypes) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String json = objectMapper.writeValueAsString(reactorTypes);
            writeToFile("output.json", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertToXml(Map<String, ReactorType> reactorTypes) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String xml = xmlMapper.writeValueAsString(reactorTypes);
            writeToFile("output.xml", xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertToYaml(Map<String, ReactorType> reactorTypes) {
        YAMLMapper yamlMapper = new YAMLMapper();

        try {
            String yaml = yamlMapper.writeValueAsString(reactorTypes);
            writeToFile("output.yaml", yaml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(new File(fileName));
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}