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
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import com.company.CycleSortJavaFX;

public class CycleSortPane extends Pane {
    Integer[] array = new Integer[99];
    Integer[] array2 = new Integer[99];
    Line line = new Line();
    Line leftTop = new Line();
    Line leftBottom = new Line();
    Line rightTop=new Line();
    Line rightBottom = new Line();
    int n=0;
    Text starty;
    Text[] numbering = new Text[99];
    Rectangle[] rectangles = new Rectangle[99];
    Text[] text = new Text[99];
    Text explain1 = new Text();
    Text explain2 = new Text();
    int smaller=0;
    public void set(Integer[] a){
        array = new Integer[99];
        array2 = new Integer[99];
        line = new Line();
        leftTop = new Line();
        leftBottom = new Line();
        rightTop=new Line();
        rightBottom = new Line();
        n=0;
        starty=new Text();
        numbering = new Text[99];
        rectangles = new Rectangle[99];
        text = new Text[99];
        explain1 = new Text();
        explain2 = new Text();
        smaller=0;
        for(int i=0;i<a.length && a[i]!=null;i++){
            array[i]=a[i];
            array2[i]=a[i];
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
        starty = new Text("start");
        starty.setY(height/2+52);
        starty.setX(Math.floor((width / (4*n))));
        getChildren().add(starty);
        for(int i=0;i<n;i++){
            numbering[i]=new Text(""+(i));
            numbering[i].setX(Math.floor((width / (2*n)))+Math.floor((width / (n)))*i);
            numbering[i].setY(height/2+42);
            getChildren().add(numbering[i]);
        }
        line.setStartY(height/2+56);
        line.setEndY(height/2+56);
        line.setStartX(Math.floor((width / (n))));
        line.setEndX(Math.floor((width/n))*n);
        leftBottom.setStartX(Math.floor((width / (n))));
        leftBottom.setStartY(height/2+56);
        leftBottom.setEndX(Math.floor((width / (n)))+3);
        leftBottom.setEndY(height/2+59);
        leftTop.setStartX(Math.floor((width / (n))));
        leftTop.setStartY(height/2+56);
        leftTop.setEndX(Math.floor((width / (n)))+3);
        leftTop.setEndY(height/2+53);
        rightBottom.setStartX(Math.floor((width/n))*n);
        rightBottom.setStartY(height/2+56);
        rightBottom.setEndX(Math.floor((width/n))*n-3);
        rightBottom.setEndY(height/2+59);
        rightTop.setStartX(Math.floor((width/n))*n);
        rightTop.setStartY(height/2+56);
        rightTop.setEndX(Math.floor((width/n))*n-3);
        rightTop.setEndY(height/2+53);
        int curr2 = array[0];
        int smaller2 = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] < curr2) {
                smaller2++;
            }
        }
        while (curr2 == array[smaller2]) {
            smaller2++;
        }
        if(smaller2==0){

        }
        explain1.setText("The number of numbers here <= "+array[0]+" is: "+(smaller2));
        explain1.setY(height/2+72);
        explain1.setWrappingWidth(120);
        explain1.setX(Math.floor(width/n)*(((double) 0)+((double)(n+1))/2.0)-60);
        explain2.setText("Swap values with the element at index start+smaller = "+""+0+"+"+(smaller2)+"="+(smaller2+0));
        explain2.setY(height/2-102);
        explain2.setX(0);
        getChildren().addAll(line,leftTop,leftBottom,rightTop,rightBottom,explain1,explain2);
        //getChildren().addAll(explain1);
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
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000),current);
                FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(1000),current);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition3.setFromValue(0.0);
                fadeTransition3.setToValue(1.0);
                fadeTransition3.setCycleCount(1);
                translateTransitions[county] = new TranslateTransition(Duration.millis(5),current);
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (start)));
                translateTransitions[county].setCycleCount(1);
                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(1000),texty);
                FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(1000),texty);
                fadeTransition2.setFromValue(1.0);
                fadeTransition2.setToValue(0.0);
                fadeTransition2.setCycleCount(1);
                fadeTransition4.setFromValue(0.0);
                fadeTransition4.setToValue(1.0);
                fadeTransition4.setCycleCount(1);
                translateTransitions2[county] = new TranslateTransition(Duration.millis(5),texty);
                translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (start)));
                translateTransitions2[county].setCycleCount(1);
                sq.getChildren().addAll(fadeTransition,translateTransitions[county],fadeTransition3);
                sq2.getChildren().addAll(fadeTransition2,translateTransitions2[county],fadeTransition4);
                parallelTransitions[county].getChildren().addAll(sq,sq2);
                final int b=start;
                final int z = smaller;
                final int[] smaller2 = new int[1];
                smaller2[0]=b;
                final int f =smaller2[0];
                parallelTransitions[county].setOnFinished(e -> {
                    texty.setText(text[b].getText());
                    starty.setX(Math.floor((width / (n))) * (b)+(width/(4*n)));
                    line.setStartX(Math.floor((width/n))*(b+1));
                    leftTop.setStartX(Math.floor((width/n))*(b+1));
                    leftTop.setStartY(height/2+56);
                    leftTop.setEndX(Math.floor((width/n))*(b+1)+3);
                    leftTop.setEndY(height/2+53);
                    leftBottom.setStartX(Math.floor((width/n))*(b+1));
                    leftBottom.setStartY(height/2+56);
                    leftBottom.setEndX(Math.floor((width/n))*(b+1)+3);
                    leftBottom.setEndY(height/2+59);
                    for (int i = b + 1; i < n; i++) {
                        if (Integer.parseInt(text[i].getText()) < Integer.parseInt(texty.getText())) {
                            smaller2[0]++;
                        }
                    }
                    while (Integer.parseInt(texty.getText()) == Integer.parseInt(text[smaller2[0]].getText())) {
                        smaller2[0]++;
                    }
                    explain1.setText("The number of numbers here <= "+array[smaller2[0]]+" is: "+(smaller2[0]-b));
                    explain1.setWrappingWidth(110);
                    explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                    explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0])+"="+(smaller2[0]+b));
                    explain2.setY(height/2-102);
                    explain2.setX(0);
                });

                county++;
            }
            System.out.println("array[start]: " + array[start]);
            int curr = array[start];
            smaller = start;
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
                translateTransitions[county] = new TranslateTransition(Duration.millis(5000), current);
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions[county].pause();
                translateTransitions2[county] = new TranslateTransition(Duration.millis(5000), texty);
                translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                translateTransitions2[county].pause();
                parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                final int z = smaller;
                final int b = start;
                final int curr2=array[start];
                final int[] smaller2 = new int[1];
                smaller2[0]=b;
                int f = smaller2[0];

                parallelTransitions[county].setOnFinished(e -> {
                    String temp = texty.getText();
                    texty.setText(""+text[z].getText());
                    text[z].setText(temp);
                    for (int i = b + 1; i < n; i++) {
                        if (Integer.parseInt(text[i].getText()) < Integer.parseInt(texty.getText())) {
                            smaller2[0]++;
                        }
                    }
                    while (Integer.parseInt(texty.getText()) == Integer.parseInt(text[smaller2[0]].getText())) {
                        smaller2[0]++;
                    }
                    explain1.setText("The number of numbers here <= "+array[smaller2[0]]+" is: "+(smaller2[0]-b));
                    explain1.setWrappingWidth(120);
                    explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                    explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0])+"="+(smaller2[0]+b));
                    explain2.setY(height/2-102);
                    explain2.setX(0);
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
                    translateTransitions[county] = new TranslateTransition(Duration.millis(5000), current);
                    translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions[county].pause();
                    translateTransitions2[county] = new TranslateTransition(Duration.millis(5000), texty);
                    translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    translateTransitions2[county].pause();
                    parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                    final int z = smaller;
                    final int b=start;
                    final int curr2 = array[smaller];
                    final int[] smaller2 = new int[1];
                    smaller2[0] = b;
                    final int f = smaller2[0];
                    parallelTransitions[county].setOnFinished(e -> {
                        String temp = texty.getText();
                        texty.setText("" + text[z].getText());
                        text[z].setText(temp);
                        System.out.println("smaller: "+z);
                        for (int i = b + 1; i < n; i++) {
                            if (Integer.parseInt(text[i].getText()) < Integer.parseInt(texty.getText())) {
                                smaller2[0]++;
                            }
                        }
                        while (Integer.parseInt(texty.getText()) == Integer.parseInt(text[smaller2[0]].getText())) {
                            smaller2[0]++;
                        }
                        explain1.setText("The number of numbers here <= "+array[smaller2[0]]+" is: "+(smaller2[0]-b));
                        explain1.setWrappingWidth(120);
                        explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                        explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0])+"="+(smaller2[0]+b));
                        explain2.setY(height/2-102);
                        explain2.setX(0);
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
            sequentialTransition.setOnFinished(e->{
                CycleSortJavaFX.enableButtons();
                set(array);
            });
    }
}
