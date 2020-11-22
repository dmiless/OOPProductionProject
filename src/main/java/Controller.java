/*
 * The controller class for adding new product info from GUI into database and displaying back to
 * GUI.
 *
 * @author Dylan Miles
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;




public class Controller {

  /**
   * The int to hold the count of audio items added.
   */
  public static int audioCount = 0;
  /**
   * The int to hold the count of visual items added.
   */
  public static int visualCount = 0;
  /**
   * The int to hold the number of created products.
   */
  private int createdProducts = 0;
  /**
   * The boolean expression to check that all fields are filled out.
   */
  private boolean emptyFields = false;
  /**
   * The ObservableList to hold the list of created products.
   */
  private ObservableList<Product> productLine = FXCollections.observableArrayList();
  /**
   * The ObservableList to hold the list of created product records.
   */
  private ObservableList<ProductionRecord> productionRun = FXCollections.observableArrayList();
  /**
   * The ObservableList to hold the list of employees created.
   */
  private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

  /**
   * The txtField to hold the product's name from UI.
   */
  @FXML
  private TextField txtProductName;
  /**
   * The txtField to hold the manufacturer's name from UI.
   */
  @FXML
  private TextField txtManufacturerName;
  /**
   * The ComboBox to hold the quantity of an item from UI.
   */
  @FXML
  private ComboBox<String> cmbQuantity;
  /**
   * The ChoiceBox to hold the item's type from UI.
   */
  @FXML
  private ChoiceBox<ItemType> cbItemType;
  /**
   * The TableView to display selected info to UI.
   */
  @FXML
  private TableView<Product> tableView;
  /**
   * The TableColumn to set column to the product's name.
   */
  @FXML
  private TableColumn<?, Product> colProduct;
  /**
   * The TableColumn to set column to the manufacturer's name.
   */
  @FXML
  private TableColumn<?, Product> colManu;
  /**
   * The TableColumn to set column to the product's ItemType.
   */
  @FXML
  private TableColumn<?, Product> colType;
  /**
   * The ListView to display selected info to list in UI.
   */
  @FXML
  private ListView<Product> listView;
  /**
   * The TextArea to display the appended product info to UI.
   */
  @FXML
  private TextArea proLog;

  @FXML
  void btnItemType(MouseEvent event) {

  }

  @FXML
  private Button btnAddEmployee;
  /**
   * The TextField to get employee UserName from user input.
   */
  @FXML
  private TextField txtUserName;
  /**
   * The TextField to get employee password from user input.
   */
  @FXML
  private TextField txtPassword;

  /**
   * addEmployee method that takes in quantity user input from GUI then adds the new data to
   * employeeList as long as input is not empty.
   *
   * @param event - button action event
   * @returns void
   */
  @FXML
  void addEmployee(ActionEvent event) {
    if (!(txtUserName.getText().equals("")) && !txtPassword.getText().equals("")) {
      emptyFields = false;
      employeeList.add(new Employee(txtUserName.getText(), txtPassword.getText()));

    } else {
      emptyFields = true;
      System.out.println("Error: Fields are empty. Login failed");

    }
    System.out.println(employeeList);

  }

  /**
   * addProduct method that takes in quantity user input from GUI then adds the new data to
   * productLine as long as input is not empty.
   *
   * @param event - button action event
   * @returns void
   */
  @FXML
  void addProduct(ActionEvent event) {
    //when button is clicked, connect to database and add products from txtFields
    if (!(txtProductName.getText().equals("")) && !(txtManufacturerName.getText().equals(""))
        && !(cbItemType.getValue() == null)) {
      emptyFields = false;
      productLine.add(new Widget(txtProductName.getText(), txtManufacturerName.getText(),
          cbItemType.getValue(), productLine.size() + 1));
    } else {
      emptyFields = true;
      System.out.println("Error: Fields are empty. Product not added.");

    }

    connectToDb(0); //insert data into database

    setupTable(); //update tables with new product

  }

  /**
   * The int Quantity to hold the amount of items produced from cmbQuantity.
   */
  private int quantity = 0;

  /**
   * recordProduction method that takes in quantity user input from GUI then adds the new data to
   * productionRun.
   *
   * @param event - button action event
   * @returns void
   */
  @FXML
  void recordProduction(ActionEvent event) {

    try {
      quantity = Integer.parseInt(cmbQuantity.getValue());
      for (int productMade = 0; productMade < quantity; productMade++) {

        ObservableList<Product> topics;
        topics = listView.getSelectionModel().getSelectedItems();

        for (Product each : topics) {
          productionRun.add(
              new ProductionRecord(each,
                  createdProducts));
        }

        createdProducts++;
        connectToDb(1); //insert new data into database
        updateTxt(); //update txt tables

      }

    } catch (Exception e) {
      System.out.println("Print Error ");
    }

  }

  /**
   * Initializes the database with previous data fills ItemType boxes with data options also allows
   * user to enter their own values.
   */
  public void initialize() {

    for (int count = 1; count <= 10; count++) {
      cmbQuantity.getItems().add(String.valueOf((count)));
      cmbQuantity.getSelectionModel().selectFirst();
    }
    cmbQuantity.setEditable(true); // allows the user to enter other values

    //adding item types values for user to choose
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.AUDIO)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.VISUAL)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.AUDIO_MOBILE)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.VISUAL_MOBILE)));
    cbItemType.getSelectionModel().selectFirst();

    connectToDb(2); //read data from the database

    setupTable(); //initialize tables with data
    updateTxt(); //update txt areas with stored data
  }

  /**
   * Connects program to the database Gets and inserts user data from boxes to database also
   * retrieves certain data depending on the direction.
   *
   * @param direction - to define what is required with the databases returns void
   */
  public void connectToDb(int direction) {
    final String jdbc_Driver = "org.h2.Driver";
    final String db_url = "jdbc:h2:./res/HR";

    //  Database credentials
    final String user = ""; // empty database password
    final String pass = "";
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbc_Driver);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_url, user, pass); // no password set - not secure

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      //getting user input from the txt boxes
      if (direction == 0 && !emptyFields) {
        //inserting user input to database
        sql = "INSERT INTO PRODUCT(name, type, manufacturer)"
            + " VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, txtProductName.getText());
        ps.setString(2, String.valueOf(cbItemType.getValue()));
        ps.setString(3, txtManufacturerName.getText());

        ps.executeUpdate();
        ps.close();
      } else if (direction == 1) {
        //inserting user input to database
        sql =
            "INSERT INTO PRODUCTIONRECORD(PRODUCTION_NUM, PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)"
                + " VALUES (?, ?, ?, ?)";

        ProductionRecord record = productionRun.get(productionRun.size() - 1);
        ps = conn.prepareStatement(sql);

        ps.setInt(1, createdProducts - 1);
        ps.setInt(2, record.getProductid());
        ps.setString(3, record.getSerialNum());
        ps.setTimestamp(4, new Timestamp(record.getProdDate().getTime()));

        ps.executeUpdate();
        ps.close();
      } else if (direction == 2) {

        sql = "SELECT * FROM PRODUCT";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
          productLine.add(new Widget(rs.getString(2), rs.getString(4),
              ItemType.setItemType(rs.getString(3)), rs.getInt(1)));
        }

        sql = "SELECT * FROM PRODUCTIONRECORD";

        rs = stmt.executeQuery(sql);

        while (rs.next()) {
          ProductionRecord record = new ProductionRecord(rs.getInt(1), rs.getInt(2),
              rs.getString(3), rs.getTimestamp(4));
          // check the item type of the product and increment the count
          if (rs.getString(3).contains("AU") || rs.getString(3).contains("AM")) {
            audioCount++;
          } else if (rs.getString(3).contains("VI") || rs.getString(3).contains("VM")) {
            visualCount++;
          } else {
            System.out.println("Error: Invalid ItemType");
          }

          //set the name of the item to be displayed from the productID
          loadName(record.getProductid(), record);

          productionRun.add(record);

        }

        createdProducts = productionRun.size();
        rs.close();
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

  /**
   * The boolean expression to update the txt areas once during initialization.
   */
  boolean once = true;

  /**
   * updateTxt method to update the textarea of proLog with recorded records in productionRun.
   */
  public void updateTxt() {

    if (once) {
      for (ProductionRecord record : productionRun) {
        proLog.appendText(record + "\n");
        once = false;
      }
    } else {
      int i = 0;
      for (ProductionRecord record : productionRun) {
        if (i++ == productionRun.size() - 1) {
          proLog.appendText(record + "\n");
          once = false;
        }

      }
    }

  }

  /**
   * The loadName method for setting the product name from the product's ID.
   *
   * @param productid - ID from the product
   * @param record    - the instance of the ProductionRecord class returns void
   */
  public void loadName(int productid, ProductionRecord record) {

    for (int j = 0; j < productLine.size(); j++) {
      if (productLine.get(j).getId() == productid) {
        record.setProductName(productLine.get(j).getName());
        break; // break once name is found
      }
    }
  }

  /**
   * setupTable method to set up the columns of produce tab and set the items of productLine to both
   * tableView + listView.
   */
  public void setupTable() {
    colProduct.setCellValueFactory(new PropertyValueFactory("Name"));
    colManu.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
    colType.setCellValueFactory(new PropertyValueFactory("Type"));

    //set items in both tableView and listView from the productLine
    tableView.setItems(productLine);
    listView.setItems(productLine);
  }

}
