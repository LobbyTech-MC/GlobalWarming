package me.poma123.globalwarming.api;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This enum holds the different scales of temperature.
 *
 * @author poma123
 */
public enum TemperatureType {

    CELSIUS("摄氏度", "°C"),
    FAHRENHEIT("华氏度", "°F"),
    KELVIN("开尔文", "K");

    private final String name;
    private final String suffix;

    @ParametersAreNonnullByDefault
    TemperatureType(String name, String suffix) {
        this.name = name;
        this.suffix = suffix;
    }

    public String getName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
