
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Random;

public class CycleSortJavaFX extends Application {
    static Button previous,next,play,random;
        @Override
        public void start(Stage stage) throws Exception {

            SplitPane splitPane = new SplitPane();
            TabPane tabPane = new TabPane();
            Tab tab1 = new Tab("History");
            Tab tab2 = new Tab("Algo");
            Tab tab3 = new Tab("Code");
            Tab tab4 = new Tab("Stability");
            Tab tab5 = new Tab("Complexity");
            TextArea textArea1 = new TextArea("In 1990, B.K Haddon introduced two sorting algorithms in a 3-page paper, the General Cycle Sort and the Special Cycle sort. These algorithms were meant to be used in specialized situations where it does an in-place sort in linear time, while ensuring that each element only moves at maximum, once. It is used in memory storage algorithms where minimising number of writes is important. (e.g. flash memory)");
            textArea1.setWrapText(true);
            TextArea textArea2 = new TextArea("Starting from the element at index zero, \r\n" + 
            		"1) Determine the correct index of the element.\r\n" + 
            		"2) Go to that index and check if the old element is the same as the new element. For duplicate values, check if all the indexes of the duplicated element are the same as the new element. If they are different, \r\n" + 
            		"3) Replace the old element with the new element. Repeat step 1 with the old element.\r\n" + 
            		"4) Else, continue from index zero to index one and so on, until the end of the array is reached.\r\n" + 
            		"");
            textArea2.setWrapText(true);
            TextArea textArea3 = new TextArea("public class CycleSort {\r\n" + 
            		"   public static void sort(int array[]){\r\n" + 
            		"       int count = 0;\r\n" + 
            		"       for(int start=0;start<array.length-1;start++){\r\n" + 
            		"           int curr = array[start];\r\n" + 
            		"           int smaller = start;\r\n" + 
            		"           for (int i=start+1;i<array.length;i++){\r\n" + 
            		"               if (array[i]<curr) {\r\n" + 
            		"                   smaller++;\r\n" + 
            		"               }\r\n" + 
            		"           }\r\n" + 
            		"           if(smaller==start){\r\n" + 
            		"               continue;\r\n" + 
            		"           }\r\n" + 
            		"           while(curr==array[smaller]){\r\n" + 
            		"               smaller++;\r\n" + 
            		"           }\r\n" + 
            		"           if(smaller!=start){\r\n" + 
            		"               int temp = curr;\r\n" + 
            		"               curr=array[smaller];\r\n" + 
            		"               array[smaller]=temp;\r\n" + 
            		"               count++;\r\n" + 
            		"           }\r\n" + 
            		"           while(smaller!=start){\r\n" + 
            		"               smaller=start;\r\n" + 
            		"               for(int i=start+1;i<array.length;i++){\r\n" + 
            		"                   if(array[i]<curr){\r\n" + 
            		"                       smaller++;\r\n" + 
            		"                   }\r\n" + 
            		"               }\r\n" + 
            		"               while (curr==array[smaller]){\r\n" + 
            		"                   smaller++;\r\n" + 
            		"               }\r\n" + 
            		"               if(curr!=array[smaller]){\r\n" + 
            		"                   int temp = curr;\r\n" + 
            		"                   curr=array[smaller];\r\n" + 
            		"                   array[smaller]=temp;\r\n" + 
            		"                   count++;\r\n" + 
            		"               }\r\n" + 
            		"           }\r\n" + 
            		"       }\r\n" + 
            		"   }\r\n" + 
            		"}\r\n" + 
            		"");
            textArea3.setWrapText(true);
            Text stability1=new Text("It is not stable since the order of duplicates values may not be conserved.\n" + 
            		"For example, assuming colour doesn’t affect sorting order, the array\n" + 
            		"4	2	1");
            Text stability2=new Text("	1	");
            stability2.setFill(Color.RED);
            Text stability3=new Text("3\n"+
            		"will be sorted under cyclesort as:\n");
            Text stability4=new Text("1	");
            stability4.setFill(Color.RED);
            Text stability5=new Text("1	2	3	4\r\n" + 
            		"In the original array, the black 1 was before the red 1, but the sorted array gives the red 1 before the black 1.");
            TextFlow textArea4=new TextFlow(stability1,stability2,stability3,stability4,stability5);
            TextArea textArea4lol = new TextArea("It is not stable since the order of duplicates values may not be conserved. \r\n" + 
            		"For example, assuming colour doesn’t affect sorting order, the array\r\n" + 
            		"\r\n" + 
            		"4	2	1	1	3\r\n" + 
            		"\r\n" + 
            		"will be sorted under cyclesort as:\r\n" + 
            		"\r\n" + 
            		"1	1	2	3	4\r\n" + 
            		"\r\n" + 
            		"In the original array, the black 1 was before the red 1, but the sorted array gives the red 1 before the black 1.\r\n" + 
            		"");
            textArea4lol.setWrapText(true);
            TextArea textArea5 = new TextArea("For each element in the list, the program loops through the entire list to find the number of elements that are smaller than the current one. So for each element, to compute it’s position takes time complexity of Θ(n). Thus, sorting all elements is Θ(n2). Worst case space complexity is Θ(1) as elements are only swapped.");
            textArea5.setWrapText(true);
            textArea1.setEditable(false);
            textArea2.setEditable(false);
            textArea3.setEditable(false);
            textArea4lol.setEditable(false);
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
            previous = new Button("<");
            int buttonWidth= (int) Screen.getPrimary().getVisualBounds().getWidth()/25;
            int buttonHeight = (int) Screen.getPrimary().getVisualBounds().getHeight()/15;
            previous.setMinSize(buttonWidth, buttonHeight);
            previous.setPrefSize(buttonWidth, buttonHeight);
            previous.setMaxSize(buttonWidth, buttonHeight);
            previous.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            next = new Button(">");
            next.setMinSize(buttonWidth, buttonHeight);
            next.setPrefSize(buttonWidth, buttonHeight);
            next.setMaxSize(buttonWidth, buttonHeight);
            next.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            play = new Button("Play");
            play.setMinSize(buttonWidth*1.5, buttonHeight);
            play.setPrefSize(buttonWidth*1.5, buttonHeight);
            play.setMaxSize(buttonWidth*1.5, buttonHeight);
            play.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            random = new Button("Random");
            random.setMinSize(buttonWidth*2, buttonHeight);
            random.setPrefSize(buttonWidth*2, buttonHeight);
            random.setMaxSize(buttonWidth*2, buttonHeight);
            random.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.3 * buttonHeight)));
            play.setOnAction(e -> {
            	if(play.getText().matches("Play")) {
	                play.setText("Pause");
	                random.setDisable(true);
	                previous.setDisable(true);
	                next.setDisable(true);
	                try {
	                    cycleSortPane.play();
	                } catch (InterruptedException e1) {
	                    e1.printStackTrace();
	                }
            	}
            	else {
            		play.setText("Play");
            		enableButtons();
            		cycleSortPane.pause();
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
               cycleSortPane.steps(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
               int index=0;
            });
            previous.setOnAction(e -> {
            	cycleSortPane.previous();
            	cycleSortPane.show(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
            });
            next.setOnAction(e -> {
            	cycleSortPane.next();
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
            stage.setTitle("CycleSort");
            stage.show();
         /*   Node divider = splitPane.lookup(".split-pane-divider");
            if(divider!=null){
                divider.setStyle("-fx-background-color: transparent;");
            }
            splitPane.lookupAll(".split-pane-divider").stream()
                    .forEach(div ->  div.setMouseTransparent(true) );
                    */
            cycleSortPane.show(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
            cycleSortPane.steps(Screen.getPrimary().getVisualBounds().getWidth()/2.6,Screen.getPrimary().getVisualBounds().getHeight()/1.3-buttonHeight-70);
        }
        static void enableButtons(){
            random.setDisable(false);
            previous.setDisable(false);
            next.setDisable(false);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }