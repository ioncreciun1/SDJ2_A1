package view;

import external.Thermometer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Temperature;

public class TableRowData
{
  private StringProperty thermometerName;
  private DoubleProperty temperature;
  private StringProperty time;
  public TableRowData(Temperature thermometer)
  {
    this.thermometerName = new SimpleStringProperty(thermometer.getId());
    this.temperature = new SimpleDoubleProperty(thermometer.getValue());
    this.time = new SimpleStringProperty(thermometer.getTime().getTimestamp());
  }

  public StringProperty timeProperty()
  {
    return time;
  }

  public StringProperty thermometerNameProperty()
  {
    return thermometerName;
  }

  public DoubleProperty temperatureProperty()
  {
    return temperature;
  }
  public Temperature getTemperature()
  {
    return new Temperature(thermometerName.get(),temperatureProperty().get());
  }
}
