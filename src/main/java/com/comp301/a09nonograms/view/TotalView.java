package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Model;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.*;

public class TotalView implements FXComponent {

  private Controller controller;
  private Model model;

  public TotalView(Controller controller, Model model) {
    this.controller = controller;
    this.model = model;
  }

  public Parent render() {
    BottomButtonComponent bottomButtonComponent = new BottomButtonComponent(controller, model);
    GameComponent gameComponent = new GameComponent(controller, model);
    ProgressComponent progressComponent = new ProgressComponent(controller, model);
    SuccessView successView = new SuccessView(controller, model);
    BorderPane borderPane = new BorderPane();
    borderPane.setBottom(bottomButtonComponent.render());
    borderPane.setTop(progressComponent.render());
    borderPane.setCenter(gameComponent.render());
    if (controller.isSolved()) {
      borderPane.setTop(successView.render());
    }
    return borderPane;
  }
}
