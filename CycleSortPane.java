import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;


public class CycleSortPane extends Pane {
    Integer[] array = new Integer[99];
    Integer[] array2 = new Integer[99];
    Line line = new Line();
    Line leftTop = new Line();
    Line leftBottom = new Line();
    Line rightTop=new Line();
    Line rightBottom = new Line();
    int n=0;
    int steps=0;
    String[] textys = new String[999];
    Text starty;
    Text[] numbering = new Text[99];
    Rectangle[] rectangles = new Rectangle[99];
    Text[] text = new Text[99];
    Text explain1 = new Text();
    Text explain2 = new Text();
    int smaller=0;
    int smaller3=0;
    int[] smallers = new int[99];
    String[] currents = new String[99];
    int county=0;
    List<Animation> transitions = new ArrayList<>();
    double width,height;
    Integer[][] arrays=new Integer[99][9];
    boolean[] isAnnoying = new boolean[999];
    String moving[]=new String[99];
    ParallelTransition[] parallelTransitions;
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
    public void resetRectangle(){
        TranslateTransition tt = new TranslateTransition(Duration.millis(2),current);
        tt.setToX(0);
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(2),texty);
        tt2.setToX((int) Math.floor(Math.floor(width/(2*n))/2-Integer.toString(array2[0]).length()*3));
        tt.play();
        tt2.play();
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
        int curr2=array[0];
        if(moving[step]!=null) {
        	curr2 = Integer.parseInt(moving[step]);
        }
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
        explain1.setText("The number of numbers here <= "+curr2+" is: "+(smaller2));
        explain1.setY(height/2+72);
        explain1.setWrappingWidth(120);
        explain1.setX(Math.floor(width/n)*(((double) 0)+((double)(n+1))/2.0)-60);
        explain2.setText("Swap values with the element at index start+smaller = "+""+0+"+"+(smaller2)+"="+(smaller2+0));
        explain2.setY(height/2-102);
        explain2.setX(0);
        getChildren().addAll(line,leftTop,leftBottom,rightTop,rightBottom,explain1,explain2);
        if(texty==null) {
        	texty = new Text((int) Math.floor(width/(2*n))-3,(int) height/2-40,"");
        	current = new Rectangle(0,(int) height/2-60,(int) Math.floor(width/n),30);
        }
        else{
        	texty.setText(moving[step]);
        }
        current.setFill(Color.YELLOW);
        current.setStroke(Color.BLACK);
        getChildren().addAll(current,texty);
        //getChildren().addAll(explain1);
    }
    public void showy(double width,double height){
        getChildren().clear();
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
        for(int i=0;i<n;i++){
            numbering[i]=new Text(""+(i));
            numbering[i].setX(Math.floor((width / (2*n)))+Math.floor((width / (n)))*i);
            numbering[i].setY(height/2+42);
            getChildren().add(numbering[i]);
        }
        if(texty==null) {
            texty = new Text((int) Math.floor(width/(2*n))-3,(int) height/2-40,"");
            current = new Rectangle(0,(int) height/2-60,(int) Math.floor(width/n),30);
        }
        else{
            texty.setText(moving[step]);
        }
        current.setFill(Color.YELLOW);
        current.setStroke(Color.BLACK);
        getChildren().addAll(current,texty);
    }
    Text texty;
    Rectangle current;
    public void steps(double width,double  height) {
        currents[0]=Integer.toString(array[0]);
        this.width=width;
        this.height=height;
    	step=0;
    	for(int i=0;i<n;i++){
            System.out.println(""+array[i]);
        }
        TranslateTransition[] translateTransitions = new TranslateTransition[999];
        TranslateTransition[] translateTransitions2 = new TranslateTransition[999];
        parallelTransitions = new ParallelTransition[999];
        int count = 0;
        county=0;
        texty.setText(Integer.toString(array[0]));
        moving[0]=Integer.toString(array[0]);
        arrays[0]=Arrays.copyOf(array, array.length);
        for(int start=0;start<n-1;start++) {
            if(start!=0) {
                parallelTransitions[county] = new ParallelTransition();
                SequentialTransition sq = new SequentialTransition();
                SequentialTransition sq2 = new SequentialTransition();
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(2495),current);
                FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(2495),current);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(1);
                fadeTransition3.setFromValue(0.0);
                fadeTransition3.setToValue(1.0);
                fadeTransition3.setCycleCount(1);
                translateTransitions[county] = new TranslateTransition(Duration.millis(5),current);
                translateTransitions[county].setFromX(((int) Math.floor((width / (n))) * (smaller3+1)));
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (start)));
                translateTransitions[county].setCycleCount(1);
                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(2495),texty);
                FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(2495),texty);
                fadeTransition2.setFromValue(1.0);
                fadeTransition2.setToValue(0.0);
                fadeTransition2.setCycleCount(1);
                fadeTransition4.setFromValue(0.0);
                fadeTransition4.setToValue(1.0);
                fadeTransition4.setCycleCount(1);
                translateTransitions2[county] = new TranslateTransition(Duration.millis(5),texty);
                translateTransitions2[county].setFromX(((int) Math.floor((width / (n))) * (smaller3+1)));
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
                moving[county+1]=text[b].getText();
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
                    explain1.setText("The number of numbers here <= "+texty.getText()+" is: "+(smaller2[0]-b));
                    explain1.setWrappingWidth(110);
                    explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                    explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0]-b)+"="+(smaller2[0]));
                    explain2.setY(height/2-102);
                    explain2.setX(0);
                    step++;
                });
                arrays[county+1]=Arrays.copyOf(array,array.length);
                currents[county+1]=text[b].getText();
                isAnnoying[county]=true;
                county++;
                smaller3=smaller;
            }
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
                translateTransitions[county].setFromX((int) Math.floor((width / (n))) * (smaller3));
                translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions[county].pause();
                translateTransitions2[county] = new TranslateTransition(Duration.millis(5000), texty);
                translateTransitions2[county].setFromX((int) Math.floor((width / (n))) * (smaller3));
                translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                translateTransitions2[county].pause();
                parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                final int z = smaller;
                final int b = start;
                final int curr2=array[start];
                final int[] smaller2 = new int[1];
                smaller2[0]=b;
                int f = smaller2[0];
                moving[county+1]=text[z].getText();
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
                    explain1.setText("The number of numbers here <= "+texty.getText()+" is: "+(smaller2[0]-b));
                    explain1.setWrappingWidth(120);
                    explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                    explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0]-b)+"="+(smaller2[0]));
                    explain2.setY(height/2-102);
                    explain2.setX(0);
                    step++;
                });
                int temp = curr;
                curr = array[smaller];
                array[smaller] = temp;
                arrays[county+1]=Arrays.copyOf(array,array.length);
                currents[county+1]=text[z].getText();
                smallers[county+1]=smaller;
                count++;
                isAnnoying[county]=false;
                county++;
                smaller3=smaller;
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
                    translateTransitions[county].setFromX((int) Math.floor((width / (n))) * (smaller3));
                    translateTransitions[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions[county].pause();
                    translateTransitions2[county] = new TranslateTransition(Duration.millis(5000), texty);
                    translateTransitions2[county].setFromX((int) Math.floor((width / (n))) * (smaller3));
                    translateTransitions2[county].setToX(((int) Math.floor((width / (n))) * (smaller)));
                    translateTransitions2[county].pause();
                    parallelTransitions[county].getChildren().addAll(translateTransitions[county], translateTransitions2[county]);
                    final int z = smaller;
                    final int b=start;
                    final int curr2 = array[smaller];
                    final int[] smaller2 = new int[1];
                    smaller2[0] = b;
                    final int f = smaller2[0];
                    moving[county+1]=text[z].getText();
                    parallelTransitions[county].setOnFinished(e -> {
                    	smaller2[0] = b;
                        String temp = texty.getText();
                        texty.setText("" + text[z].getText());
                        text[z].setText(temp);
                        for (int i = b + 1; i < n; i++) {
                            if (Integer.parseInt(text[i].getText()) < Integer.parseInt(texty.getText())) {
                                smaller2[0]++;
                            }
                        }
                        while (Integer.parseInt(texty.getText()) == Integer.parseInt(text[smaller2[0]].getText())) {
                            smaller2[0]++;
                        }
                        explain1.setText("The number of numbers here <= "+texty.getText()+" is: "+(smaller2[0]-b));
                        explain1.setWrappingWidth(120);
                        explain1.setX(Math.floor(width/n)*(((double) b)+((double)(n-b+1))/2.0)-60);
                        explain2.setText("Swap values with the element at index start+smaller = "+""+b+"+"+(smaller2[0]-b)+"="+(smaller2[0]));
                        explain2.setY(height/2-102);
                        explain2.setX(0);
                        step++;
                    });
                    int temp = curr;
                    curr = array[smaller];
                    array[smaller] = temp;
                    arrays[county+1]=Arrays.copyOf(array,array.length);
                    currents[county+1]=text[z].getText();
                    smallers[county+1]=smaller;
                    count++;
                    isAnnoying[county]=false;
                    county++;
                    smaller3=smaller;
                }
            }
        }
    }
    
    SequentialTransition sequentialTransition;
    int step=0;
    
    public void play() throws InterruptedException{
    	sequentialTransition = new SequentialTransition();
            sequentialTransition = new SequentialTransition();
            for(int i=step;i<county;i++){
                sequentialTransition.getChildren().add(parallelTransitions[i]);
            }
        sequentialTransition.play();
            sequentialTransition.setOnFinished(e->{
                CycleSortJavaFX.enableAllButtons();
                set(array);
                CycleSortJavaFX.play.setText("Play");
            });
    }
    
    public void pause() {
    	sequentialTransition.pause();
    }
    public void next() {
        String x = texty.getText();
        textys[steps]=x;
        for(int i=0;i<county;i++){
            System.out.println(isAnnoying[i]);
        }
        if(steps<=county) {
            CycleSortJavaFX.disableAllButtons();
            set(arrays[(steps)]);
            if(isAnnoying[steps]==false) {
                show(width,height);
                texty.setText(currents[steps]);
                parallelTransitions[steps].play();
            }
            else{
                showy(width,height);
                texty.setText(x);
                parallelTransitions[steps].play();
            }
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(5000));
            pauseTransition.setOnFinished(e->{
                CycleSortJavaFX.enableAllButtons();
            });
            pauseTransition.play();
            steps++;
        }
    }
    
    public void previous() {
        if(steps!=0 && steps!=1 && steps<=county) {
            CycleSortJavaFX.disableAllButtons();
            System.out.println("nani: "+currents[steps-2]);
            set(arrays[(steps - 2)]);
            if(isAnnoying[steps]==false) {
                show(width,height);
                texty.setText(currents[steps - 2]);
            }
            else{
                showy(width,height);
                texty.setText(textys[steps-2]);
            }
            parallelTransitions[steps-2].play();
            PauseTransition pauseTransition = new PauseTransition(Duration.millis(5000));
            pauseTransition.setOnFinished(e->{
                CycleSortJavaFX.enableAllButtons();
            });
            pauseTransition.play();
            steps--;
        }

    }
}