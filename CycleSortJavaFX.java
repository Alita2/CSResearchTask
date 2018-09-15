package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

public class CycleSortJavaFX extends Application {
        @Override
        public void start(Stage stage) throws Exception {

            SplitPane splitPane = new SplitPane();
            TabPane tabPane = new TabPane();
            Tab tab1 = new Tab("History");
            Tab tab2 = new Tab("Algo");
            Tab tab3 = new Tab("Code");
            Tab tab4 = new Tab("Stability");
            Tab tab5 = new Tab("Complexity");
            tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);
            AnchorPane anchorPane = new AnchorPane();
            splitPane.getItems().addAll(anchorPane,tabPane);
            Scene scene = new Scene(splitPane);
            stage.setWidth(1100);
            stage.setHeight(600);
            //stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Simple JavaFX Program");
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

