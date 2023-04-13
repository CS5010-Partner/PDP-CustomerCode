package view;

public interface IViewUI {

  void show();

  String[] fileChooser(int count);

  void changeImageType();

  String popUpInput();

  String greyChooser();

  boolean splitChooser();

  boolean combineChooser();

  String savePath();

  void setBrightException();
}
