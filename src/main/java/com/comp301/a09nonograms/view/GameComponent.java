package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Model;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class GameComponent {

  Model model;
  PuzzleLibrary puzzleLibrary;
  Controller controller;
  boolean flag;
  Button[][] button;
  GridPane gridPane;
  VBox vBox;
  HBox hBox;
  VBox totalVBox;
  HBox totalHBox;

  public GameComponent(Controller controller, Model model) {
    this.gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    this.vBox = new VBox();
    vBox.setSpacing(0);
    this.hBox = new HBox();
    this.totalHBox = new HBox();
    totalHBox.setSpacing(30);
    this.totalVBox = new VBox();
    totalVBox.setSpacing(30);
    this.model = model;
    this.controller = controller;
    this.button = new Button[300][300];
  }

  public Parent render() {
    for (int r = 0; r < controller.getClues().getWidth(); r++) {
      for (int t = 0; t < controller.getClues().getHeight(); t++) {
        button[r][t] = new Button();
        if (controller.isEliminated(t, r)) {
          button[r][t].setStyle(
              "-fx-min-width: 45px; "
                  + "-fx-min-height: 45px; "
                  + "-fx-max-width: 45px; "
                  + "-fx-max-height: 45px; "
                  + "-fx-background-color: #FF0000; ");
        } else if (controller.isShaded(t, r)) {
          button[r][t].setStyle(
              "-fx-min-width: 40px; "
                  + "-fx-min-height: 45px; "
                  + "-fx-max-width: 45px; "
                  + "-fx-max-height: 45px; "
                  + "-fx-background-color: #800080; ");
        } else {
          button[r][t].setStyle(
              "-fx-min-width: 45px; "
                  + "-fx-min-height: 45px; "
                  + "-fx-max-width: 45px; "
                  + "-fx-max-height: 45px; ");
        }
        gridPane.add(button[r][t], r + 1, t + 1);
        gridPane.setAlignment(Pos.CENTER);
      }
    }

    for (int k = 0; k < controller.getClues().getHeight(); k++) {
      HBox field = new HBox();
      int counter = 0;
      for (int y = 0; y < controller.getClues().getRowCluesLength(); y++) {
        counter = 0;
        flag = false;
        for (int j = 0; j < controller.getClues().getRowCluesLength(); j++) {
          if (controller.getClues().getRowClues(k)[j] == 0) {
            counter++;
          } else if (controller.getClues().getRowClues(k)[j] != 0) {
            flag = true;
          }
        }
        if (counter > 1) {
          if (flag) {
            if (controller.getClues().getRowClues(k)[y] == 0
                && controller.getClues().getRowClues(k)[y + 1] != 0) {
              Label label = new Label(Integer.toString(controller.getClues().getRowClues(k)[y]));
              label.setPadding(new Insets(90, 10, 0, 0));
              field.getChildren().add(label);
            } else if (controller.getClues().getRowClues(k)[y] != 0 && y != 0) {
              Label label = new Label(Integer.toString(controller.getClues().getRowClues(k)[y]));
              label.setPadding(new Insets(90, 10, 0, 0));
              field.getChildren().add(label);
            } else {
              Label label = new Label();
              label.setPadding(new Insets(90, 10, 0, 0));
              field.getChildren().add(label);
            }
          } else {
            for (int b = 0; b < controller.getClues().getRowCluesLength() - 1; b++) {
              Label label = new Label();
              label.setPadding(new Insets(90, 10, 0, 0));
              field.getChildren().add(label);
            }
            Label label = new Label(Integer.toString(controller.getClues().getRowClues(k)[y]));
            label.setPadding(new Insets(90, 10, 0, 0));
            field.getChildren().add(label);
            break;
          }
        } else {
          Label label = new Label(Integer.toString(controller.getClues().getRowClues(k)[y]));
          label.setPadding(new Insets(90, 10, 0, 0));
          field.getChildren().add(label);
        }
        flag = false;
        counter = 0;
      }
      if (controller.getClues().getColCluesLength() < controller.getClues().getRowCluesLength()) {
        field.setStyle(
            "-fx-min-height: 45px; "
                + "-fx-min-width: "
                + 15
                    * (controller.getClues().getRowCluesLength()
                        + Math.abs(
                            controller.getClues().getRowCluesLength()
                                - controller.getClues().getColCluesLength()))
                + "px; "
                + "-fx-max-height: 45px; "
                + "-fx-max-width: "
                + 15
                    * (controller.getClues().getRowCluesLength()
                        + Math.abs(
                            controller.getClues().getRowCluesLength()
                                - controller.getClues().getColCluesLength()))
                + "px; ");
        field.setAlignment(Pos.CENTER);
        gridPane.add(field, 0, k);
      } else {
        field.setStyle(
            "-fx-min-height: 45px; "
                + "-fx-min-width: "
                + 15 * (controller.getClues().getRowCluesLength())
                + "px; "
                + "-fx-max-height: 45px; "
                + "-fx-max-width: "
                + 15 * (controller.getClues().getRowCluesLength())
                + "px; ");
        field.setAlignment(Pos.CENTER);
        gridPane.add(field, 0, k);
      }
    }

    for (int k = 0; k < controller.getClues().getWidth(); k++) {
      VBox field = new VBox();
      int counter = 0;
      for (int y = 0; y < controller.getClues().getColCluesLength(); y++) {
        counter = 0;
        flag = false;
        for (int j = 0; j < controller.getClues().getColCluesLength(); j++) {
          if (controller.getClues().getColClues(k)[j] == 0) {
            counter++;
          } else if (controller.getClues().getColClues(k)[j] != 0) {
            flag = true;
          }
        }
        if (counter > 1) {
          if (flag) {
            if (controller.getClues().getColClues(k)[y] == 0
                && controller.getClues().getColClues(k)[y + 1] != 0) {
              Label label = new Label(Integer.toString(controller.getClues().getColClues(k)[y]));
              label.setAlignment(Pos.CENTER);
              label.setPadding(new Insets(0, 0, 0, 90));
              field.getChildren().add(label);
            } else if (controller.getClues().getColClues(k)[y] != 0 && y != 0) {
              Label label = new Label(Integer.toString(controller.getClues().getColClues(k)[y]));
              label.setAlignment(Pos.CENTER);
              label.setPadding(new Insets(0, 0, 0, 90));
              field.getChildren().add(label);
            } else {
              Label label = new Label();
              label.setAlignment(Pos.CENTER);
              label.setPadding(new Insets(0, 0, 0, 90));
              field.getChildren().add(label);
            }
          } else {
            for (int b = 0; b < controller.getClues().getColCluesLength() - 1; b++) {
              Label label = new Label();
              label.setAlignment(Pos.CENTER);
              label.setPadding(new Insets(0, 0, 0, 90));
              field.getChildren().add(label);
            }
            Label label = new Label(Integer.toString(controller.getClues().getColClues(k)[y]));
            label.setPadding(new Insets(0, 0, 0, 90));
            label.setAlignment(Pos.CENTER);
            field.getChildren().add(label);
            break;
          }
        } else {
          Label label = new Label(Integer.toString(controller.getClues().getColClues(k)[y]));
          label.setPadding(new Insets(0, 0, 0, 90));
          label.setAlignment(Pos.CENTER);

          field.getChildren().add(label);
        }
        flag = false;
        counter = 0;
      }
      if (controller.getClues().getColCluesLength() < controller.getClues().getRowCluesLength()) {
        field.setStyle(
            "-fx-min-width: 45px; "
                + "-fx-min-height: "
                + 15
                    * (controller.getClues().getColCluesLength()
                        - Math.abs(
                            controller.getClues().getRowCluesLength()
                                - controller.getClues().getColCluesLength()))
                + "px; "
                + "-fx-max-width: 45px; "
                + "-fx-max-height: "
                + 15
                    * (controller.getClues().getColCluesLength()
                        - Math.abs(
                            controller.getClues().getRowCluesLength()
                                - controller.getClues().getColCluesLength()))
                + "px; ");
        field.setAlignment(Pos.CENTER);
        field.setAlignment(Pos.CENTER);
        gridPane.add(field, k, 0);
      } else {
        field.setStyle(
            "-fx-min-width: 45px; "
                + "-fx-min-height: "
                + 15 * (controller.getClues().getColCluesLength())
                + "px; "
                + "-fx-max-width: 45px; "
                + "-fx-max-height: "
                + 15 * (controller.getClues().getColCluesLength())
                + "px; ");
        field.setAlignment(Pos.CENTER);
        field.setAlignment(Pos.CENTER);
        gridPane.add(field, k, 0);
      }
    }

    int i = 0;
    int k = 0;
    while (i < controller.getClues().getWidth()) {
      while (k < controller.getClues().getHeight()) {
        int finalK = k;
        int finalI = i;
        button[finalI][finalK].addEventFilter(
            MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                  controller.toggleEliminated(finalK, finalI);
                } else if (event.getButton() == MouseButton.PRIMARY) {
                  controller.toggleShaded(finalK, finalI);
                }
              }
            });
        model.addObserver(
            (Model m) -> {
              button[finalI][finalK].getOnAction();
            });
        k++;
      }
      k = 0;
      i++;
    }

    GridPane totalGridPane = new GridPane();
    totalGridPane.setPadding(new Insets(10, 10, 10, 10));
    totalGridPane.setVgap(10);
    totalGridPane.setHgap(10);
    totalGridPane.setAlignment(Pos.CENTER);
    totalGridPane.addRow(0, hBox);
    totalGridPane.addColumn(1, gridPane);
    totalGridPane.addColumn(0, vBox);
    return gridPane;
  }
}
