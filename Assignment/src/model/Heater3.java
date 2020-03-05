package model;

public class Heater3 extends HeaterState
{
  private Thread time;
  private boolean complete;

   public Heater3(Heater heater)
  {
    complete = false;

    time = new Thread(() -> {
      try
      {
        Thread.sleep(30000);
        timeout(heater);
      }
      catch (InterruptedException e)
      {
        System.out.println("Can`t to it is max power");
      }
    });
    time.start();
  }

  private void timeout(Heater heater)
  {
    if(!complete)
    {
      heater.setState(new Heater2());
      complete = true;
    }
  }

  @Override public void downClick(Heater heater)
  {
    if(!complete)
    {
      time.interrupt();
      heater.setState(new Heater2());
      complete = true;
    }
  }

  @Override public int position()
  {
    return 3;
  }
}
