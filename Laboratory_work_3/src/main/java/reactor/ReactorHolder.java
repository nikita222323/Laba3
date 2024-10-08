package reactor;

import java.util.HashMap;

public class ReactorHolder {

    private HashMap<String, Reactor> reactorHashMap;

    public ReactorHolder() {
        this.reactorHashMap = new HashMap<>();
    }

    public void addReactor(String key, Reactor reactor) {
        reactorHashMap.put(key, reactor);
    }

    public HashMap<String, Reactor> getReactorHashMap() {
        return reactorHashMap;
    }
}