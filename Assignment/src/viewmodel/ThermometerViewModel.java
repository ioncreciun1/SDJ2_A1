package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  private TemperatureModel model;
  private StringProperty error;
  private StringProperty temp1;
  private StringProperty temp2;
  private StringProperty outTemp;
  private IntegerProperty highValue;
  private IntegerProperty lowValue;
  private StringProperty style;
  private boolean end = false;

  private  StringProperty heather;

  public ThermometerViewModel(TemperatureModel model){
    this.model= model;
    this.outTemp = new SimpleStringProperty("0");
    this.heather = new SimpleStringProperty("0");
    this.error = new SimpleStringProperty();
    this.temp1 = new SimpleStringProperty();
    this.temp2 = new SimpleStringProperty();
    this.highValue = new SimpleIntegerProperty(20);
    this.lowValue = new SimpleIntegerProperty(10);
    this.style = new SimpleStringProperty();

    model.addListener("temperature",this);
    model.addListener("power", this);
    model.addListener("outTemp",this);
    model.addListener("end",this);
  }

  public void turnUp()
  {
    model.turnUpHeather();
  }
  public void turnDown()
  {
    model.turnDownHeather();
  }
  public int getPower()
  {
    return model.position();
  }


  public void setCriticalValues()
  {
      model.setCriticalValues(highValue.get(),lowValue.get());
  }


  public IntegerProperty highValueProperty()
  {
    return highValue;
  }

  public IntegerProperty lowValueProperty()
  {
    return lowValue;
  }

  public StringProperty heatherProperty()
  {
    return heather;
  }

  public StringProperty styleProperty()
  {
    return style;
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void clear()
  {
  }

  public StringProperty outTempProperty()
  {
    return outTemp;
  }

  public StringProperty temp1Property()
  {
    return temp1;
  }

  public StringProperty temp2Property()
  {
    return temp2;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(()->{

      switch (evt.getPropertyName())
      {
        case "temperature" :
          Temperature temp = (Temperature)evt.getNewValue();

       if(!temp.getId().equals("t3") && temp1.get()!=null && temp2.get()!=null)
       {
         if ( (Double.parseDouble(temp1.get())> highValue.get() || Double.parseDouble(temp1.get()) < lowValue.get())
         ||( Double.parseDouble(temp2.get()) > highValue.get() || Double.parseDouble(temp2.get()) < lowValue.get()))

         {

           style.set("-fx-background-color:red");
         }
         else
         {
           style.set("-fx-background-color: rgba(148,148,148,0.50) 100%");
         }
       }
          switch (temp.getId())
          {
            case "t1" : temp1.set(Double.toString(temp.getValue())); break;
            case "t2" : temp2.set(temp.getValue() + ""); break;
            case "t3" : outTemp.set(temp.getValue() + ""); break;
          }
        case "power" :
          heather.set(model.position() + ""); break;
        case "end" :
            style.set("-fx-background-color:red");
      }
    });
  }
}
