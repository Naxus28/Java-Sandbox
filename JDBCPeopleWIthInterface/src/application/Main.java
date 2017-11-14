package application;

import java.util.List;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	static String dbName = "PEOPLE";
	

	@Override
	public void start(Stage fxDefaultStage) {
		
		// buttons
		Button createDB = new Button("Create new database");
		Button createTable = new Button("Create new table");
		Button insert = new Button("Insert new entry");
		Button delete = new Button("Delete entry");
		Button findAll = new Button("Find all entries");
		Button findOne  = new Button("Find one entry");
		
		// button listeners
		createDB.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		insertUserPanel();
		    }
		});
		
		createTable.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		insertUserPanel();
		    }
		});
		
		
		insert.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		insertUserPanel();
		    }
		});
		
		delete.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		deleteUserPanel();
		    }
		});
		
		
		findAll.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				findALl();
		    }
		});
		
		findOne.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    		findOneUserPanel();
		    }

		});
		
		// pane
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(5);
		pane.setVgap(25);

		// add buttons to pane
		pane.add(createDB, 0, 0);
		pane.add(createTable, 0, 1);
		pane.add(insert, 0, 2);
		pane.add(delete, 0, 3);
		pane.add(findAll, 0, 4);
		pane.add(findOne, 0, 5);
		
		// scene
		Scene scene = new Scene(pane,  500, 500);
		
		// stage
		fxDefaultStage.setTitle("Choose an action");
		fxDefaultStage.setScene(scene);
		
		// adds style sheet to scene-- after scene is added to stage
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		fxDefaultStage.show();
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
	public static void insertPerson(String firstName, String lastName, String age, String ssn, String creditCard)
			throws SQLException {

		// person obj
		People person = new People(firstName, lastName, Integer.parseInt(age), Long.parseLong(ssn),
				Long.parseLong(creditCard));

		//// create DB instance with second overloaded constructor
		db = new PeopleDB(person, dbName, dbCredentials.getUser(), dbCredentials.getPass());

		// use once for every new DB
		// createDB();

		// use once for every new table
		// createTable();

		db.connect();
		db.insert("PERSON");
		db.getConn().close();
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
	 * insert user panel
	 */
	public void insertUserPanel() {
		// labels
		Label labelOne = new Label("First Name: ");
		Label labelTwo = new Label("Last Name: ");
		Label labelThree = new Label("Age: ");
		Label labelFour = new Label("SSN: ");
		Label labelFive = new Label("Credit Card: ");

		// inputs
		TextField fieldOne = new TextField();
		TextField fieldTwo = new TextField();
		TextField fieldThree = new TextField();
		TextField fieldFour = new TextField();
		TextField fieldFive = new TextField();

		// buttons
		Button buttonOk = new Button("Ok");
		Button buttonCancel = new Button("Cancel");
		
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
		dialog.setMinHeight(500);
		dialog.setMinWidth(500);

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
					insertPerson(firstName, lastName, age, ssn, creditCard);
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
					System.out.println("DB Connection closed.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// create new scene and add pane
		Scene personalInfo = new Scene(pane);
		dialog.setScene(personalInfo);
		
		personalInfo.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialog.showAndWait();
	}
	
	/**
	 * find all and print
	 */
	private void findALl() {
		// create DB instance with first overloaded constructor
		db = new PeopleDB("PEOPLE", dbCredentials.getUser(), dbCredentials.getPass());
		
		try {
			db.connect();
			List<People> results = db.findAll("PERSON");

			
			for(People person : results) {
				System.out.println("\n" + person);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * delete user panel
	 */
	public void deleteUserPanel() {
		
		// create DB instance with first overloaded constructor
		db = new PeopleDB("PEOPLE", dbCredentials.getUser(), dbCredentials.getPass());
		
		// labels
		Label labelOne = new Label("Enter ssn: ");

		// inputs
		TextField fieldOne = new TextField();

		// buttons
		Button buttonDelete = new Button("Delete");
		Button buttonCancel = new Button("Cancel");
		
		// create grid pane and add nodes
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.add(labelOne, 0, 0);
		pane.add(fieldOne, 1, 0);
		pane.add(buttonDelete, 0, 2);
		pane.add(buttonCancel, 1, 2);

		// create new stage and set properties
		Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setTitle("Personal Information");
		dialog.setMinHeight(500);
		dialog.setMinWidth(500);

		// button ok listener
		buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String ssn = fieldOne.getText();

				try {
					db.connect();
					db.deleteOne(ssn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					clearInputs();
				}
			}
			
			/**
			 * clear inputs
			 */
			private void clearInputs() {
				fieldOne.setText("");
			}
		});

		// button cancel listener
		buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				dialog.close();
				
				try {
					db.getConn().close();
					System.out.println("DB Connection closed.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// create new scene and add pane
		Scene personalInfo = new Scene(pane);
		dialog.setScene(personalInfo);
		
		personalInfo.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialog.showAndWait();
	}
	
	/**
	 * find one entry panel
	 */
	private void findOneUserPanel()  {
		// create DB instance with first overloaded constructor
		db = new PeopleDB("PEOPLE", dbCredentials.getUser(), dbCredentials.getPass());
		
		// labels
		Label labelOne = new Label("Enter ssn: ");

		// inputs
		TextField fieldOne = new TextField();

		// buttons
		Button buttonDelete = new Button("Delete");
		Button buttonCancel = new Button("Cancel");
		
		// create grid pane and add nodes
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.add(labelOne, 0, 0);
		pane.add(fieldOne, 1, 0);
		pane.add(buttonDelete, 0, 2);
		pane.add(buttonCancel, 1, 2);

		// create new stage and set properties
		Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setTitle("Personal Information");
		dialog.setMinHeight(500);
		dialog.setMinWidth(500);

		// button ok listener
		buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String ssn = fieldOne.getText();

				try {
					db.connect();
					db.findOne(ssn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					clearInputs();
				}
			}
			
			/**
			 * clear inputs
			 */
			private void clearInputs() {
				fieldOne.setText("");
			}
		});

		// button cancel listener
		buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				dialog.close();
				
				try {
					db.getConn().close();
					System.out.println("DB Connection closed.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// create new scene and add pane
		Scene personalInfo = new Scene(pane);
		dialog.setScene(personalInfo);
		
		personalInfo.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialog.showAndWait();
	}

}
