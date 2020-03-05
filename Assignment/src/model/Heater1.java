package model;

public class Heater1 extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater2());
  }

  @Override public void downClick(Heater heater)
  {
    heater.setState(new HeaterOff());
  }

  @Override public int position()
  {
    return 1;
  }

}
