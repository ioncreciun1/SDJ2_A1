package model;

public class Heater2 extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater3(heater));
  }

  @Override public void downClick(Heater heater)
  {
    heater.setState(new Heater1());
  }

  @Override public int position()
  {
    return 2;
  }

}
