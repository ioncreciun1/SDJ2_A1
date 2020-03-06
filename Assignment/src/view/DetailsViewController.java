package view;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Region;
import javafx.scene.control.*;
import viewmodel.DetailsViewModel;


public class DetailsViewController
{
  @FXML private TableView<TableRowData> temperatureListTable;
  @FXML private TableColumn<TableRowData,String> nameColumn;
  @FXML private TableColumn<TableRowData,Number> temperatureColumn;
  @FXML private TableColumn<TableRowData,String> timeColumn;


  private Region root;
  private DetailsViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, DetailsViewModel viewModel, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().thermometerNameProperty()
    );
    temperatureColumn.setCellValueFactory(
        cellData -> cellData.getValue().temperatureProperty()
    );
    timeColumn.setCellValueFactory(
        cellData -> cellData.getValue().timeProperty()
    );
    System.out.println();
    temperatureListTable.setItems(viewModel.getTable());
    System.out.println(viewModel.getTable().get(1).getTemperature().getValue());
    System.out.println(viewModel.getTable().get(2).getTemperature().getValue());
  }

  public void reset()
  {
//    viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void cancel()
  {
    viewHandler.openView("thermometer");
  }
}
