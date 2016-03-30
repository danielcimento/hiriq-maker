import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import javax.swing.*;
import java.util.stream.IntStream;

/**
 * Created by Daniel on 2016-03-29.
 */
public class HiRiQMakr extends Application {
    public static void main(String[] args){
        launch(args);
    }

    class dButton extends Button {
        int number;
        public dButton(int n){
            number = n;
            this.setText("B");

        }
    }
    TextField stringOutput = new TextField("");
    dButton[] buttons = new dButton[33];
    boolean[] output = new boolean[33];

    @Override
    public void start(Stage stage){
        stringOutput.setMaxWidth(250);
        for(int i = 0; i < 33; i++){
            buttons[i] = new dButton(i);
            buttons[i].setMinWidth(50);
            buttons[i].setMinHeight(50);
            final int n = i;
            buttons[i].setOnAction(e -> {
                click(output, n);
                updateArray(stringOutput, output);
                if(buttons[n].getText().equals("B"))
                    buttons[n].setText("W");
                else
                    buttons[n].setText("B");
            });
        }
        HBox topRow = new HBox(10);
        topRow.getChildren().addAll(buttons[0], buttons[1], buttons[2]);
        topRow.setAlignment(Pos.CENTER);
        HBox secondRow = new HBox(10);
        secondRow.getChildren().addAll(buttons[3], buttons[4], buttons[5]);
        secondRow.setAlignment(Pos.CENTER);
        HBox thirdRow = new HBox(10);
        thirdRow.setAlignment(Pos.CENTER);
        VBox topTwo = new VBox(10);

        topTwo.getChildren().addAll(topRow, secondRow);


        thirdRow.getChildren().addAll(buttons[6], buttons[7], buttons[8], buttons[9], buttons[10], buttons[11], buttons[12]);
        HBox fourthRow = new HBox(10);
        fourthRow.setAlignment(Pos.CENTER);
        fourthRow.getChildren().addAll(buttons[13], buttons[14], buttons[15], buttons[16], buttons[17], buttons[18], buttons[19]);
        HBox fifthRow = new HBox(10);
        fifthRow.setAlignment(Pos.CENTER);
        fifthRow.getChildren().addAll(buttons[20], buttons[21], buttons[22], buttons[23], buttons[24], buttons[25], buttons[26]);
        VBox middleThree = new VBox(10);
        middleThree.getChildren().addAll(thirdRow, fourthRow, fifthRow);
        HBox sixthRow = new HBox(10);
        sixthRow.setAlignment(Pos.CENTER);
        sixthRow.getChildren().addAll(buttons[27], buttons[28], buttons[29]);
        HBox seventhRow = new HBox(10);
        seventhRow.getChildren().addAll(buttons[30], buttons[31], buttons[32]);
        seventhRow.setAlignment(Pos.CENTER);
        VBox lastTwo = new VBox(10);

        lastTwo.getChildren().addAll(sixthRow, seventhRow);

        VBox buttonsAndString = new VBox(10);
        buttonsAndString.setAlignment(Pos.CENTER);
        buttonsAndString.getChildren().addAll(topTwo, middleThree, lastTwo);
        VBox buttonsAndStringScene = new VBox(50);
        StackPane string = new StackPane();
        string.getChildren().add(stringOutput);
        string.setAlignment(Pos.CENTER);
        buttonsAndStringScene.getChildren().addAll(buttonsAndString, string);
        topTwo.setAlignment(Pos.CENTER);
        lastTwo.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(buttonsAndStringScene, 500, 500);
        stage.setScene(mainScene);
        stage.setTitle("HiRiQ Makr");
        stage.show();
    }

    public static void updateArray(TextField t, boolean[] x){
        int a=1;
        int config=0;
        for (int i=1; i<32; i++)
        {
            if (x[i]) {config=config+a;}
            a=2*a;
        }
        if (x[32]) {config=-config;}
        t.setText(config + "");
    }

    public void click(boolean[] input, int n){
        input[n] = !input[n];
    }
}
