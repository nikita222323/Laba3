package readers;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.Reactor;
import reactor.ReactorHolder;

import java.io.File;
import java.io.IOException;

public abstract class FileReader implements IReader{

    FileReader next;

    public void setNextReader(FileReader next) {
        this.next = next;
    }

    public abstract void readFile(File file, ReactorHolder reactorMap) throws IOException;

    public Reactor parseReactor(JsonNode reactorNode, String fileType) {
        String reactorClass = reactorNode.has("classType") ? reactorNode.get("classType").asText() : null;
        double burnup = reactorNode.has("burnup") ? reactorNode.get("burnup").asDouble() : 0.0;
        double electricalCapacity = reactorNode.has("electricalCapacity") ? reactorNode.get("electricalCapacity").asDouble() : 0.0;
        double enrichment = reactorNode.has("enrichment") ? reactorNode.get("enrichment").asDouble() : 0.0;
        double firstLoad = reactorNode.has("firstLoad") ? reactorNode.get("firstLoad").asDouble() : 0.0;
        double kpd = reactorNode.has("kpd") ? reactorNode.get("kpd").asDouble() : 0.0;
        int lifeTime = reactorNode.has("lifetime") ? reactorNode.get("lifetime").asInt() : 0;
        double thermalCapacity = reactorNode.has("thermalCapacity") ? reactorNode.get("thermalCapacity").asDouble() : 0.0;

        return new Reactor(reactorClass, burnup, electricalCapacity, enrichment, firstLoad, kpd, lifeTime, thermalCapacity, fileType);
    }
}