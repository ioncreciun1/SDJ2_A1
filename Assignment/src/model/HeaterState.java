package model;

public abstract class HeaterState
{
  public void upClick(Heater heater){};
  public void downClick(Heater heater){};

  public abstract int position();
}
