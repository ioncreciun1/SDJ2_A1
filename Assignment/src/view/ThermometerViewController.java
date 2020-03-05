package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewmodel.ThermometerViewModel;

import java.awt.*;

public class ThermometerViewController
{ @FXML public TextField highValue;
  @FXML public TextField lowValue;
  @FXML private Label t1label;
  @FXML private Label t2label;
  @FXML private Label t3label;
  @FXML private Label hlabel;
  @FXML private Pane pane;


  private Region root;
  private ThermometerViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler,ThermometerViewModel viewModel,  Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    Bindings.bindBidirectional(highValue.textProperty(),viewModel.highValueProperty(),new StringIntegerConverter(50));
    Bindings.bindBidirectional(lowValue.textProperty(),viewModel.lowValueProperty(),new StringIntegerConverter(-50));
    t3label.textProperty().bindBidirectional(viewModel.outTempProperty());
    hlabel.textProperty().bindBidirectional(viewModel.heatherProperty());
    t1label.textProperty().bindBidirectional(viewModel.temp1Property());
    t2label.textProperty().bindBidirectional(viewModel.temp2Property());
   // pane.setStyle("-fx-background-color:black");

    pane.styleProperty().bindBidirectional(viewModel.styleProperty());
  }

  public void reset()
  {
//    viewModel.clear();
  }


  public Region getRoot()
  {
    return root;
  }

  @FXML public void upPressed()
  {
  viewModel.turnUp();
  }

  @FXML public void downPressed()
  {
    viewModel.turnDown();
  }

  @FXML public void details()
  {
    viewHandler.openView("details");
  }

  public void setValue(ActionEvent event)
  {
    viewModel.setCriticalValues();
  }
}
