package reactor;

public class Reactor {
    private String fileType;
    private String reactorClass;
    private Double burnup;
    private Double electricalCapacity;
    private Double enrichment;
    private Double firstLoad;
    private Double kpd;
    private Integer lifeTime;
    private Double thermalCapacity;

    public Reactor(String reactorClass, Double burnup, Double electricalCapacity, Double enrichment, Double firstLoad, Double kpd, Integer lifeTime, Double thermalCapacity, String fileType) {
        this.reactorClass = reactorClass;
        this.burnup = burnup;
        this.electricalCapacity = electricalCapacity;
        this.enrichment = enrichment;
        this.firstLoad = firstLoad;
        this.kpd = kpd;
        this.lifeTime = lifeTime;
        this.thermalCapacity = thermalCapacity;
        this.fileType = fileType;
    }
    public String getReactorClass() {
        return reactorClass;
    }

    public Double getBurnup() {
        return burnup;
    }

    public Double getElectricalCapacity() {
        return electricalCapacity;
    }

    public Double getEnrichment() {
        return enrichment;
    }

    public Double getFirstLoad() {
        return firstLoad;
    }

    public Double getKpd() {
        return kpd;
    }

    public Integer getLifeTime() {
        return lifeTime;
    }

    public Double getThermalCapacity() {
        return thermalCapacity;
    }

    public String getFileType() {
        return fileType;
    }

    public String toString() {
        return  "   Класс реактора " + reactorClass  + "\n" +
                "   Выгорание " + burnup + "\n" +
                "   Электрическая мощность " + electricalCapacity + "\n" +
                "   Обогащение " + enrichment + "\n" +
                "   Первая загрузка " + firstLoad + "\n" +
                "   КПД " + kpd + "\n" +
                "   Продолжительность жизни " + lifeTime + "\n" +
                "   Теплоемкость " + thermalCapacity + "\n" +
                "   Тип файла: " + fileType;
    }
}