package mediator;

import model.Heater;
import utility.observer.subject.NamedPropertyChangeSubject;

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
}
