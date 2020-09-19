/**
 * The controller class for adding new product info from GUI into database. Sprint 1 (Alpha)
 *
 * @author Dylan Miles
 * @date 9/19/20
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class Controller {

  @FXML
  private TextField txtProductName;

  @FXML
  private TextField txtManufacturerName;

  @FXML
  private ComboBox<String> cmbQuantity;

  @FXML
  private ChoiceBox<String> cbItemType;

  @FXML
  void btnItemType(MouseEvent event) {

  }

  @FXML
  void addProduct(ActionEvent event) {
    //when button is clicked, connect to database and add products
    connectToDb();
  }

  @FXML
  void recordProduction(ActionEvent event) {

  }

  /**
   * Initializes the database and fills boxes with data options also allows user to enter values
   */
  public void initialize() {
    for (int count = 1; count <= 10; count++) {
      cmbQuantity.getItems().add(String.valueOf(count));
      cmbQuantity.getSelectionModel().selectFirst();
    }
    cmbQuantity.setEditable(true); // allows the user to enter other values

    //adding item types values for user to choose
    cbItemType.getItems().add("AUDIO");
    cbItemType.getItems().add("PHONE");
    cbItemType.getItems().add("COMPUTER");
    cbItemType.getItems().add("VISUAL");
    cbItemType.getSelectionModel().selectFirst();


  }

  /**
   * Connects program to the database Gets and inserts user data from boxes to database Prints
   * database info to console
   */
  public void connectToDb() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    //  Database credentials
    final String USER = ""; // empty database password
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS); // no password set - not secure

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      //getting user input from the txt boxes
      String productName = txtProductName.getText();
      String manufacturerName = txtManufacturerName.getText();
      String typeName = cbItemType.getValue();

      //inserting user input to database
      String insertSql = "INSERT INTO PRODUCT(name, type, manufacturer) " +
          "VALUES ('" + productName + "','" + typeName + "','" + manufacturerName + "')";

      stmt.executeUpdate(insertSql);

      String sql = "SELECT name, type, manufacturer " +
          "FROM PRODUCT ";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        //print database info to console
        System.out.println(rs.getString(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
      }

      // STEP 4: Clean-up environment
      stmt.close(); //should close out of the database
      conn.close(); //close out connection

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
