package mediator;

import external.Thermometer;
import model.Heater;
import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements  TemperatureModel
{
  private PropertyChangeSupport property;
  private Heater heater;
  private TemperatureList list = new TemperatureList();
  private int highCriticalValue;
  private int lowCriticalValue;

  public TemperatureModelManager(){
    this.heater = new Heater();
    property = new PropertyChangeSupport(this);
  }


  @Override public void setCriticalValues(int highCriticalValue,int lowCriticalValue)
  {
    if(lowCriticalValue<highCriticalValue)
    {
      property.firePropertyChange("end",null,0);
      this.highCriticalValue = highCriticalValue;
      this.lowCriticalValue = lowCriticalValue;

    }
  }

  public int getHighCriticalValue()
  {
    return highCriticalValue;
  }

  public int getLowCriticalValue()
  {
    return lowCriticalValue;
  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature(id);
    this.list.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      property.firePropertyChange("temperature", old, temperature);
    }
  }

  public synchronized  Temperature getLastInsertedTemperature(String id)
  {
    return list.getLastTemperature(id);
  }

  @Override public void turnUpHeather()
  {

    property.firePropertyChange("power",position(),position()+1);
    heater.upClick();
  }

  @Override public void turnDownHeather()
  {
    property.firePropertyChange("power",position(),position()-1);
    heater.downClick();

  }
  public int position()
  {
    return  heater.position();
  }

  @Override public void checkTemp()
  {
    if(getLastInsertedTemperature())
  }

  @Override public Heater getHeather()
  {
    return heater;
  }


  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(propertyName,listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(propertyName,listener);
  }
}
