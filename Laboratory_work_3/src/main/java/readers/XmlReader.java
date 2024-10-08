package readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import reactor.Reactor;
import reactor.ReactorHolder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class XmlReader extends FileReader{

    ReactorHolder reactorHolder;
    Boolean check = false;

    @Override
    public void readFile(File file, ReactorHolder reactorMap) throws IOException {
        reactorHolder = reactorMap;
        if (file.getName().endsWith(".xml")) {
            check = true;
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode rootNode = xmlMapper.readTree(file);

            for (Iterator<String> it = rootNode.fieldNames(); it.hasNext(); ) {
                String fieldName = it.next();
                JsonNode reactorNode = rootNode.get(fieldName);
                if (reactorNode != null && reactorNode.isObject()) {
                    Reactor reactorType = parseReactor(reactorNode, "XML");
                    reactorMap.addReactor(fieldName, reactorType);
                }
            }
        } else if (next != null) {
            next.readFile(file, reactorMap);
        } else {
            System.out.println("Неподдерживаемый формат");
        }
    }

    public ReactorHolder getReactorHolder() {
        return reactorHolder;
    }

    public Boolean getCheck() {
        return check;
    }

}