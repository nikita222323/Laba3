package readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.Reactor;
import reactor.ReactorHolder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class JsonReader extends FileReader{

    ReactorHolder reactorHolder;
    Boolean check = false;

    @Override
    public void readFile(File file, ReactorHolder reactorMap) throws IOException {
        reactorHolder = reactorMap;
        if (file.getName().endsWith(".json")) {
            check = true;
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);

            for (Iterator<String> it = rootNode.fieldNames(); it.hasNext(); ) {
                System.out.println("6");
                String fieldName = it.next();
                JsonNode reactorNode = rootNode.get(fieldName);
                if (reactorNode != null && reactorNode.isObject()) {
                    Reactor reactorType = parseReactor(reactorNode, "JSON");
                    reactorHolder.addReactor(fieldName, reactorType);
                    System.out.println("1" + reactorType);
                }
            }
            System.out.println(reactorHolder.getReactorHashMap());
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