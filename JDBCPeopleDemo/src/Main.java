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
	static DBUser dbCredentials = new DBUser("root", "UFPhD2012");
	static DataBase db;

	// labels
	static Label labelOne = new Label("First Name: ");
	static Label labelTwo = new Label("Last Name: ");
	static Label labelThree = new Label("Age: ");
	static Label labelFour = new Label("SSN: ");
	static Label labelFive = new Label("Credit Card: ");

	// inputs
	static TextField fieldOne = new TextField();
	static TextField fieldTwo = new TextField();
	static TextField fieldThree = new TextField();
	static TextField fieldFour = new TextField();
	static TextField fieldFive = new TextField();

	// buttons
	static Button buttonOk = new Button("Ok");
	static Button buttonCancel = new Button("Cancel");

	@Override
	public void start(Stage primaryStage) {
		modalWindow();
	}

	public static void main(String[] args) throws SQLException {
		launch(args);
	}

	/**
	 * insert into DB
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param ssn
	 * @param creditCard
	 * @throws SQLException
	 */
	public static void insert(String firstName, String lastName, String age, String ssn, String creditCard)
			throws SQLException {

		// Database name
		String dbName = "PEOPLE";

		// person obj
		People person = new People(firstName, lastName, Integer.parseInt(age), Long.parseLong(ssn),
				Long.parseLong(creditCard));

		// db Instance
		db = new PeopleDB(person, dbName, dbCredentials.getUser(), dbCredentials.getPass());

		// use once for every new DB
		// createDB();

		// use once for every new table
		// createTable();

		db.connect();
		db.insert("PERSON");
	}

	@SuppressWarnings("unused")
	private static void createDB() {
		try {
			db.create();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void createTable() {
		try {
			db.connect();
			((PeopleDB) db).createTable();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * alert box
	 */
	public static void modalWindow() {
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

		// button ok listener
		buttonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String firstName = fieldOne.getText();
				String lastName = fieldTwo.getText();
				String age = fieldThree.getText();
				String ssn = fieldFour.getText();
				String creditCard = fieldFive.getText();

				try {
					insert(firstName, lastName, age, ssn, creditCard);
					clearInputs();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			/**
			 * clear inputs
			 */
			private void clearInputs() {
				fieldOne.setText("");
				fieldTwo.setText("");
				fieldThree.setText("");
				fieldFour.setText("");
				fieldFive.setText("");
			}
		});

		// button cancel listener
		buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				dialog.close();
				 try {
					db.getConn().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				 System.out.println("DB Connection closed.");
			}
		});

		// create new scene and add pane
		Scene personalInfo = new Scene(pane);
		dialog.setScene(personalInfo);
		dialog.showAndWait();
	}

}
