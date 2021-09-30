package it.unimore.playground.design;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2021 - 11:56
 */
public class MobileDevice extends MyDevice {

    public static final String ENGINE_TYPE_ELECTRIC = "engine_type_electric";

    public static final String ENGINE_TYPE_GASOLINE = "engine_type_gasoline";

    public static final String ENGINE_TYPE_DIESEL = "engine_type_diesel";

    public static final String DEFAULT_EMISSION_UNIT = "mg/h";

    private String engineType;

    private double emissionLevel;

    private String emissionUnit;

    public MobileDevice(String engineType, double emissionLevel, String emissionUnit) {
        this.engineType = engineType;
        this.emissionLevel = emissionLevel;
        this.emissionUnit = emissionUnit;
    }

    public MobileDevice(String id, String type, String manufacturer, String softwareVersion, String engineType, double emissionLevel, String emissionUnit) {
        super(id, type, manufacturer, softwareVersion);
        this.engineType = engineType;
        this.emissionLevel = emissionLevel;
        this.emissionUnit = emissionUnit;
    }

    public MobileDevice(String id, String type, String manufacturer, String softwareVersion, GeoLocation location, String engineType, double emissionLevel, String emissionUnit) {
        super(id, type, manufacturer, softwareVersion, location);
        this.engineType = engineType;
        this.emissionLevel = emissionLevel;
        this.emissionUnit = emissionUnit;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEmissionLevel() {
        return emissionLevel;
    }

    public void setEmissionLevel(double emissionLevel) {
        this.emissionLevel = emissionLevel;
    }

    public String getEmissionUnit() {
        return emissionUnit;
    }

    public void setEmissionUnit(String emissionUnit) {
        this.emissionUnit = emissionUnit;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MobileDevice{");
        sb.append("engineType='").append(engineType).append('\'');
        sb.append(", emissionLevel=").append(emissionLevel);
        sb.append(", emissionUnit='").append(emissionUnit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
