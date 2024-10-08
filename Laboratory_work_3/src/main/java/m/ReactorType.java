package m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ReactorType {
    private String classType;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double thermalCapacity;
    private double electricalCapacity;
    private int lifetime;
    private double firstLoad;

    public ReactorType() {
    }

    public static Map<String, ReactorType> parseMContent(String mContent) {

        Map<String, ReactorType> reactorTypes = new HashMap<>();
        Pattern pattern = Pattern.compile("function params = (\\w+)[\\s\\S]*?class = '(.+?)';[\\s\\S]*?burnup = (\\d+\\.?\\d*);[\\s\\S]*?kpd = (\\d+\\.?\\d*);[\\s\\S]*?enrichment = (\\d+\\.?\\d*);[\\s\\S]*?termal_capacity = (\\d+\\.?\\d*);[\\s\\S]*?electrical_capacity = (\\d+\\.?\\d*);[\\s\\S]*?life_time = (\\d+);[\\s\\S]*?first_load = (\\d+\\.?\\d*);");
        Matcher matcher = pattern.matcher(mContent);

        while (matcher.find()) {
            ReactorType reactor = new ReactorType();
            reactor.setClassType(matcher.group(2));
            reactor.setBurnup(Double.parseDouble(matcher.group(3)));
            reactor.setKpd(Double.parseDouble(matcher.group(4)));
            reactor.setEnrichment(Double.parseDouble(matcher.group(5)));
            reactor.setThermalCapacity(Double.parseDouble(matcher.group(6)));
            reactor.setElectricalCapacity(Double.parseDouble(matcher.group(7)));
            reactor.setLifetime(Integer.parseInt(matcher.group(8)));
            reactor.setFirstLoad(Double.parseDouble(matcher.group(9)));
            reactorTypes.put(matcher.group(1), reactor);
        }
        return reactorTypes;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public double getThermalCapacity() {
        return thermalCapacity;
    }

    public void setThermalCapacity(double thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }

    public double getElectricalCapacity() {
        return electricalCapacity;
    }

    public void setElectricalCapacity(double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public double getFirstLoad() {
        return firstLoad;
    }

    public void setFirstLoad(double firstLoad) {
        this.firstLoad = firstLoad;
    }
}