package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.TemperatureModel;
import model.Temperature;
import view.TableRowData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DetailsViewModel implements PropertyChangeListener
{
  private TemperatureModel model;
  private ObservableList<TableRowData> table;

  public DetailsViewModel(TemperatureModel model)
  {
    this.model = model;
    table = createList();
    this.model.addListener("temperature",this);
  }
  private synchronized ObservableList<TableRowData> createList()
  {
    ObservableList<TableRowData> obsList = FXCollections.observableArrayList();

    ArrayList<Temperature> temp = new ArrayList<>();
    for (int i = 0; i < model.getAllTemp().size(); i++)
    {
      temp.add(model.getAllTemp().get(i));
    }
    for (int i = 0; i < temp.size(); i++)
    {
      obsList.add(new TableRowData(temp.get(i)));
    }
    return obsList;
  }

  public ObservableList<TableRowData> getTable()
  {
    return table;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(()->{
      switch (evt.getPropertyName()){
        case "temperature" :
          addToTheList((Temperature)evt.getNewValue()); break;
        default: break;

      }
    });
  }
  private void addToTheList(Temperature temperature)
  {


      table.add(new TableRowData(temperature));

  }
}
