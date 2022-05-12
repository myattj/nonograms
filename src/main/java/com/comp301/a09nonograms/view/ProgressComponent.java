package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProgressComponent implements FXComponent {
  Model model;
  PuzzleLibrary puzzleLibrary;
  Controller controller;

  public ProgressComponent(Controller controller, Model model) {
    this.model = model;
    this.controller = controller;
  }

  public Parent render() {
    HBox hbox = new HBox();
    Label label =
        new Label(
            "Puzzle " + (controller.getPuzzleIndex() + 1) + " of " + (controller.getPuzzleCount()));
    hbox.getChildren().add(label);
    hbox.setAlignment(Pos.CENTER);
    return hbox;
  }
}
