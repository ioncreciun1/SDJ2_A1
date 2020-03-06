package mediator;

import model.Heater;
import model.Temperature;
import utility.observer.subject.NamedPropertyChangeSubject;

import java.util.ArrayList;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void setCriticalValues(int highCriticalValue,int lowCriticalValue);
  int getHighCriticalValue();
  int getLowCriticalValue();
  void addTemperature(String id,double value);
  void turnUpHeather();
  void turnDownHeather();
  Heater getHeather();
  int position();
  void addOutdoorTemp(String id,double value);
  ArrayList<Temperature> getAllTemp();
}
