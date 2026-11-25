package test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class calcolatrice extends Application{
	
	public void start(Stage s) {
		
		TextArea console = new TextArea();
	    GridPane dispButtons = new GridPane();        
		BorderPane root = new BorderPane();
		ArrayList<Button> listOfButtons = new ArrayList<>();
		ArrayList<ColumnConstraints> listOfColumnConstraints = new ArrayList<>();
		ArrayList<RowConstraints> listOfRowConstraints= new ArrayList<>();
		
		for(int i = 0; i<10; i++) {
			listOfButtons.add(new Button(String.valueOf(i)));
		}
		
	    Button bSum = new Button("+");
	    Button bMinus = new Button("-");
	    Button bMul = new Button("*");
	    Button bDiv = new Button("/");
	    Button bDelete = new Button("delete");
	    Button bEqual = new Button("=");
	    
		
		for(int i = 0; i<4; i++) {
			listOfColumnConstraints.add(new ColumnConstraints());
			listOfColumnConstraints.get(i).setPercentWidth(25);
		}
		
		for(int i = 0; i<4; i++) {
			listOfRowConstraints.add(new RowConstraints());
			listOfRowConstraints.get(i).setPercentHeight(25);
		}
		
		
        dispButtons.add(listOfButtons.get(0), 0, 0);
        dispButtons.add(listOfButtons.get(1), 0, 1);
        dispButtons.add(listOfButtons.get(2), 0, 2);
        dispButtons.add(bSum, 0, 3);
        dispButtons.add(listOfButtons.get(3), 1, 0);
        dispButtons.add(listOfButtons.get(4), 1, 1);
        dispButtons.add(listOfButtons.get(5), 1, 2);
        dispButtons.add(bMinus, 1, 3);
        dispButtons.add(listOfButtons.get(6), 2, 0);
        dispButtons.add(listOfButtons.get(7), 2, 1);
        dispButtons.add(listOfButtons.get(8), 2, 2);
        dispButtons.add(bMul, 2, 3);
        dispButtons.add(listOfButtons.get(9), 3, 0);
        dispButtons.add(bEqual, 3, 1);
        dispButtons.add(bDelete, 3, 2);
        dispButtons.add(bDiv, 3, 3);

		
		dispButtons.getColumnConstraints().addAll(listOfColumnConstraints.get(0),listOfColumnConstraints.get(1),listOfColumnConstraints.get(2),listOfColumnConstraints.get(3));
		dispButtons.getRowConstraints().addAll(listOfRowConstraints.get(0),listOfRowConstraints.get(1),listOfRowConstraints.get(2),listOfRowConstraints.get(3));
		
		bEqual.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bSum.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bMinus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bMul.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bDiv.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		for(Button b: listOfButtons) {
			b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);		
		}
		
		
		bSum.setOnAction(event->{
			if((console.getLength() > 0 && console.getText().charAt(console.getLength()-1) != '+') || console.getLength() == 0) {
				console.appendText(bSum.getText());
			}
		});
		
		bDelete.setOnAction(event->{
			if(console.getLength() != 0) {
				console.deleteText(console.getLength()-1, console.getLength());
			}
		});
		
		for(Button b: listOfButtons) {
			b.setOnAction(event->{
				console.appendText(b.getText());
				
			});
		}

        
        root.setCenter(dispButtons);
    	root.setTop(console);
    	
    	Scene scene = new Scene(root, 1000, 700);
    	s.setTitle("calcolatrice");
    	s.setScene(scene);
    	s.show();
		

	}

}
