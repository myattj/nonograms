package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class SuccessView implements FXComponent {
  Model model;
  PuzzleLibrary puzzleLibrary;
  Controller controller;

  public SuccessView(Controller controller, Model model) {
    this.model = model;
    this.controller = controller;
  }

  public Parent render() {
    Label label = new Label("You successfully completed the puzzle!");
    label.setStyle("-fx-background-color: #00FF00;");
    label.setPrefWidth(700);
    label.setPrefHeight(15);
    label.setAlignment(Pos.CENTER);
    return label;
  }
}
