package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory modelFactory;

  private ThermometerViewController   thermometerViewController;
  private DetailsViewController detailsViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.modelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {

    this.primaryStage = primaryStage;
    openView("thermometer");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "thermometer":
        root = loadThermometerView("Thermometer.fxml");
        break;
      case "details":
        root = loadDetailsView("Details.fxml");
        break;
    }

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getMaxWidth());
    primaryStage.setHeight(root.getMaxHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadThermometerView(String fxml)
  {
    if (thermometerViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        thermometerViewController = loader.getController();
        thermometerViewController.init(this, modelFactory.getThermometerViewModel(), root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
     else
    {
      thermometerViewController.reset();
    }
     return thermometerViewController.getRoot();
  }

  private Region loadDetailsView(String fxml)
  {
    if (detailsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Region root = loader.load();
        detailsViewController = loader.getController();
        detailsViewController.init(this,modelFactory.getDetailsModel(), root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      detailsViewController.reset();
    }
    return detailsViewController.getRoot();
  }
}
