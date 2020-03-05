package model;

public class Heater
{
  private HeaterState state;

  public Heater()
  {
    state = new HeaterOff();
  }

  public void upClick()
  {
    state.upClick(this);
  }

  public void downClick()
  {
    state.downClick(this);
  }

  public void setState(HeaterState state)
  {
    this.state = state;
  }

  public int position(){
    return state.position();
  }
}
