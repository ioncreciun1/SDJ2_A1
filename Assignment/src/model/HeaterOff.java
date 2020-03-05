package model;

public class HeaterOff extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater1());
  }

  @Override public int position()
  {
    return 0;
  }
}
