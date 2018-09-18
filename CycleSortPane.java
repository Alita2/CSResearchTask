package com.company;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CycleSortPane extends Pane {
    Integer[] array = new Integer[99];

    int n=0;
    Rectangle[] rectangles = new Rectangle[99];
    Text[] text = new Text[99];
    public void set(Integer[] a){
        n=0;
        for(int i=0;i<a.length && a[i]!=null;i++){
            array[i]=a[i];
            n++;
        }
    }
    public void show(double width,double height){
        this.getChildren().clear();
        this.setMinHeight(height);
        this.setMaxHeight(height);
        this.setMinWidth(width);
        this.setMaxWidth(width);
        for(int i=0;i<n;i++){
            rectangles[i] = new Rectangle((int) Math.floor((width/n))*i,(int) height/2,(int) Math.floor(width/n),30);
            rectangles[i].setFill(Color.YELLOW);
            rectangles[i].setStroke(Color.BLACK);
            text[i] = new Text((int) (Math.floor((width/n))*i+Math.floor(width/n)/2-Integer.toString(array[i]).length()*3),(int) height/2+20,Integer.toString(array[i]));
            text[i].setFont(Font.font("Segoe UI",12));
            getChildren().addAll(rectangles[i],text[i]);
        }
    }
    public void play(double width,double  height) throws InterruptedException{
        for(int i=0;i<n;i++){
            System.out.println(""+array[i]);
        }
        Text texty = new Text((int) Math.floor(width/(2*n))-3,(int) height/2-40,"");
        Rectangle current = new Rectangle(0,(int) height/2-60,(int) Math.floor(width/n),30);
        current.setFill(Color.YELLOW);
        current.setStroke(Color.BLACK);
        getChildren().addAll(current,texty);
        TranslateTransition[] translateTransitions = new TranslateTransition[999];
        TranslateTransition[] translateTransitions2 = new TranslateTransition[999];
        ParallelTransition[] parallelTransitions = new ParallelTransition[999];
        SequentialTransition sequentialTransition = new SequentialTransition();
        int count = 0;
        int county=0;
        texty.setText(Integer.toString(array[0]));
        for(int start=0;start<n-1;start++) {
            if(start!=0) {
                parallelTransitions[county] = new ParallelTransition();
                SequentialTransition sq = new SequentialTransition();
                SequentialTransition sq2 = new SequentialTransition();
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(900),current);
                FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(900),current);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition3.setFromValue(0.0);
                fadeTransition3.setToValue(1.0);
                fadeTransition3.setCycleCount(1);
                translateTransitions[county] = new TranslateTransition(Duration.millis(10),current);
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (start)));
                translateTransitions[county].setCycleCount(1);
                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(900),texty);
                FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(900),texty);
                fadeTransition2.setFromValue(1.0);
                fadeTransition2.setToValue(0.0);
                fadeTransition2.setCycleCount(1);
                fadeTransition4.setFromValue(0.0);
                fadeTransition4.setToValue(1.0);
                fadeTransition4.setCycleCount(1);
                translateTransitions2[county] = new TranslateTransition(Duration.millis(10),texty);
                translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (start)));
                translateTransitions[county].setCycleCount(1);
                sq.getChildren().addAll(fadeTransition,translateTransitions[county],fadeTransition3);
                sq2.getChildren().addAll(fadeTransition2,translateTransitions2[county],fadeTransition4);
                parallelTransitions[county].getChildren().addAll(sq,sq2);

                final int b=start;
                parallelTransitions[county].setOnFinished(e -> {
                    texty.setText(text[b].getText());
                });

                county++;
            }
            System.out.println("array[start]: " + array[start]);
            int curr = array[start];
            int smaller = start;
            for (int i = start + 1; i < n; i++) {
                if (array[i] < curr) {
                    smaller++;
                }
            }
            if (smaller == start) {
                continue;
                //return;
            }
            while (curr == array[smaller]) {
                smaller++;
            }
            if (smaller != start) {
                parallelTransitions[county] = new ParallelTransition();
                translateTransitions[county] = new TranslateTransition(Duration.millis(1500), current);
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions2[county] = new TranslateTransition(Duration.millis(1500), texty);
                translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                final int z = smaller;
                //final int temp2 = array2[smaller];
                parallelTransitions[county].setOnFinished(e -> {
                    String temp = texty.getText();
                    texty.setText(""+text[z].getText());
                    text[z].setText(temp);
                });
                int temp = curr;
                curr = array[smaller];
                array[smaller] = temp;
                count++;
                county++;
            }
            while (smaller != start) {
                smaller = start;
                for (int i = start + 1; i < n; i++) {
                    if (array[i] < curr) {
                        smaller++;
                    }
                }
                while (curr == array[smaller]) {
                    smaller++;
                }
                if (curr != array[smaller]) {
                    parallelTransitions[county] = new ParallelTransition();
                    translateTransitions[county] = new TranslateTransition(Duration.millis(1500), current);
                    translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions2[county] = new TranslateTransition(Duration.millis(1500), texty);
                    translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                    final int z = smaller;
                    parallelTransitions[county].setOnFinished(e -> {
                        String temp = texty.getText();
                        texty.setText("" + text[z].getText());
                        text[z].setText(temp);
                    });
                    int temp = curr;
                    curr = array[smaller];
                    array[smaller] = temp;
                    count++;
                    county++;
                }
            }
        }
            sequentialTransition = new SequentialTransition();
            for(int i=0;i<county;i++){
                sequentialTransition.getChildren().add(parallelTransitions[i]);
            }
        sequentialTransition.play();
    }
}
