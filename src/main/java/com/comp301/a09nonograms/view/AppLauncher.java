package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import com.comp301.a09nonograms.model.ModelObserver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    PuzzleLibrary puzzleLibrary = new PuzzleLibrary();
    Model model = new ModelImpl(puzzleLibrary.create());
    Controller controller = new ControllerImpl(model);
    TotalView totalView = new TotalView(controller, model);
    Scene scene = new Scene(totalView.render());
    stage.setScene(scene);
    stage.setFullScreen(true);
    model.addObserver(
        (Model m) -> {
          scene.setRoot(totalView.render());
          stage.sizeToScene();
        });
    stage.setTitle("Nonograms");
    stage.show();
  }
}
