package viewmodel;

import mediator.TemperatureModel;

public class ViewModelFactory
{
  private ThermometerViewModel thermometerViewModel;
  private DetailsViewModel detailsViewModel;
  public ViewModelFactory(TemperatureModel model)
  {
    thermometerViewModel = new ThermometerViewModel(model);
    detailsViewModel = new DetailsViewModel();
  }

  public ThermometerViewModel getThermometerViewModel()
  {
    return  thermometerViewModel;
  }

  public DetailsViewModel getDetailsModel()
  {
    return  detailsViewModel;
  }
}
