package com.company;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
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
            BorderPane borderPane = new BorderPane();
            CycleSortPane cycleSortPane= new CycleSortPane();
            HBox hBox = new HBox();
            Button previous = new Button("<");
            int buttonWidth= (int) Screen.getPrimary().getVisualBounds().getWidth()/25;
            int buttonHeight = (int) Screen.getPrimary().getVisualBounds().getHeight()/15;
            previous.setMinSize(buttonWidth, buttonHeight);
            previous.setPrefSize(buttonWidth, buttonHeight);
            previous.setMaxSize(buttonWidth, buttonHeight);
            previous.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            Button next = new Button(">");
            next.setMinSize(buttonWidth, buttonHeight);
            next.setPrefSize(buttonWidth, buttonHeight);
            next.setMaxSize(buttonWidth, buttonHeight);
            next.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            Button play = new Button("Play");
            play.setMinSize(buttonWidth*1.5, buttonHeight);
            play.setPrefSize(buttonWidth*1.5, buttonHeight);
            play.setMaxSize(buttonWidth*1.5, buttonHeight);
            play.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            Button random = new Button("Random");
            random.setMinSize(buttonWidth*2, buttonHeight);
            random.setPrefSize(buttonWidth*2, buttonHeight);
            random.setMaxSize(buttonWidth*2, buttonHeight);
            random.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            play.setOnAction(e -> {
                try {
                    cycleSortPane.play(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            });
            random.setOnAction(e -> {
                Integer[] a = new Integer[9];
                Random rand = new Random();
               for(int i=0;i<9;i++){
                   a[i]=rand.nextInt(999);
               }
               cycleSortPane.set(a);
               cycleSortPane.show(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
            });
            hBox.setSpacing(20);
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(previous,next,play,random);
            hBox.setPadding(new Insets(15, 12, 15, 12));
            Integer x[]= {45, 65, 37, 18, 7, 90, 58, 96, 70 };
            cycleSortPane.set(x);
            borderPane.setCenter(cycleSortPane);
            borderPane.setBottom(hBox);
            splitPane.getItems().addAll(borderPane,tabPane);
            Scene scene = new Scene(splitPane);
            stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth()/1.3);
            stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight()/1.3);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Simple JavaFX Program");
            stage.show();
         /*   Node divider = splitPane.lookup(".split-pane-divider");
            if(divider!=null){
                divider.setStyle("-fx-background-color: transparent;");
            }
            splitPane.lookupAll(".split-pane-divider").stream()
                    .forEach(div ->  div.setMouseTransparent(true) );
                    */
            cycleSortPane.show(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

