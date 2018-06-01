package ua.lpnuai.oop.ryvak11;

import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.geometry.HPos;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.layout.*;

import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

import javafx.stage.Window;

import java.io.*;

import java.util.ArrayList;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
public class Main extends Application{
  public static void main1(String[] args)
  {
    launch(args);
  }
  @Override
 public void start(Stage primaryStage) {
		primaryStage.setTitle("Cinema");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new  Insets(25,25,25,25));

		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tahoma",FontWeight.BOLD,20));
		grid.add(sceneTitle, 0, 0,2,1);

		Label name = new Label("Film : ");
		grid.add(name, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		Label director = new Label("Director : ");
		grid.add(director, 0, 2);

		TextField userTextField2 = new TextField();
		grid.add(userTextField2, 1, 2);
		
		Label genre = new Label("Genre : ");
		grid.add(genre, 0, 3);

		TextField userTextField3 = new TextField();
		grid.add(userTextField3, 1, 3);
		
		Label year = new Label("Year : ");
		grid.add(year, 0, 4);

		TextField userTextField4 = new TextField();
		grid.add(userTextField4, 1, 4);
		
		Label rate = new Label("Rate : ");
		grid.add(rate, 0, 5);

		TextField userTextField5 = new TextField();
		grid.add(userTextField5, 1, 5);
		//Label pw = new Label("Password");
		//grid.add(pw, 0, 2);

		//PasswordField pwBox = new PasswordField();
		//grid.add(pwBox, 1, 2);

		Button btn = new Button("OK");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 6);

		final Text actionTarget = new Text();
		grid.add(actionTarget, 1, 6);

		 btn.setOnAction(new EventHandler<ActionEvent>() {

	            @Override

	            public void handle(ActionEvent event) {

	                if(userTextField.getText().isEmpty()) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Please enter film name");

	                    return;

	                }

	                if(userTextField2.getText().isEmpty()) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Please enter director name");

	                    return;

	                }

	                if(userTextField3.getText().isEmpty()) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Please enter genre");

	                    return;

	                }

	                if(userTextField4.getText().isEmpty()) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Please enter a year");

	                    return;

	                }

	                if(userTextField5.getText().isEmpty()) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Please enter a rate");

	                    return;

	                }

	               // if(!isWord(nameField.getText())) {

	                  //  showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your name should contain only letters");

	                  //  return;
//
	            //    }

	                if(!validDate(userTextField4.getText())) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Format of date is DD.MM.YYYY");

	                    return;

	                }

	                if(!isFloat(userTextField5.getText())) {

	                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error", "Rate should be float number");

	                    return;

	                }

	               

	                showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), " ", "Success! ");



	               
	            }

	        });
			Scene scene = new Scene(grid, 500, 600);
			primaryStage.setScene(scene);
			primaryStage.show();

	    }



	    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {

	        Alert alert = new Alert(alertType);

	        alert.setTitle(title);

	        alert.setHeaderText(null);

	        alert.setContentText(message);

	        alert.initOwner(owner);

	        alert.show();

	    }



	    public static void main(String[] args) {

	        launch(args);

	    }



	    public static boolean isWord(String in){

	        return Pattern.matches("[a-zA-Z]+",in);

	    }



	    public static boolean isFloat(String in){

	        return Pattern.matches("[\\-\\+]?[0-9]*(\\.[0-9]+)?",in);

	    }



	    public static boolean validDate(String in){

	        return Pattern.matches("[0-9.,]+",in);

	    }
}

