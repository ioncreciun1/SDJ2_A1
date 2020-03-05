package view;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Region;
import viewmodel.DetailsViewModel;

public class DetailsViewController
{
  @FXML private LineChart TemperatureChart;
  @FXML private CategoryAxis TemperatureChartX;
  @FXML private NumberAxis TemperatureChartY;

  private Region root;
  private DetailsViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, DetailsViewModel viewModel, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
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
