package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import com.comp301.a09nonograms.model.ModelObserver;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class BottomButtonComponent implements FXComponent {

  PuzzleLibrary puzzleLibrary;
  Model model;
  Controller controller;

  public BottomButtonComponent(Controller controller, Model model) {
    this.model = model;
    this.controller = controller;
  }

  public Parent render() {
    VBox vbox = new VBox();
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();
    Button buttonRandom = new Button("Random");
    buttonRandom.setStyle(
        "-fx-min-width: 30px; "
            + "-fx-min-height: 30px; "
            + "-fx-min-width: 80px;"
            + "-fx-max-width: 80px; "
            + "-fx-max-height: 30px; "
            + "-fx-background-color: #FF0000;");
    buttonRandom.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });
    Button buttonNext = new Button("Next");
    buttonNext.setOnAction(
        (event) -> {
          controller.nextPuzzle();
        });
    model.addObserver(
        (Model m) -> {
          buttonNext.getOnAction();
        });
    buttonNext.setStyle(
        "-fx-min-width: 30px; "
            + "-fx-min-height: 30px; "
            + "-fx-min-width: 80px;"
            + "-fx-max-width: 80px; "
            + "-fx-max-height: 30px; "
            + "-fx-background-color: #FF0000;");
    Button buttonPrevious = new Button("Previous");
    buttonPrevious.setOnAction(
        (event) -> {
          controller.prevPuzzle();
        });
    model.addObserver(
        (Model m) -> {
          buttonPrevious.getOnAction();
        });
    buttonPrevious.setStyle(
        "-fx-min-width: 30px; "
            + "-fx-min-height: 30px; "
            + "-fx-min-width: 80px;"
            + "-fx-max-width: 80px; "
            + "-fx-max-height: 30px; "
            + "-fx-background-color: #FF0000;");
    hBox2.setSpacing(20);
    Button buttonReset = new Button("Reset");
    buttonReset.addEventFilter(
        MouseEvent.MOUSE_CLICKED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            controller.clearBoard();
          }
        });
    model.addObserver((Model m) -> {
          buttonReset.getOnAction();
        });
    buttonReset.setStyle(
        "-fx-min-width: 30px; "
            + "-fx-min-height: 30px; "
            + "-fx-min-width: 80px;"
            + "-fx-max-width: 80px;"
            + "-fx-max-height: 30px; "
            + "-fx-background-color: #FF0000;");
    hBox2.getChildren().add(buttonPrevious);
    hBox2.getChildren().add(buttonRandom);
    hBox2.getChildren().add(buttonNext);

    hBox1.getChildren().add(buttonReset);
    hBox1.setAlignment(Pos.CENTER_RIGHT);
    hBox2.setAlignment(Pos.CENTER);
    vbox.getChildren().add(hBox1);
    vbox.getChildren().add(hBox2);
    vbox.setAlignment(Pos.CENTER);
    return vbox;
  }
}
