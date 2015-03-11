package gui;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
 
public class ColorPickingScreen extends Application {    
	
	private static Color color;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("ColorPicker");
        Scene scene = new Scene(new HBox(20), 250, 45);
        HBox box = (HBox) scene.getRoot();
        box.setPadding(new Insets(5, 5, 5, 5));          
             
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);
        
        final Text text = new Text("Select a Color");
        text.setFont(Font.font ("Verdana", 25));
        text.setFill(Color.BLACK);
        
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {  
                //System.out.println(colorPicker.getValue());
                setColor(colorPicker.getValue());
                
            }

			

        });
 
        box.getChildren().addAll(colorPicker, text);
 
        stage.setScene(scene);
        stage.show();
    }


	public Color getColor() {
		return color;
	}

	public static void setColor(Color color) {
		ColorPickingScreen.color = color;
	}
    
    
    
    
    
}