import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	// database 
	static DBUser gabrielCredentials = new DBUser("root", "root");
	
	// create nodes
	static Label labelOne = new Label("First Name: ");
	static Label labelTwo = new Label("Last Name: ");
	static Label labelThree = new Label("Age: ");
	static Label labelFour = new Label("SSN: ");
	static Label labelFive = new Label("Credit Card: ");
	
	static TextField fieldOne = new TextField();
	static TextField fieldTwo = new TextField();
	static TextField fieldThree = new TextField();
	static TextField fieldFour = new TextField();
	static TextField fieldFive = new TextField();
	
	static Button buttonOk = new Button("Ok");
	static Button buttonCancel = new Button("Cancel");
	
	@Override
	public void start(Stage primaryStage) {
		alertBox();
	}

	public static void main(String[] args) throws SQLException {
		launch(args);
	}
	
	/**
	 * insert into DB
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param ssn
	 * @param creditCard
	 */
	public static void insert(String firstName, String lastName, String age, String ssn, String creditCard) {

		// Database name
		String dbName = "PEOPLE";

		// person obj
		People person = new People(firstName, lastName, Integer.parseInt(age), Long.parseLong(ssn), Long.parseLong(creditCard));

		// db Instance
		DataBase db = new PeopleDB(person, dbName, DBUser.user, DBUser.pass);

		try {
			db.create();
		} catch (SQLException e2) {
			try {
				
				db.connect();
				((PeopleDB) db).createTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * alert box
	 */
	public static void alertBox() {
		// create grid pane and add nodes
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.add(labelOne, 0, 0);
		pane.add(fieldOne, 1, 0);
		pane.add(labelTwo, 0, 2);
		pane.add(fieldTwo, 1, 2);
		pane.add(labelThree, 0, 3);
		pane.add(fieldThree, 1, 3);
		pane.add(labelFour, 0, 4);
		pane.add(fieldFour, 1, 4);
		pane.add(labelFive, 0, 5);
		pane.add(fieldFive, 1, 5);
		pane.add(buttonOk, 0, 6);
		pane.add(buttonCancel, 1, 6);
		
		// create new stage and set properties
		Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setTitle("Personal Information");
		dialog.setMinHeight(400);
		dialog.setMinWidth(400);
		
		
		// button listeners
		buttonOk.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  	
				String firstName = fieldOne.getText();
				String lastName = fieldTwo.getText();
				String age = fieldThree.getText();
				String ssn = fieldFour.getText();
				String creditCard = fieldFive.getText();
				
				insert(firstName, lastName, age, ssn, creditCard);
		    }
		});
		
		
		buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		dialog.close();
		    }
		});
		
		
		// create new scene and add pane
		Scene personalInfo = new Scene(pane);
		dialog.setScene(personalInfo);
		dialog.showAndWait();
	}

}
