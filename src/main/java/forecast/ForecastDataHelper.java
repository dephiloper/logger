package forecast;

import javafx.beans.property.*;
import javafx.scene.image.Image;

class ForecastDataHelper {
    private DoubleProperty temperature = new SimpleDoubleProperty();
    private DoubleProperty windSpeed = new SimpleDoubleProperty();
    private DoubleProperty cloudCover = new SimpleDoubleProperty();
    private StringProperty summary = new SimpleStringProperty();
    private StringProperty precipType = new SimpleStringProperty();
    private DoubleProperty humidity = new SimpleDoubleProperty();
    private StringProperty timeZone = new SimpleStringProperty();
    private ObjectProperty<Image> icon = new SimpleObjectProperty<>();
    private StringProperty futureSummary = new SimpleStringProperty();

    ForecastDataHelper() {
    }

    ForecastDataHelper(double temperature, double windSpeed, double cloudCover, String summary, String precipType, double humidity, String timeZone, Image icon, String futureSummary) {
        reinitialize(temperature, windSpeed, cloudCover, summary, precipType, humidity, timeZone, icon, futureSummary);
    }

    void reinitialize(double temperature, double windSpeed, double cloudCover, String summary, String precipType, double humidity, String timeZone, Image icon, String futureSummary) {
        this.temperature.setValue(temperature);
        this.windSpeed.setValue(windSpeed);
        this.cloudCover.setValue(cloudCover);
        this.summary.setValue(summary);
        this.precipType.setValue(precipType);
        this.humidity.setValue(humidity);
        this.timeZone.setValue(timeZone);
        this.icon.setValue(icon);
        this.futureSummary.setValue(futureSummary);
    }

    void reinitialize(ForecastDataHelper dataHelper) {
        this.temperature.setValue(dataHelper.temperature.getValue());
        this.windSpeed.setValue(dataHelper.windSpeed.getValue());
        this.cloudCover.setValue(dataHelper.cloudCover.getValue());
        this.summary.setValue(dataHelper.summary.getValue());
        this.precipType.setValue(dataHelper.precipType.getValue());
        this.humidity.setValue(dataHelper.humidity.getValue());
        this.timeZone.setValue(dataHelper.timeZone.getValue());
        this.icon.setValue(dataHelper.icon.getValue());
        this.futureSummary.setValue(dataHelper.futureSummary.getValue());

    }

    double getTemperature() {
        return temperature.get();
    }

    DoubleProperty temperatureProperty() {
        return temperature;
    }

    double getWindSpeed() {
        return windSpeed.get() * 3.6;
    }

    DoubleProperty windSpeedProperty() {
        return windSpeed;
    }

    DoubleProperty cloudCoverProperty() {
            return cloudCover;
        }

    double getCloudCover() {
        return cloudCover.get() * 100;
    }

    String getSummary() {
        return summary.get();
    }

    StringProperty summaryProperty() {
        return summary;
    }

    ObjectProperty<Image> iconProperty() {
            return icon;
        }

    String getPrecipType() {
        return precipType.get();
    }

    double getHumidity() {
        return humidity.get() * 100;
    }

    DoubleProperty humidityProperty() {
        return humidity;
    }

    String getTimeZone() {
        return timeZone.get();
    }

    StringProperty timeZoneProperty() {
        return timeZone;
    }

    StringProperty futureSummaryProperty() {
            return futureSummary;
    }

    String getFutureSummary() {
        return futureSummary.get();
    }

    Image getIcon() { return icon.get(); }
}
