package readers;

import reactor.ReactorHolder;

import java.io.File;
import java.io.IOException;

public interface IReader {

    public void setNextReader(FileReader next);
    public void readFile(File file, ReactorHolder reactorMap) throws IOException;
}