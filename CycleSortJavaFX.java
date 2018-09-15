package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
            TextArea textArea1 = new TextArea("1");
            TextArea textArea2 = new TextArea("2");
            TextArea textArea3 = new TextArea("3");
            TextArea textArea4 = new TextArea("4");
            TextArea textArea5 = new TextArea("5");
            textArea1.setEditable(false);
            textArea2.setEditable(false);
            textArea3.setEditable(false);
            textArea4.setEditable(false);
            textArea5.setEditable(false);
            tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
                @Override
                public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
                    TableView tableview = new TableView();
                    if (newTab == tab1) {
                        tab1.setContent(textArea1);
                    }
                    else if(newTab==tab2){
                        tab2.setContent(textArea2);
                    }
                    else if(newTab==tab3){
                        tab3.setContent(textArea3);
                    }
                    else if(newTab==tab4){
                        tab4.setContent(textArea4);
                    }
                    else if(newTab==tab5){
                        tab5.setContent(textArea5);
                    }
                }
            });
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
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
            Node divider = splitPane.lookup(".split-pane-divider");
            if(divider!=null){
                divider.setStyle("-fx-background-color: transparent;");
            }
            splitPane.lookupAll(".split-pane-divider").stream()
                    .forEach(div ->  div.setMouseTransparent(true) );
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

